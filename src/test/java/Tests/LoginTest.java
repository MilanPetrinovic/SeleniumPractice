package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    // 12. Test klasa treba da nasledi BaseTest klasu
    // 13. Kreiramo metodu pageSetUp koja ima anotaciju BeforeMethod
    // sto znaci da ce se ova metoda izvrsiti pre svakog testa
    // Obratiti paznju da se ova metoda ne zove isto kao metoda za anotaciju BeforeClass!!!
    // U tom slucaju ova metoda ce da pregazi prethodnu

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://practicetestautomation.com/");
    }

    // 14. Kreiram testove tako sto naziv metode dajem kako bih nazvao i manuelno napisan test case
    @Test
    public void userCanLogIn() {
        // 15. Nazivi metoda akcija treba da nose nazive kao da pisemo korake u test case-u
        homePage.clickOnPracticeButton();
        practicePage.clickOnRedirectButton();
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCanLogOut() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnRedirectButton();
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickOnSubmitButton();
        profilePage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnRedirectButton();
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickOnSubmitButton();
    }

}