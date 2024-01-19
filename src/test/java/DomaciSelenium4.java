/*Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu*/


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class DomaciSelenium4 {

    WebDriver driver;
    Cookie cookie = new Cookie("userName", "mpetrin");
    WebDriverWait wait;
    @BeforeClass
    public void setUp (){

    }

    @BeforeMethod
    public  void  pageSetUp(){


    }

    @Test
    public void loginTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://demoqa.com/books/");
        Thread.sleep(3000);
        driver.manage().addCookie(cookie);
        Thread.sleep(3000);
        driver.navigate().refresh();

    }

    @AfterMethod
    public void metoda1(){


    }

    @AfterClass
    public void metoda2(){


    }
}
