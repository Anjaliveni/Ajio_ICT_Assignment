import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

public class TC07 extends BasePage {
    public TC07(WebDriver driver) {
        super(driver);
    }

    public void VerifyMenuForMen() throws IOException {
        try {
            // actions class with moveToElement() method for mouse hover to element
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(By.xpath("//a[@href='/shop/men']"))).build().perform();
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "menu for men contains jeans and shirt", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e) {
            Assert.fail("Menu for men does not contain jeans and shirts"+""+e);

           // System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "Menu for men does not contain jeans and shirts", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }
}
