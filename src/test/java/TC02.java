import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC02 extends BasePage{


    public TC02(WebDriver driver) {
        super(driver);
    }

    public void VerifyUnavailable() throws IOException {

        try {
            SearchBar(By.name("searchVal"),"smart phone");
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "unavailable product", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e){
            Assert.fail("search unavailable product failed"+e);
            //System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "search unavailable product failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
    }
}
