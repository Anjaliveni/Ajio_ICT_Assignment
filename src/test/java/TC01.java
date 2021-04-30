import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class TC01 extends BasePage {
    public TC01(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void VerifyForProduct() throws IOException {
        try {

            SearchBar(By.name("searchVal"), "Jacket");   //search for product
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, " search product Jacket", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());


        } catch (Exception e) {
            Assert.fail("search product jacket fails"+e);
            Reports.extentTest.log(Status.FAIL, "search product Jacket fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }

    }
}
