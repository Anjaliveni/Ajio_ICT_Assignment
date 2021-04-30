import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TC13  extends BasePage{
    public TC13(WebDriver driver) {
        super(driver);
    }

    public void VerifySearchBrand() throws IOException {
        try {
            SearchBar(By.name("searchVal"), "puma");
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "search for brand PUMA", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e){
            System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "Search for brand PUMA fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }
}
