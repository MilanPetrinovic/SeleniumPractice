import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak10 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");
        String imageLocation = "C:\\Users\\Sofija\\Downloads\\cobol.webp";
        WebElement uploadButton = driver.findElement(By.id("mm-show-upload"));
        uploadButton.click();
        WebElement uploadFile = driver.findElement(By.id("mm-upload-file"));
        uploadFile.sendKeys(imageLocation);
        WebElement upload = driver.findElement(By.id("mm-upload-btn"));
        upload.click();
        //"button[type='submit']"

        WebElement topText = driver.findElement(By.cssSelector("textarea[placeholder='Top Text']"));
        WebElement bottomText = driver.findElement(By.cssSelector("textarea[placeholder='Bottom Text']"));
        topText.sendKeys("When boss tells you:");
        bottomText.sendKeys("Go learn Cobol");
        WebElement generateMeme = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateMeme.click();

        //Save image
        /*WebElement meme = driver.findElement(By.id("done-img"));
        wdwait.until(ExpectedConditions.attributeContains(meme, "src", "imgflip.com"));
        String link = meme.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageIO.write(saveImage, "png", new File("C:\\Users\\drago\\Desktop\\meme.png"));*/
    }
}
