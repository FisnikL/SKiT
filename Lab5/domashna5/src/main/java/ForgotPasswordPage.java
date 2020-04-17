import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CPHContainer_txtEmailId"))).isDisplayed();
    }
}
