import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC06 extends BasePage{
    public TC06(WebDriver driver) {
        super(driver);
    }
    public void VerifySortHighest() throws IOException {
        try {
            SearchBar(By.name("searchVal"), "shoes");
            click(By.xpath("//option[contains(@value,'prce-desc')]"));
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "sort by highest price", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }


        catch (Exception e){
            Assert.fail("sort by highest price fails"+""+e);
           // System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "sort by highest price fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
    }
}
