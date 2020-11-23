import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    public static WebDriver driver;

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
//        "/Users/jj/Documents/Proj/Practice/Oct2020/SeleniumEssentials/chromedriver"
        driver= new ChromeDriver();
        return driver;
    }

    public void invokeBrowser(WebDriver driver, String url){
        driver.get(url);
//        driver.get("http://formy-project.herokuapp.com/keypress");
//        driver.get("http://formy-project.herokuapp.com/switch-window");

    }

    public void closeBrowser(){
//        driver= getDriver();
        driver.close();
    }

    public static void quitBrowser(){
//        driver= getDriver();
        driver.quit();
    }
}
