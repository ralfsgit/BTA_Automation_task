package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalizedOfferPage extends BasePage {


    @Getter
    @Setter
    private double priceOfInsurance;

    private SelenideElement headerAddMoreProtectionText = $(By.xpath("//h2[@class='title']"));
    private SelenideElement myPolicyTotalSum = $(By.xpath("//span[@class='price']//child::*[1]"));
    private SelenideElement editDetailsButton = $(By.xpath("//div[@class='list-container']//child::*[text()='Labot datus']"));
    private SelenideElement insuranceAmountDropDown = $(By.id("deductible-open"));
    private SelenideElement affirmButton = $(By.xpath("//button[contains(@class, 'confirm-details')]"));
    private SelenideElement continueButton = $(By.xpath("//span[@class='price']/following::*[contains(text(), 'Turpināt')]"));
    private SelenideElement carInsuranceAmountField = $(By.xpath("//div[@class='list-container']//child::*[contains(text(), 'Apdrošināšanas cena')]/child::*"));



    public void chooseProgram(String activity) {
        SelenideElement priceElement = ($(By.xpath("//section[@class='policy-items']//*[contains(text(),'" + activity + "')]/following-sibling::div[@class='price']/span[@class='num']")));
        clickOn($(By.xpath("(//section[@class='policy-items']//*[contains(text(),'" + activity + "')]/following::*[contains(text(), 'Turpināt')])[1]")));

        String priceText = priceElement.getText();

        double priceValue = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        setPriceOfInsurance(priceValue);

    }

    public String getHeaderAddMoreProtectionText() {

        return getTextAndWaitTillElementVisible(headerAddMoreProtectionText);
    }

    public double getMyPolicySum(){
       String policyTotalSum = getTextAndWaitTillElementVisible(myPolicyTotalSum);

        return Double.parseDouble(policyTotalSum.replaceAll("[^\\d.]", ""));
    }

    public void clickEditDetailsButton(){
        clickOn(editDetailsButton);
    }
    public void chooseInsuranceSum(int insuranceSum){
        clickOn(insuranceAmountDropDown);
        clickOn($(By.xpath("//div[@class='dropdown up']/child::*[contains(text(), '" + insuranceSum + "')]")));
        clickOn(affirmButton);
    }

    public double carInsuranceAmount(){
        String carInsuranceAmount =  getTextAndWaitTillElementVisible(carInsuranceAmountField);
        return Double.parseDouble(carInsuranceAmount.replaceAll("[^\\d.]", ""));
    }

    public void clickContinueButton(){
        clickOn(continueButton);
    }
}

