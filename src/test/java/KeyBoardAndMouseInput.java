import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyBoardAndMouseInput {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
//        "/Users/jj/Documents/Proj/Practice/Oct2020/SeleniumEssentials/chromedriver"
        WebDriver driver= new ChromeDriver();
//        driver.get("http://formy-project.herokuapp.com/keypress");
        driver.get("http://formy-project.herokuapp.com/switch-window");
        WebElement newTabButton= driver.findElement(By.id("new-tab-button"));
        newTabButton.click();
        String originalHandle= driver.getWindowHandle();
        System.out.println("we are on window with handle: "+originalHandle);
        for (String handle1: driver.getWindowHandles()){
            driver.switchTo().window(handle1);
            System.out.println("handle: "+handle1);
        }
        String secondHandle= driver.getWindowHandle();
        System.out.println("we are on window with handle: "+secondHandle);
        Thread.sleep(2000);
        driver.switchTo().window(originalHandle);
        Thread.sleep(10000);
        driver.switchTo().window(secondHandle);
//        driver.quit();

    }


}
