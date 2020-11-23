import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.thread.IThreadWorkerFactory;
import page_objects.FormPage;
import page_objects.FormSubmissionPage;

public class KeyBoardAndMouseInput1 {
    Utils utils= new Utils();
    WebDriver driver;

    @Test
    public void keyBoardMouseInput() {
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/keypress";
        utils.invokeBrowser(driver, url);
        WebElement text_field_Enter_full_name = driver.findElement(By.cssSelector(".form-control")); // using classname in cssSelector
        text_field_Enter_full_name.sendKeys("jj");
        WebElement button = driver.findElement(By.cssSelector("#button"));// using id in cssSelector
        button.click();
//        utils.closeBrowser();
//        utils.quitBrowser();
    }

    @Test
    public void autoComplete() throws InterruptedException {
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/autocomplete";
        utils.invokeBrowser(driver, url);
        WebElement autoCompleteTextBox= driver.findElement(By.cssSelector("#autocomplete"));
        String address= "Kanyal Road, Simsa Village, Nasogi, Himachal Pradesh, India";
        autoCompleteTextBox.sendKeys(address);
        Thread.sleep(2000);
        WebElement autoCompleteResult= driver.findElement(By.cssSelector(".pac-item"));
        autoCompleteResult.click();

    }

    @Test
    public void testScrollToElement(){
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/scroll";
        utils.invokeBrowser(driver, url);
        WebElement fullNameTextBox= driver.findElement(By.cssSelector("input[placeholder='Full name']"));
        WebElement date= driver.findElement(By.cssSelector("input[placeholder='MM/DD/YYYY']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(fullNameTextBox);
        fullNameTextBox.sendKeys("jj");
        date.sendKeys("11/03/2020");

    }

    @Test
    public void testSwitchToWindow() throws InterruptedException {
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/switch-window";
        utils.invokeBrowser(driver, url);
        WebElement buttonOpenNewTab= driver.findElement(By.cssSelector(".btn.btn-primary"));
//        String window2= driver.getWindowHandle();
//        System.out.println("window2: "+window2);
        buttonOpenNewTab.click();
        buttonOpenNewTab.click();
        buttonOpenNewTab.click();
        String window1= driver.getWindowHandle();
        System.out.println("window1: "+window1);
//        driver.switchTo().window(window2);
//        System.out.println(driver.getWindowHandle());
//        Thread.sleep(5000);
//        driver.switchTo().window(window1);
//        System.out.println(driver.getWindowHandle());
//        Thread.sleep(5000);
        for(String windowHandle: driver.getWindowHandles()){
            System.out.println("windowHandle: "+windowHandle);
            Thread.sleep(5000);
            driver.switchTo().window(windowHandle);
        }
        Thread.sleep(5000);
        driver.switchTo().window(window1);

    }

    @Test
    public void testSwitchToAlert() throws InterruptedException {
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/switch-window";
        utils.invokeBrowser(driver, url);
        WebElement buttonOpenAlert= driver.findElement(By.cssSelector("#alert-button"));
        buttonOpenAlert.click();

        Alert alert= driver.switchTo().alert();
        String messageOnAlert= alert.getText();
        System.out.println("message on alert: "+messageOnAlert);
        Thread.sleep(5000);
        alert.accept();
    }

    @Test
    public void testJavaScriptExecutor() throws InterruptedException {
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/modal";
        utils.invokeBrowser(driver, url);
        WebElement modalButton= driver.findElement(By.cssSelector(".btn.btn-primary"));
        WebElement closeButton= driver.findElement(By.cssSelector("#close-button"));
        WebElement okButton= driver.findElement(By.cssSelector("#ok-button"));
        WebElement xButton= driver.findElement(By.cssSelector("span[aria-hidden='true']"));

//        modalButton.click();

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", modalButton);
        Thread.sleep(5000);
        js.executeScript("arguments[0].click();",okButton);
        Thread.sleep(4000);
        js.executeScript("arguments[0].click();", closeButton);
//        okButton.click();
//        Thread.sleep(7000);
//        js.executeScript("arguments[0].click();",xButton);
//document.querySelector("#close-button")
    }

    @Test
    public void testDragAndDrop(){

        driver= utils.getDriver();
        String url= "https://formy-project.herokuapp.com/dragdrop";
        utils.invokeBrowser(driver, url);
        WebElement imageLogo= driver.findElement(By.cssSelector("img[alt='Selenium logo']"));
        WebElement dropHere= driver.findElement(By.cssSelector("#box"));
        Actions actions= new Actions(driver);
        System.out.println(dropHere.getText());
        Assert.assertEquals(dropHere.getText(), "Drop here",
                "The text before the drag & drop is performed isn't as expected");
        actions.dragAndDrop(imageLogo,dropHere).build().perform();
        System.out.println(dropHere.getText());
        Assert.assertEquals(dropHere.getText(), "Dropped!",
                "the drag & drop of the dint happen as expected");
    }

    @Test
    public void testRadioButton() throws InterruptedException {
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com";
        utils.invokeBrowser(driver, url);

        Thread.sleep(10000);
        WebElement radioButtonOnHomePage= driver.findElement(By.cssSelector("li a.btn.btn-lg[href='/radiobutton']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(radioButtonOnHomePage);
        Thread.sleep(5000);
        radioButtonOnHomePage.click();
        Thread.sleep(10000);
        WebElement radioButton1= driver.findElement(By.cssSelector("div.form-check input[value='option1']"));
        WebElement radioButton2= driver.findElement(By.cssSelector("div.form-check input[value='option2']"));
        WebElement radioButton3= driver.findElement(By.cssSelector("div.form-check input[value='option3']"));
        radioButton1.click();
        Thread.sleep(5000);
        radioButton2.click();
        Thread.sleep(5000);
        radioButton3.click();
    }

    @Test
    public void testDatePicker() throws InterruptedException {
        driver= utils.getDriver();
        String url=  "http://formy-project.herokuapp.com/datepicker";
        utils.invokeBrowser(driver, url);
        WebElement datepicker= driver.findElement(By.cssSelector("input[placeholder='mm/dd/yyyy']"));
        Thread.sleep(3000);
        datepicker.sendKeys("04-01-2021");
        Thread.sleep(3000);
        datepicker.sendKeys(Keys.RETURN);
    }

    @Test
    public void testDropdown() throws InterruptedException {
        driver= utils.getDriver();
        String url= "https://formy-project.herokuapp.com/dropdown";
        WebDriverWait wait= new WebDriverWait(driver, 15);
        utils.invokeBrowser(driver, url);
        WebElement dropdownText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        System.out.println("dropdownText: "+dropdownText.getText());
//        Thread.sleep(3000);
        WebElement dropdownButton= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button.btn.btn-primary.dropdown-toggle")));
        dropdownButton.click();
        WebElement selectOptionRadioButtonFromDropdown= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.dropdown-menu.show a[href='/radiobutton']")));

//        Thread.sleep(3000);
        selectOptionRadioButtonFromDropdown.click();
//        Thread.sleep(3000);
        WebElement radioButtonPageText= driver.findElement(By.cssSelector("h1"));
        System.out.println("radioButtonPageText: "+radioButtonPageText.getText());
    }

    @Test
    public void testFileUpload(){
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/fileupload";
        utils.invokeBrowser(driver, url);
        WebElement fileUploadPageText= driver.findElement(By.cssSelector("h1"));
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals("File upload1", fileUploadPageText.getText(), "the expected text 'File upload' is not shown" );
        WebElement fileUploadField= driver.findElement(By.cssSelector("input[placeholder='Choose a file...']"));
        fileUploadField.sendKeys("/Users/jj/Documents/Proj/Practice/Oct2020/SeleniumEssentials/src/test/java/test_upload_file/jj1.png");
    }



    @Test
    public void testFormFill() throws InterruptedException {
        driver= utils.getDriver();
        String url= "http://formy-project.herokuapp.com/form";
        utils.invokeBrowser(driver, url);
        FormPage formPage = new FormPage();
        FormSubmissionPage formSubmissionPage= new FormSubmissionPage();
//        formPage= new FormPage();
        formPage.submitForm(driver);
//        formSubmissionPage= new FormSubmissionPage();
        formSubmissionPage.checkAlertTextAfterFormSubmission(driver);
    }





}

