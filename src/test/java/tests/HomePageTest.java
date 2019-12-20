package tests;
import org.junit.*;


public class HomePageTest extends BaseTest {


    @Test
    public void loginRegisteredUser() {

        homePage
                .successfulLogin("ZhannaY", "26187733")
                .verifyAccountItemAppears();
    }
    @Test
    public void loginUnregisteredUser() {

        homePage
                .unsuccessfulLogin("user", "123456")
                .verifyWarningMessageAppears();
    }
}
