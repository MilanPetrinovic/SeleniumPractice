import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DomaciSelenium2 {
    public static void main(String[] args) {
        ////Domaci Zadatak 2:
        ////https://demoqa.com/text-box napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement emailField = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("Milan Petrinovic");
        emailField.sendKeys("nesto@gmail.com");
        currentAddress.sendKeys("Tolstojeva 12");
        permanentAddress.sendKeys("Puskinova 12");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitButton);

        WebElement rezultat = driver.findElement(By.id("output"));
        Assert.assertTrue(rezultat.isDisplayed());

        String expectedName = "Name:Milan Petrinovic";
        String expectedEmail = "Email:nesto@gmail.com";
        String expectedCurrentAddress = "Current Address :Tolstojeva 12";
        String expectedPermanentAddress = "Permananet Address :Puskinova 12";

        WebElement name = driver.findElement(By.id("name"));
        String displayedName = name.getText();
        WebElement email = driver.findElement(By.id("email"));
        String displayedEmail = email.getText();
        WebElement addressCurrent = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]"));
        String displayedCurrentAddress = addressCurrent.getText();
        WebElement addressPermanent = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]"));
        String displayedPermanetAddress = addressPermanent.getText();

        Assert.assertEquals(expectedName, displayedName);
        Assert.assertEquals(expectedEmail, displayedEmail);
        Assert.assertEquals(expectedCurrentAddress, displayedCurrentAddress);
        Assert.assertEquals(expectedPermanentAddress, displayedPermanetAddress);



    }
}
