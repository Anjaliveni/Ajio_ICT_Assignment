import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AjioShopping {
    private WebDriver driver;
    


    @BeforeMethod
    public void openBrowser() {
        driver= Browser.openBrowser();
    }
 //Test case 1 pass
    @Test(priority = 1)
    public void VerifyProductJacket() throws Exception {
        Reports.createTest("verify product-positive");
        TC01 tc01=new TC01(driver);
        tc01.VerifyForProduct();

    }
//Test Case 2 pass
    @Test(priority = 2)
    public void VerifySmartPhone() throws IOException{
        Reports.createTest("search unavailable product-Positive");
        TC02 tc02=new TC02(driver);
        tc02.VerifyUnavailable();
        System.out.println("search not found for smart phone");



    }
//Test Case 3 pass
    @Test (priority =3)
    public void  VerifyAddToBagBySize() throws Exception{
        Reports.createTest("Add to Bag-positive");
        TC03 tc03 = new TC03(driver);
        tc03.VerifyAddToBag();
        System.out.println("verify add to bag successful");

    }



    //Test Case 4 pass
    @Test(priority = 4)
    public void VerifyMenuBar() throws IOException {
        Reports.createTest("Verify MenuBar-positive");
        TC04 tc04=new TC04(driver);
        tc04.MenuVerification();
       System.out.println("menu list is present");
    }

    //Test Case 5 pass
    @Test(priority = 5)
    public void VerifySortByLowest() throws Exception {
        Reports.createTest("Verify sorting by lowest price to highest  price function-Positive");
        TC05 tc05=new TC05(driver);
        tc05.VerifySortLowest();
        System.out.println("verify the sort for lowest price successful");

    }
//Test case 6 pass
    @Test(priority = 6)
    public void VerifySortByHighest() throws Exception {
        Reports.createTest("Verify sorting by highest price to lowest price function-Positive");
        TC06 tc06 = new TC06(driver);
        tc06.VerifySortHighest();
        System.out.println("sorted by highest price successful");
    }





//Test Case7 pass
    @Test(priority = 7)
    public void VerifyMenuForMen() throws Exception{
        Reports.createTest("Verify menu for men contains jeans and shirts-positive");
        TC07 tc07 = new TC07(driver);
        tc07.VerifyMenuForMen();
        System.out.println("Menulist of the Men contains jeans and shirts successful");
    }
//Test Case 8 pass
    @Test(priority = 8)
    public void VerifyProceedToShipping() throws IOException {
        Reports.createTest("verify proceed to shipping-positive");
        TC08 tc08 =new TC08(driver);
        tc08.VerifyProceedToShipping();
        System.out.println("verify proceed to shipping successful");
    }

 //Test Case 9 pass
    
    @Test(priority = 9)
    public void VerifyFooter() throws Exception{
        Reports.createTest("verify footer contains the text expected-positive");
        TC09 tc09 = new TC09(driver);
        tc09.VerifyFooter();
        System.out.println("footer contains who we are,Join our Team,Terms and conditions");
    }

 //Test Case 10 pass
    @Test(priority = 10)
    public void VerifyReturnPolicy() throws Exception{
        Reports.createTest("Verify return policy contains link Click here-positive");
        TC10 tc10 = new TC10(driver);
        tc10.VerifyReturnPolicy();
        System.out.println("Return policy displayed successfully");
    }

    //Test Case 11 pass
    @Test(priority = 11)
    public void VerifyForFaqs() throws  IOException {
        Reports.createTest("FAQ'S are displayed or not-positive");
        TC11 tc11 = new TC11(driver);
        tc11.VerifyFaq();
        System.out.println("FAQ's are displayed successfully");
    }

    //Test Case 12 fails(verify elements)
    @Test(priority = 12)
    public void VerifyForFilterItems() throws Exception{
        Reports.createTest("verify filter item-positive");
        TC12 tc12=new TC12(driver);
        tc12.VerifyFilterItems();
        System.out.println("success");
        System.out.println("filter by items successfully");
    }




  //Test Case 13 pass
    @Test(priority = 13)
       public void SearchBrand() throws  Exception{
        Reports.createTest("verify search brand should displayed-positive");
        TC13 tc13 = new TC13(driver);
        tc13.VerifySearchBrand();
        System.out.println("search brand displayed successfully");
    }

    //Test Case 14 partial
    @Test(priority = 14)
       public void VerifyFilterByMinMax() throws IOException {
        Reports.createTest("verify for filter by min-max--positive");
        TC14 tc14=new TC14(driver);
        tc14.VerifySearchForAdidas();
        System.out.println("filter by min- max successful");
    }
    //Test case 15 pass
    @Test(priority = 15)
    public void VerifyUrlChanges() throws IOException {
        Reports.createTest("verify URL changes-positive");
        TC15 tc15 = new TC15(driver);
        tc15.VerifyUrlChanges();
        System.out.println("verify URL changes successfully");
    }






    @AfterMethod
    public void closeBrowser(){

       Browser.closeBrowser(driver);
    }
}
