import model.TestClickModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClickModelTest {
    private TestClickModel tesetClickModel;

    @Before
    public void init(){
        this.tesetClickModel = new TestClickModel();
    }

    @Test
    public void clickedToConfirmTest(){
        assertEquals("Success!", tesetClickModel.clickedToConfirm());
    }
}
