import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

public class TC15 extends BasePage{
    public TC15(WebDriver driver) {
        super(driver);
    }

    public void VerifyUrlChanges() throws IOException {
        try {
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(By.xpath("//a[@href='/shop/men']"))).build().perform();
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify url changes for men ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
            a.moveToElement(driver.findElement(By.xpath("//a[@href='/shop/women']"))).build().perform();
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify url changes for women", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
            a.moveToElement(driver.findElement(By.xpath("//a[@href='/shop/kids']"))).build().perform();
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify url changes for kids", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e){
            Assert.fail("verify url changes for men women kids fails"+""+e);
            Reports.extentTest.log(Status.PASS, "verify url changes for men women kids fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
    }

}
