import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC03  extends BasePage{
    public TC03(WebDriver driver) {
        super(driver);
    }

    public void VerifyAddToBag() throws IOException {
        try {
            SearchBar(By.name("searchVal"), "Jacket");
            click(By.xpath("(//div[@class='imgHolder'])[1]"));  //for selecting first image
            for(String h : driver.getWindowHandles()) {  //for handling windows
                driver.switchTo().window(h);
            }
            //selects size
            click(By.xpath("(//div[@class='circle size-variant-item size-instock '])[1]"));

            //add to bag button
            click(By.xpath("//div[@class='btn-gold']"));

            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(locateElement(By.xpath("//div[@class='prod-content']/h1"))));

            //name of selected product
            String a=locateElement(By.xpath("//div[@class='prod-content']/h1")).getText();
            System.out.println(a);

            //click on add to bag button and verify bag
            driver.findElement(By.xpath("//div[@class='pdp-addtocart-button']/a/div/span[2]")).click();
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify add to bag", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e){
            Assert.fail("verify add to bag fails"+e);
            //System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "verify add to bag fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }
}
