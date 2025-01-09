package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TravelInsurancePage extends BasePage {

    private SelenideElement travelInsuranceHeader = $(By.xpath("//*[@id='form-travel-insurance']/h1"));
    private SelenideElement destinationSelectorButton = $(By.id("regionalSelectorRegion-open"));
    private SelenideElement chooseCountryButton = $(By.id("regionalSelectorCountry-showListSearch"));
    private SelenideElement addCountry = $(By.id("regionalSelectorCountry-addCountry"));
    private SelenideElement addCountryTextField = $(By.id("regionalSelectorCountry-typedValue"));
    private SelenideElement applyButton = $(By.id("regionalSelectorCountry-applyButton"));
    private SelenideElement changedDestinationTextField = $(By.xpath("//*[@id='regionalSelectorRegion-open']/*[text()='Visa pasaule']"));
    private SelenideElement activityButton = $(By.cssSelector("#travelActivities-open"));
    private SelenideElement activityTextField = $(By.xpath("//*[@id='travelActivities-open']/*[1]"));
    private SelenideElement getOfferButton = $(By.xpath("//button[@data-type='travelSubmit']"));


    public String getTravelInsuranceHeaderName() {
        return travelInsuranceHeader.getText();
    }
    public void clickDestinationButton() {
        clickOn(destinationSelectorButton);
    }
    public void chooseCountry() {
        clickOn(chooseCountryButton);
    }
    public void clickAddCountry() {
        clickOn(addCountry);
    }
    public void enterDestination(String destination) {
        typeIn(addCountryTextField, destination);
    }
    public void selectFoundDestination(String destination) {
        clickOn($(By.xpath("//*[@id='regionalSelectorCountry-selectItem']//*[text()='" + destination + "']")));
    }
    public void clickApplyButton() {
        clickOn(applyButton);
    }
    public String getChangedTravelDestinationText() {
        return changedDestinationTextField.getText();
    }
    public void clickActivityButton() {
        scrollToElement(activityButton);    }

    public void changeActivity(String activity) {
        clickOn($(By.xpath("//div[@class='wrapper single-popup-focus']//*[contains(text(),'" + activity + "')]")));
    }
    public String getActivityText() {
        return getTextAndWaitTillElementVisible(activityTextField);
    }
    public void clickGetOfferButton() {
        scrollToElement(getOfferButton);
    }

}
