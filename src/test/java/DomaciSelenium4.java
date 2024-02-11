/*Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu*/


import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;


public class DomaciSelenium4 {

    WebDriver driver;
    //Cookie cookie = new Cookie("userName", "mpetrin");
    WebDriverWait wait;


    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @BeforeMethod
    public  void  pageSetUp() throws InterruptedException {
        //NAPOMENA:
        //Cookies expires nakon svakog novog logovanja, ne znam kako da se ulogujem osim popunjavanjem
        //polja za username i password

        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card.mt-4.top-card")));
        List<WebElement> bookStoreLink = driver.findElements(By.cssSelector(".card.mt-4.top-card"));
        bookStoreLink.get(5).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passswordField = driver.findElement(By.id("password"));
        usernameField.clear();
        usernameField.sendKeys("mpetrin");
        passswordField.clear();
        passswordField.sendKeys("Bufi9999@+");
        WebElement loginbutton = driver.findElement(By.id("login"));
        loginbutton.click();

    }

    @Test(priority = 10)
    public void loginTest() throws InterruptedException {

        WebElement prvaKnjiga = driver.findElement(By.linkText("Git Pocket Guide"));
        prvaKnjiga.click();
        WebElement parentAdd = driver.findElement(By.cssSelector(".text-right.fullButton"));
        WebElement addToCollection = parentAdd.findElement(By.id("addNewRecordButton"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        addToCollection.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        WebElement parentBack = driver.findElement(By.cssSelector(".text-left.fullButton"));
        WebElement backToBookStore = parentBack.findElement(By.id("addNewRecordButton"));
        backToBookStore.click();

        WebElement drugaKnjiga = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        drugaKnjiga.click();
        WebElement parentAdd2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        WebElement addToCollection2 = parentAdd2.findElement(By.id("addNewRecordButton"));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        addToCollection2.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        //Thread.sleep(2000);



    }
    @Test(priority = 20)
    public void booksAddedTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(1000);
        List<WebElement> profile = driver.findElements(By.id("item-3"));
        Thread.sleep(1000);
        profile.get(4).click();
        List<WebElement> listaKnjiga = driver.findElements(By.className("mr-2"));
        System.out.println(listaKnjiga.size());
        Assert.assertEquals(listaKnjiga.size(), 2);


    }


    @AfterMethod
    public void metoda1(){


    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }
}
