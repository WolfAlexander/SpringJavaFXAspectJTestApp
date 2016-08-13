package aspect;

import model.TestClickModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestClickAspect {
    private static Logger logger = LogManager.getLogger(TestClickModel.class);

    @Pointcut("execution(* model.TestClickModel.clickedToConfirm(..))")
    private void clickedToConfirmPointcut(){}

    @Before("clickedToConfirmPointcut()")
    public void beforeClickedToConfirm(){
        logger.info("Clicking on confirm button");
    }

    @After("clickedToConfirmPointcut()")
    public void afterClickerToConfirm(){
        logger.info("Confirm button clicked");
    }
}
