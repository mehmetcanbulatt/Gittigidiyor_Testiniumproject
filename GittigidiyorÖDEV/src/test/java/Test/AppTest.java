package Test;

import Main.HomePage;
import org.junit.jupiter.api.TestInstance;
import org.jsoup.Connection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)

    public class AppTest extends BaseTest{
    HomePage homePage;

    @Test
    public void testApp() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageMethod();

    }
}
