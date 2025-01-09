package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private SelenideElement acceptCookiesButton = $(
            By.xpath("//section[@class='module cookies-notification not-set']//*[contains(text(), 'Piekrītu')]"));
    private SelenideElement loginContainer = $(
            By.xpath("//button[@class='account module-profile']//*[contains(text(), 'Mans BTA')]"));
    private SelenideElement travelButton = $(
            By.xpath("//div[@class='list']//*[contains(text(), 'Ceļojumi')]"));


    public void clickAcceptCookiesButton() {
        clickOn(acceptCookiesButton);
    }
    public String getLoginContainerName() {
        return loginContainer.getText();
    }
    public void clickTravelButton() {
        clickOn(travelButton);
    }

}




