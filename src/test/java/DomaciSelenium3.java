import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class DomaciSelenium3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        String ispravanUsename = "student";
        String neispravanUsename = "student1";
        String ispravanPassword = "Password123";
        String neispravanPassword = "Password1234";


        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/
        driver.get("https://practicetestautomation.com/");
        driver.findElement(By.id("menu-item-20")).click();
        driver.findElement(By.linkText("Test Login Page")).click();

        //1. Neuspesan login sa praznim poljima
        driver.findElement(By.id("submit")).click();
        //Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        //2. Neuspesan login sa sa ispravnim usernamemom i praznim passwordom
        driver.navigate().refresh();
        driver.findElement(By.id("username")).sendKeys(ispravanUsename);
        //Thread.sleep(500);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("submit"))));
        driver.findElement(By.id("submit")).click();
        //Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Your password is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        //3. Neuspesan login sa ispravnim passwordom i praznim username
        driver.navigate().refresh();
        driver.findElement(By.id("password")).sendKeys(ispravanPassword);
        driver.findElement(By.id("submit")).click();
        //Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        //4. Neuspesan login sa ispravnim username i pogresnim passwordom
        driver.navigate().refresh();
        driver.findElement(By.id("username")).sendKeys(ispravanUsename);
        driver.findElement(By.id("password")).sendKeys(neispravanPassword);
        driver.findElement(By.id("submit")).click();
        //Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Your password is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        //5. Neuspesan login sa pogresnim username i ispravnim password
        driver.navigate().refresh();
        driver.findElement(By.id("username")).sendKeys(neispravanUsename);
        driver.findElement(By.id("password")).sendKeys(ispravanPassword);
        driver.findElement(By.id("submit")).click();
        //Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        //6. Neuspesan login sa ispravnim username i password ALI sa pritiskom na enter umesto klika na submit button
        driver.navigate().refresh();
        driver.findElement(By.id("username")).sendKeys(ispravanUsename);
        driver.findElement(By.id("password")).sendKeys(ispravanPassword, ENTER);
        //Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }
}
