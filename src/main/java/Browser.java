import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver openBrowser(){
        String baseDirectory=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",baseDirectory+"/src/main/resources/chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10,    TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
        //ToDo parameterise browser and url
        driver.navigate().to("https://www.ajio.com/");
        return driver;
    }

    public static void closeBrowser(WebDriver driver){
        driver.quit();
    }

}
