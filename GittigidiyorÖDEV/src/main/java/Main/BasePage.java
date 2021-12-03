package Main;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    public static String text = "";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);

    }

    public WebElement findToElement(By locator) {
        return driver.findElement(locator);
    }

    public void sendKeysToElement(By locator, String text) {
        findToElement(locator).sendKeys(text);
    }

    public void clickToElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findToElement(by).click();
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findToElement(by)).build().perform();
    }

    public void scrollDownToButtom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
    }

    public void scrollByPixel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public String getTextElement(WebElement element) {
        waitSecond(500);
        String elemaninTexti = "";
        elemaninTexti = element.getText();
        System.out.println("Elemanın Text değeri: " + elemaninTexti);
        return elemaninTexti;
    }

    public void waitSecond(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getTextControl(By by, String text) {
        WebElement element = findToElement(by);
        String adresBilgileri = element.getText();
        System.out.println("Elemanın Text değeri: " + adresBilgileri);
        Assert.assertEquals("Hata mesajları alınamıyor!", adresBilgileri, text);
        System.out.println("Hata mesajı ile text uyuşuyor!");
    }

    public void tabButtonClick(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");
    }

    public void getLinkControl(String text) {
        String pageLink = driver.getCurrentUrl();
        System.out.println("Sayfanın Linki: " + pageLink);
        Assert.assertTrue("Sayfa linki girilen texti içermiyor!", pageLink.contains(text));
        System.out.println("Sayfa linki ile girilen text uyuşuyor!");
    }

    List<WebElement> allProducts;

    public BasePage selectRandomProduct(By by){
        try {
            allProducts = driver.findElements(by);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            Thread.sleep(1000);
            Random random = new Random();

            for(int i=0;i<4;i++){
                int randomProduct  = random.nextInt(allProducts.size()-1);
                executor.executeScript("arguments[0].click();", allProducts.get(randomProduct));
                allProducts.remove(randomProduct);
            }
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        return this;
    }
}


