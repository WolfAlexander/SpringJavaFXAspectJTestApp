package aspect;

import exception.MessageArgumentException;
import exception.UsernameArgumentException;
import integration.MessageJDBCTemplate;
import model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

@Aspect
public class MessageJDBCTemplateAspect {
    private static Logger logger = LogManager.getLogger(MessageJDBCTemplate.class);

    @AfterReturning("execution(* integration.MessageJDBCTemplate.setDataSource(..))")
    public void afterSetDataSource(){
        logger.info("Data Sources are inset. MessageJDBCTemplate is ready! ");
    }

    @AfterThrowing(pointcut = "execution(* integration.MessageJDBCTemplate.addMessage(..))", throwing = "ex")
    public void illegalArgumentInAddMessage(IllegalArgumentException ex){
        if(ex instanceof UsernameArgumentException)
            logger.error(((UsernameArgumentException) ex).getLogMsg(), ex);
        else if(ex instanceof MessageArgumentException)
            logger.error(((MessageArgumentException) ex).getLogMsg(), ex);
    }

    @AfterThrowing(pointcut = "execution(* integration.MessageJDBCTemplate.addMessage(..))", throwing = "ex")
    public void jdbcConnectionInAddMessage(CannotGetJdbcConnectionException ex){
        logger.error("Connection to db problem in addMessage()! Full stack trace", ex);
    }

    @AfterReturning("execution(* integration.MessageJDBCTemplate.addMessage(..))")
    public void successfulRunAddMessage(final JoinPoint joinPoint){
        logger.info("Message inserted: " + (Message)joinPoint.getArgs()[0]);
    }
}
