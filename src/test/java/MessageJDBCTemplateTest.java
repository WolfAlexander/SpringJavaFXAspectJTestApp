import configuration.AppConfig;
import integration.MessageJDBCTemplate;
import model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class MessageJDBCTemplateTest {
    @Autowired
    private MessageJDBCTemplate messageJDBCTemplate;
    private Message message;
    private String expectedResult;
    private TestContextManager testContextManager;

    public MessageJDBCTemplateTest(Message message, String expectedResult) {
        this.message = message;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUpContext() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }

    @Parameterized.Parameters
    public static Collection differentMessages(){
        return Arrays.asList(new Object[][]{
                {null, "EXCEPTION_EXPECTED"},
                {new Message("TestUser", ""), "EXCEPTION_EXPECTED"},
                {new Message("TestUser", "MessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessage"), "EXCEPTION_EXPECTED"},
                {new Message("Test", "TestMessage"), "EXCEPTION_EXPECTED"},
                {new Message("TestLongerUserName001", "TestMessage"), "EXCEPTION_EXPECTED"},
                {new Message("TestUser", "TestMessage"), "VALID_NO_RETURN_VALUE"}
        });
    }

    @Test
    public void addMessageTest(){
        if(expectedResult.equals("EXCEPTION_EXPECTED")){
            try{
                messageJDBCTemplate.addMessage(message);
                fail("Should have been exception");
            }catch (IllegalArgumentException ee){/*TestPassed*/}
        }else if(expectedResult.equals("VALID_NO_RETURN_VALUE"))
            messageJDBCTemplate.addMessage(message);
    }
}
