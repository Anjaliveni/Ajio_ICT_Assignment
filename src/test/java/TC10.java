import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class TC10 extends BasePage {
    public TC10(WebDriver driver) {
        super(driver);
    }

    public void VerifyReturnPolicy() throws IOException {
        try {
            SearchBar(By.name("searchVal"), "Jacket");
            click(By.xpath("(//div[@class='imgHolder'])[1]"));
            for (String h : driver.getWindowHandles()) {  //for handling windows
                driver.switchTo().window(h);
            }

                //driver.findElement(By.xpath("//a[contains(text(),'Retruns & Refunds')]"));
                driver.findElement(By.xpath("//div[@class='tab-content']/div/div/span[2]/a")).click();
                //driver.findElement(By.linkText("Click here")).click();
                Thread.sleep(1000);
                takeScreenshot();
                Reports.extentTest.log(Status.PASS, "verify Return policy", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
            }
        catch(Exception e){
                 Assert.fail("verify return policy fails"+""+e);
                //System.out.println(e);
                Reports.extentTest.log(Status.FAIL, "verify Return policy fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

            }
        }
    }


