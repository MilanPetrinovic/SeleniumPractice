import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) {
        // Zadatak 5
        // Testirati log in stranice https://practicetestautomation.com/
        //Sada treba na 5. zadatku da dodate asertacije nakon logovanja
        // Zadatak 6
        // Testirati log out funkcionalnost
        // Zadatak 7
        // Testirati neuspesan log in

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");


        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        //WebElement testLoginPage = driver.findElement
        //(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedLoggedINURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedLoggedINURL);

        WebElement pageTitle = driver.findElement(By.className("post-title"));
        String pageTitleText = pageTitle.getText();
        String expectedTitle = "Logged In Successfully";
        Assert.assertEquals(pageTitleText, expectedTitle);

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());

        logoutButton.click();
        String expectedLoggedOutURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedLoggedOutURL);

        WebElement username1 = driver.findElement(By.id("username"));
        username1.sendKeys("student");
        WebElement password1 = driver.findElement(By.id("password"));
        password1.sendKeys("Password1234");
        WebElement submitButton1 = driver.findElement(By.id("submit"));
        submitButton1.click();
    }
}
