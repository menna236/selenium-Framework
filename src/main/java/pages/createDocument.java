package pages;

import actions.WebUiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.JsonFileHandler;

public class createDocument {

    WebDriver driver;
    By selectedDocumentLabel=By.xpath("//div[@class='title']");
    String DocumentTypeLocator="//div[text()='%s']/..//span[text()='Free']";
    WebUiActions uiAction;

    String docname=new JsonFileHandler(JsonFileHandler.filename).getValue("DocumentTypeLocator");
    String doctypeLabel =new JsonFileHandler(JsonFileHandler.filename).getValue("selectedDocumentLabel");





    public createDocument(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getDocumentPrice(String type)
    {

     uiAction=new WebUiActions(driver);

   //  uiAction.validateElement(ExpectedConditions.
   //         presenceOfElementLocated(By.xpath(String.format(DocumentTypeLocator,type))));

     uiAction.validateElement(ExpectedConditions.
                presenceOfElementLocated(By.xpath(String.format(docname,type))));

    // String price= driver.findElement(By.xpath(String.format(DocumentTypeLocator,type))).getText();
     String price= driver.findElement(By.xpath(String.format(docname,type))).getText();
     return  price;
    }

    public String checkDocumentTitle(String docType)
    {
        uiAction=new WebUiActions(driver);
     //   uiAction.clickOnBtn(By.xpath(String.format(DocumentTypeLocator,docType)),selectedDocumentLabel);
     //   String title= driver.findElement(selectedDocumentLabel).getText();
        uiAction.clickOnBtn(By.xpath(String.format(docname,docType)),By.xpath(doctypeLabel));
        String title= driver.findElement(By.xpath(doctypeLabel)).getText();

        return  title;
    }
}
