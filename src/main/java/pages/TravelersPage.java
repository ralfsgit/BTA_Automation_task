package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TravelersPage extends BasePage {

    private SelenideElement firstNameField = $(By.id("travelerFirstName0-text"));
    private SelenideElement lastNameField = $(By.id("travelerLastName0-text"));
    private SelenideElement personalCodeField = $(By.id("travelerIdentityNumber0-text"));
    private SelenideElement travelPageHeaderText =$(By.xpath("//div[@class='header']/child::*[contains(text(), 'Ceļotāju dati')]"));
    public String travelPageLoaded() {
        return getTextAndWaitTillElementVisible(travelPageHeaderText);
    }

    public void verifyFieldsAreEmptyButVisible() {
        verifyElementFieldIsEmptyAndVisible(firstNameField);
        verifyElementFieldIsEmptyAndVisible(lastNameField);
        verifyElementFieldIsEmptyAndVisible(personalCodeField);
    }
}
