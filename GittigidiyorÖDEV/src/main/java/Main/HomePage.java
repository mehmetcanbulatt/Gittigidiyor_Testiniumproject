package Main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

    public class HomePage extends BasePage{

        private static final Logger logger = LogManager.getLogger(BasePage.class);



        public HomePage(WebDriver driver) {
        super(driver);
    }

    public void homePageMethod() throws InterruptedException {
        getLinkControl("https://www.gittigidiyor.com/"); // Ana sayfa linki kontrol edilir
        clickToElement(By.cssSelector("div[data-cy='header-user-menu']")); //Giriş yap butonu üzerine gelinir
        clickToElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a")); // Giriş yap butonu tıklanır
        logger.info("Üye girişi sayfasına gidildi");
        TimeUnit.SECONDS.sleep(3);
        sendKeysToElement(By.id("L-UserNameField"),"mehmetcanbulat@hotmail.com"); // Kullanıcı adı girilir
        sendKeysToElement(By.id("L-PasswordField"),"13579MCMC"); // Şifre girilir
        clickToElement(By.id("gg-login-enter")); // Giriş yap butonu tıklanarak siteye login olunur
        logger.info("Giriş yapıldı");
        TimeUnit.SECONDS.sleep(3);
        sendKeysToElement(By.cssSelector("input[data-cy='header-search-input']"),"televizyon");// Televizyon kelimesi arama kutusuna yazdırılır
        clickToElement(By.cssSelector("button[class='qjixn8-0 sc-1bydi5r-0 gaMakD']")); // Bul butonu tıklanır
        TimeUnit.SECONDS.sleep(3);
        logger.info("Televizyon ürünü aratıldı");
        scrollDownToButtom(); // Sayfa sonuna scroll yapılır
        selectRandomProduct(By.xpath("//div[@data-cy='product-favorite']"));  // Rastgele 4 ürün favorilere eklenir
        logger.info("Ratgele 4 adet televizyon ürünü favorilere eklendi");
        TimeUnit.SECONDS.sleep(3);
        clickToElement(By.cssSelector("img[alt='GittiGidiyor']")); // Anasayfaya geri dönülür
        sendKeysToElement(By.cssSelector("input[data-cy='header-search-input']"),"çanta"); // Çanta kelimesi arama kutusuna yazdırılır
        clickToElement(By.cssSelector("button[class='qjixn8-0 sc-1bydi5r-0 gaMakD']")); // Bul butonu tıklanır
        TimeUnit.SECONDS.sleep(3);
        logger.info("Çanta ürünü aratıldı");
        clickToElement(By.xpath("(//div[@class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl'])[30]")); // 7.ürün bulunur
        clickToElement(By.xpath("//button[@class='control-button gg-ui-button plr10 gg-ui-btn-default']")); // 7.ürün sepete eklenir
        logger.info("7. çanta ürünü sepete eklendi");
        clickToElement(By.cssSelector("span[class='basket-title")); // Sepete gidilir
        TimeUnit.SECONDS.sleep(3);
        clickToElement(By.cssSelector("select[class='amount")); // Sepette ürün adedi butonuna tıklanır
        clickToElement(By.xpath("//option[@value='2']")); // Sepette ürün adedinde arttırma yapılır
        logger.info("Sepetteki ürün adedi arttırıldı");
        clickToElement(By.cssSelector("input[type='Submit']")); // Ödeme sayfasına gidilir
        TimeUnit.SECONDS.sleep(3);
        logger.info("Ödeme sayfasına gidildi");
        clickToElement(By.cssSelector("button[class='gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg']"));
        getTextControl(By.xpath("((//*[@class='gg-input-error-text gg-d-24'])//p)[6]"),
                "Mahallenizi seçmeyi unuttunuz."); //Adres bilgileri kaydet butonuna tıklanır ve hata mesajları görüntülenir
        clickToElement(By.cssSelector("a[title='Sepeti Düzenle']")); // Sepeti düzenle butonu tıklanır
        TimeUnit.SECONDS.sleep(3);
        scrollByPixel(); // Favori Ürünlere scroll olunur
        clickToElement(By.xpath("(//a[@class='gg-ui-btn-default btn-add-to-basket'])[6]")); //Favorilerden sepete 2.ürün eklenir
        TimeUnit.SECONDS.sleep(3);
        logger.info("Favorilerden 2.ürün sepete eklendi");
        clickToElement(By.xpath("(//a[@class='btn-delete'])[3]")); // Favorilerden 3.sırada eklenen ürün çıkartılır
        logger.info("Favorilerden 3.sıradaki ürün çıkartıldı");
        tabButtonClick(); // Yan tabda anasayfa açılır
        logger.info("Yan tabda anasayfa açıldı");
        hoverElement(By.cssSelector("div[data-cy='header-user-menu']")); // Hesabım butonu üzerine gelinir
        clickToElement(By.xpath("//a[@title='Çıkış'] ")); // Logout olunur
        logger.info("Yan tabda açılan sayfadan çıkış yaıldı");

    }

}
