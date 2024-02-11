package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    // 4. U svakoj page klasi moram da ponovo deklarisem driver i da kreiram konstruktor

    WebDriver driver;

    // 5. Svaki webelement kreiram posebno

    WebElement practiceButton;

    // 6. Nakon toga kreiram getter za svaki webelement

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // 7. Za return ubacujem lokator elementa da kada pozovem tu metodu zapravo dohvatim taj webelement

    public WebElement getPracticeButton() {
        return driver.findElement(By.id("menu-item-20"));
    }

    //-----------------------------------
    // 8. Odvojim vizuelno u klasi delove gde trazim webelemente i gde kreiram akcije nad tim elementima

    // 9. Zavisno sta mi treba od akcija kreiram metode
    //napomena: ne moraju sve metode da budu void, moze nam zatrebati akcija gde npr. izvlacimo text iz nekog elementa


    public void clickOnPracticeButton() {
        getPracticeButton().click();
    }

    // Isto radim za svaku page klasu
    // PracticePage, LoginPage, ProfilePage
    //-> nakon toga vratiti se na BaseTest klasu

}