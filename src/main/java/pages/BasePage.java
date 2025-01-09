package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static java.time.Duration.ofSeconds;


public class BasePage {

  public void clickOn(SelenideElement element) {
    element.shouldBe(Condition.visible, ofSeconds(10))
            .shouldBe(Condition.enabled);
    element.click();
  }

  public String getTextAndWaitTillElementVisible(SelenideElement element) {
    return element.shouldBe(Condition.visible, ofSeconds(10))
            .getText();
  }

  public void verifyElementFieldIsEmptyAndVisible(SelenideElement element) {
    element.shouldBe(Condition.visible, Condition.empty);
  }

  public void typeIn(SelenideElement element, String text) {
    element.shouldBe(Condition.visible, ofSeconds(10)).sendKeys(text);
  }
}


