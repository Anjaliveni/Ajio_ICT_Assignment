import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class TC04 extends BasePage {
    public TC04(WebDriver driver) {
        super(driver);
    }

    public void MenuVerification() throws IOException {
        try {
            List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[@class='header-right']"));
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify menu list", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e){
            Assert.fail("verify menu list fails"+e);
            //System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "verify menu list fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }
}


