import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC05 extends BasePage{
    public TC05(WebDriver driver) {
        super(driver);
    }

    public void VerifySortLowest() throws IOException {

        try{
            SearchBar(By.name("searchVal"), "shoes");
            click(By.xpath("//option[contains(@value,'prce-asc')]"));
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "sort by lowest price", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e){
            Assert.fail("sort by lowest price fails"+""+e);
           // System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "sort by lowest price fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }
}
