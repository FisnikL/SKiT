import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("http://www.testyou.in/Login.aspx");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CPHContainer_txtUserLogin"))).isDisplayed();
    }

    public void login(String user, String password) throws InterruptedException {
//        // Login id: Option 1 using id attribute
//        driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
//        driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys(user);

//        // Login id: Option 2 using name attribute
//        driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")).clear();
//        driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")).sendKeys(user);

//        // Login id: Option 3 using cssSelector
//        driver.findElement(By.cssSelector("input[name='ctl00$CPHContainer$txtUserLogin']")).clear();
//        driver.findElement(By.cssSelector("input[name='ctl00$CPHContainer$txtUserLogin']")).sendKeys(user);

        // Login id: Option 4 using xpath
        driver.findElement(By.xpath("//input[@id='ctl00_CPHContainer_txtUserLogin']")).clear();
        driver.findElement(By.xpath("//input[@id='ctl00_CPHContainer_txtUserLogin']")).sendKeys(user);
        Thread.sleep(5000);

//        driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys(password);
//        driver.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ctl00_CPHContainer_txtPassword']")).sendKeys(password);
        Thread.sleep(5000);

//        driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
        driver.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();

        Thread.sleep(5000);
    }

    public void forgotPassword() throws InterruptedException {
        driver.findElement(By.id("ctl00_CPHContainer_hprlnkForgetPassword")).click();
        Thread.sleep(5000);
    }

    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.id("ctl00_CPHContainer_lblOutput"));
        return errorPage.getText();
    }

    public String getErrorFromEmptyUsername(){
        WebElement errorPage = driver.findElement(By.id("ctl00_CPHContainer_rfvLoginId"));
        return errorPage.getText();
    }

    public String getErrorFromEmptyPassword(){
        WebElement errorPage = driver.findElement(By.id("ctl00_CPHContainer_rfvPassword"));
        return errorPage.getText();
    }
}
