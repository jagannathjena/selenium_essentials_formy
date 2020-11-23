package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FormSubmissionPage {

    public void checkAlertTextAfterFormSubmission(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver, 10);
        WebElement alert= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=\"Thanks for submitting your form\"]")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=\"Thanks for submitting your form\"]"));
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"Thanks for submitting your form",
                "the alert message is not as expected");
    }
}
