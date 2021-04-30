import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TC08 extends BasePage{
    public TC08(WebDriver driver) {
        super(driver);
    }

    public void VerifyProceedToShipping() throws IOException {
        try {
            SearchBar(By.name("searchVal"), "Jacket");
            click(By.xpath("(//div[@class='imgHolder'])[1]"));
            for(String h : driver.getWindowHandles()) {
                driver.switchTo().window(h);
            }
            click(By.xpath("(//div[@class='circle size-variant-item size-instock '])[1]"));

            click(By.xpath("//div[@class='btn-gold']"));

            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(locateElement(By.xpath("//div[@class='prod-content']/h1"))));

            String a=locateElement(By.xpath("//div[@class='prod-content']/h1")).getText();
            System.out.println(a);

            //verify bag and proceed to shipping
            driver.findElement(By.xpath("//div[@class='pdp-addtocart-button']/a/div/span[2]")).click();
            driver.findElement(By.xpath("//div[@class='button-wrapper cart-fixed-button']/button")).click();

            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "verify proceed to shipping", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch (Exception e) {
            System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "verify proced to shipping fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }

    }

}
