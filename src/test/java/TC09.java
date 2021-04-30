import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TC09  extends BasePage{
    public TC09(WebDriver driver) {
        super(driver);
    }

    public void VerifyFooter() throws IOException {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify footer", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e){
            System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "verify footer fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
    }
}
