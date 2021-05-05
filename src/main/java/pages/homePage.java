package pages;

import actions.WebUiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import wrappers.PropertiesFileHandler;

import static org.testng.Assert.assertTrue;

public class homePage {

    WebDriver driver;
    String homepage="https://www.levelset.com/";  //property
    String homeUrl;
    By createDocumentBtn=By.xpath("//a[text()='Create a Document ']");
    WebUiActions webAction;




    public homePage(WebDriver driver)

    {
        this.driver=driver;
    }


    public void navigateToHome()
    {
        homeUrl= PropertiesFileHandler.getvalue("homepage");
        //driver.get(homepage);//navigateTo
        driver.get(homeUrl);//navigateTo
        webAction=new WebUiActions(driver);
        assertTrue(webAction.validateElement(ExpectedConditions.presenceOfElementLocated(createDocumentBtn)));

    }

    public void clickCreateDocument()
    {

           webAction=new WebUiActions(driver);
           webAction.clickOnBtn(createDocumentBtn,new createDocument(driver).selectedDocumentLabel);

    }



}
