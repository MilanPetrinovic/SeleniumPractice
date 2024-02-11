package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    // BaseTest klasa mi sluzi da smestim sve pocetne i krajnje metode uz pomocne metode koje cu koristiti u
    // testovima. Npr. metoda za cekanje, metoda za scroll...
    // 1. Deklarisem driver na pocetku van svih metoda. Moraju biti public kako bih je video
    // u test klasi
    public WebDriver driver;
    // 10. Svaku page stranicu moram da deklarisem van metoda
    public HomePage homePage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    // 2. Kreiram metodu setUp sa anotacijom BeforeClass jer zelim da se izvrsi samo jednom na pocetku
    // U toj metodi cu da inicijalizujem driver
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 11. Svaku page stranicu inicijalizujem u setUp metodi i prosledjujem driver
        homePage = new HomePage(driver);
        practicePage = new PracticePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    //3. Kreiram metodu tearDown sa anotacijom AfterClass jer zelim na samom kraju da mi se obavi neka akcija
    @AfterClass
    public void tearDown() {
        //driver.manage().deleteAllCookies();
        //driver.quit();
        // Dok pravim testove zakomentarisacu driver.quit() jer zelim da mi ostane otvoren prozor tokom testa
        // ako padne iz nekog razloga ili da proverim da li je sve kako treba
        // Tek kad zavrsim posao onda cu otvoriti driver.quit()
    }

    // Za svaku stranicu moram da kreiram posebnu klasu gde cu smestiti sve webelemente te stranice

}