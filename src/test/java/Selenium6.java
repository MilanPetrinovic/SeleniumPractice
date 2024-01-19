import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","milanpetrinovic%7C1800042203%7CP71pUI3STParGaNU4Z9ToRAIWbaQ2qXc6U5uOqcTG9e%7Ca6c32d4d90fccf50d1193905ad014476194788c3f1442c437bac62e366007e27");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        Thread.sleep(4000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }
}