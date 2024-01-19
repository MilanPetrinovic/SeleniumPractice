import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.openqa.selenium.Keys.ENTER;

public class DomaciSelenium1 {
    public static void main(String[] args) throws InterruptedException {

    //Otici na Google, zatim preko browser-a otici na YouTube i pustiti neku pesmu po Vasem izboru.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.get("https://www.google.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/" +
                        "ytd-searchbox/form/div[1]/div[1]/input"))
                .sendKeys("rammstein du hast");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/" +
                        "ytd-searchbox/form/div[1]/div[1]/input"))
                .sendKeys(ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/" +
                        "ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/" +
                        "ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/ytd-badge-supported-renderer"))
                .click();



    }


}
