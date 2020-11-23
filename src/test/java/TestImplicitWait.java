import org.mortbay.thread.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestImplicitWait {

    Utils utils= new Utils();
    WebDriver driver;

    @Test
    public void testDropdown() {
        driver= utils.getDriver();
        String url= "https://formy-project.herokuapp.com/dropdown";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        utils.invokeBrowser(driver, url);
        WebElement dropdownText= driver.findElement(By.cssSelector("h1"));
        System.out.println("dropdownText: "+dropdownText.getText());
        WebElement dropdownButton= driver.findElement(By.cssSelector("button.btn.btn-primary.dropdown-toggle"));
        dropdownButton.click();
        WebElement selectOptionRadioButtonFromDropdown= driver.findElement(By.cssSelector("div.dropdown-menu.show a[href='/radiobutton']"));
        selectOptionRadioButtonFromDropdown.click();
        WebElement radioButtonPageText= driver.findElement(By.cssSelector("h1"));
        System.out.println("radioButtonPageText: "+radioButtonPageText.getText());
    }

    public void waitImplicit(WebDriver driver, Long time, TimeUnit unit){
        driver.manage().timeouts().implicitlyWait(time, unit);
    }

    public void waitExplicitForvisibilityOfElement(WebDriver driver, Long timeOut, WebElement webElement ){
        WebDriverWait wait= new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.visibilityOf(webElement));
//        wait.until(ExpectedConditions.elementToBeClickable(webElement));
//        wait.until(ExpectedConditions.elementToBeClickable(webElement));

    }
}
