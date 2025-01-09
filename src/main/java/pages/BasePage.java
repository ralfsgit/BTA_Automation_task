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

//  public void clickOnElementWhichIsNotVisible(SelenideElement element) {
//    // Ensure the element is visible, enabled, and in the viewport (if not, scroll to it)
//    element.shouldBe(Condition.visible, Duration.ofSeconds(10))
//            .shouldBe(Condition.enabled);
//
//    // Scroll to element if it's not in the viewport
//    if ((boolean) Selenide.executeJavaScript(
//            "var rect = arguments[0].getBoundingClientRect();" +
//                    "return (rect.top >= 0 && rect.left >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
//            element) == false) {
//      Selenide.executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
//      sleep(500);  // Wait for the scroll to finish
//    }
//
//    // Click on the element
//    element.click();
//  }

}


