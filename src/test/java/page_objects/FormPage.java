package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage {
    public void submitForm(WebDriver driver) throws InterruptedException {

        driver.findElement(By.cssSelector("input[placeholder='Enter last name']")).sendKeys("jj");
        driver.findElement(By.cssSelector("input[placeholder='Enter your job title']")).sendKeys("sdet");
        driver.findElement(By.cssSelector("input[value='radio-button-3']")).click();
        driver.findElement(By.cssSelector("input[value='checkbox-1']")).click();
        driver.findElement(By.cssSelector("select#select-menu")).click();
        driver.findElement(By.cssSelector("select option[value='3']")).click();
        driver.findElement(By.cssSelector("input[placeholder='mm/dd/yyyy'][type='text']")).sendKeys("01/04/2021");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("input[placeholder='mm/dd/yyyy'][type='text']")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }
}
