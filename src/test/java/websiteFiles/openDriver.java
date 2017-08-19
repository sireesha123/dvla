package websiteFiles;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class openDriver {

    public static WebDriver driver;

    public void openDriver (){
        String browser = System.getProperty("browser");

        if (browser.toUpperCase().equals("FIREFOX")){
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        } else if (browser.toUpperCase().equals("CHROME")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
    }
    public void closeBrowser(){
        driver.quit();
    }
}
