package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.ElementClickInterceptedException;

import java.time.Duration;

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

  /**
Added scrollToElement method because sometimes when element is below screen selenide build in webdriver failed to autoscroll
   to element causing test to fail.
*/
  public void scrollToElement(SelenideElement element) {
    try {
      element.shouldBe(Condition.visible, Duration.ofSeconds(10))
              .shouldBe(Condition.enabled);

      boolean isElementInView = (boolean) Selenide.executeJavaScript(
              "var rect = arguments[0].getBoundingClientRect();" +
                      "return (rect.top >= 0 && rect.left >= 0 && rect.bottom <= (window.innerHeight ||" +
                      " document.documentElement.clientHeight) && rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
              element
      );

      if (!isElementInView) {
        Selenide.executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Thread.sleep(500);
      }

      element.click();
    } catch (ElementClickInterceptedException e) {

      System.out.println("Element click intercepted, attempting JavaScript click...");
      Selenide.executeJavaScript("arguments[0].click();", element);
    } catch (Exception e) {
      throw new RuntimeException("Failed to click on the element: " + e.getMessage(), e);
    }
  }

}


