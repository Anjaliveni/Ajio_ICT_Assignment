import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TC11 extends BasePage{
    public TC11(WebDriver driver) {
        super(driver);
    }

    public void VerifyFaq() throws IOException {
        try {
        driver.findElement(By.xpath("//a[contains(text(),'Customer Care')]")).click();
            driver.findElement(By.xpath(" //a[contains(@id,'left-tabs-example-tab-0')]")).click();
            WebDriverWait wait=new WebDriverWait(driver, 20);
            driver.findElement(By.xpath(" //a[contains(@id,'left-tabs-example-tab-1')]")).click();
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify FAQs are displayed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
        catch (Exception e){
            System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "verify FAQs failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }
}
