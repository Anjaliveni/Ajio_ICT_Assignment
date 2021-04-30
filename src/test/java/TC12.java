import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class TC12 extends BasePage{
    public TC12(WebDriver driver) {
        super(driver);
    }

    public void VerifyFilterItems() throws IOException {
        try {
            SearchBar(By.name("searchVal"), "Jacket");
            String a=driver.findElement(By.xpath("//div[@class='filter-container']/div/div")).getText();
            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "product count before filtration"+""+a, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());


            //**filter by gender**//
            click(By.xpath("//div[@class='facet-head facet-xpndicon']/span[2]"));
            click(By.className("facet-linkname facet-linkname-genderfilter facet-linkname-Men"));  //"//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Men']"));
            String b =driver.findElement(By.xpath("//div[@class='filter-container']/div/div")).getText();

            takeScreenshot();
            Reports.extentTest.log(Status.PASS, "product count after filteration"+""+b, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
        catch (Exception e){
            Assert.fail("product count fails"+""+e);
            //System.out.println(e);
            Reports.extentTest.log(Status.FAIL, "product count fails", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
    }
}
