package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.util.Base64;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.*;


public class Hooks {

    @BeforeAll
    public static void setupBrowserConfig() {
        holdBrowserOpen = false;
    }

    @After(order = 2)
    public static void clearSelenideStorages() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @After(order = 3)
    public static void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
            byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);

            scenario.attach(decoded, "image/png", "screenshot");
        }
    }

    @After(order = 1)
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}

