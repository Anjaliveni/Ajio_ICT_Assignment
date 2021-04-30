import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TC14  extends BasePage{
    public TC14(WebDriver driver) {
        super(driver);
    }

    public void VerifySearchForAdidas() throws IOException {
        try{
            SearchBar(By.name("searchVal"), "adidas");
            driver.findElement(By.xpath("//div[contains(@class,'facet-head facet-xpndicon')]")).click();
            driver.findElement(By.xpath("//input[contains(@name,'minPrice')]")).sendKeys("100");
            driver.findElement(By.xpath("//input[contains(@name,'maxPrice')]")).sendKeys("500");
            click(By.xpath("//button[contains(@type,'submit')]"));
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "filter price by min-max", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
           }
        catch (Exception e){
            System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "filter price by min-max fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }
}
