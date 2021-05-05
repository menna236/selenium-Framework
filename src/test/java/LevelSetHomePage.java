
import actions.BrowserActions;
        import org.openqa.selenium.WebDriver;
        import org.testng.Assert;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;
        import pages.createDocument;
        import pages.homePage;

        import java.util.Objects;

public class LevelSetHomePage {

    WebDriver driver;
    String homepage="https://www.levelset.com/";
    homePage home;
    createDocument document;
    BrowserActions browser;
    String preliminary="20-Day Preliminary Notice",
            intent_to_lien="Notice of Intent to Lien",
            BondClaim="Lien / Bond Claim",
            LienWaiver="Lien Waiver";

    @Parameters("browsertype")


    @BeforeClass
    public void setUp(String browserType)
    {
        browser=new BrowserActions();
        driver= browser.SetBrowser(browserType);
        browser.maximizeWindow();
        home=new homePage(driver);
        document=new createDocument(driver);

    }
    @Test(dataProvider = "DocType")
    public void createNewDocument( String DocType)
    {
        home.navigateToHome();
        home.clickCreateDocument();
        Assert.assertEquals(document.getDocumentPrice(DocType),"Free");
        Assert.assertEquals(document.checkDocumentTitle(DocType),DocType);
    }
   /*

      @Test()
    public void createPreliminaryDocument( String DocType)
    {
        home.navigateToHome();
        home.clickCreateDocument();
        Assert.assertEquals(document.getDocumentPrice(DocType),"Free");
        Assert.assertEquals(document.checkDocumentTitle(DocType),DocType);
    }
    @Test
    public void createIntentToLienDocument()
    {
        home.navigateToHome();
        home.clickCreateDocument();
        Assert.assertEquals(document.getDocumentPrice(intent_to_lien),"Free");
        Assert.assertEquals(document.checkDocumentTitle(intent_to_lien),intent_to_lien);
    }
    @Test
    public void createBondClaimDocument()
    {
        home.navigateToHome();
        home.clickCreateDocument();
        Assert.assertEquals(document.getDocumentPrice(BondClaim),"Free");
        Assert.assertEquals(document.checkDocumentTitle(BondClaim),BondClaim);
    }
    @Test
    public void createLienWaiverDocument()
    {
        home.navigateToHome();
        home.clickCreateDocument();
        Assert.assertEquals(document.getDocumentPrice(LienWaiver),"Free");
        Assert.assertEquals(document.checkDocumentTitle(LienWaiver),LienWaiver);
    }*/

    @DataProvider(name ="DocType")
    public Object[] getDocuments()
    {

        return new Object[]{"20-Day Preliminary Notice",
                "Notice of Intent to Lien",
                "Lien / Bond Claim",
                "Lien Waiver"
        };
    }





}
