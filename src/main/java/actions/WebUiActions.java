package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class WebUiActions {

    WebDriver driver;

    public WebUiActions(WebDriver driver)
    {
        this.driver=driver;
    }

    public boolean validateElement(ExpectedCondition<WebElement> Exp)
    {
        try
        {
            new WebDriverWait(driver,10).until(Exp);
            return  true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }

    public void clickOnBtn(By element,By expectedElement)
    {
        if(validateElement(ExpectedConditions.elementToBeClickable(element)))
        {
            driver.findElement(element).click();  //javascript
        }
        assertTrue(validateElement(ExpectedConditions.presenceOfElementLocated(expectedElement)));
    }

}
