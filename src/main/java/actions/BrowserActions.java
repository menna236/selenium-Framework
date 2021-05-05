package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions {

    WebDriver driver;


    public WebDriver SetBrowser(String browserType)
    {
        try {
            if(browserType.equals("Chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                return driver;
            }

        } catch (Exception e) {

        }
        return null;
    }

    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }


}
