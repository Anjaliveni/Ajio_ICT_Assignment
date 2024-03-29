import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


public class Reports {

    public static ExtentSparkReporter extentSparkReporter ;
    public static ExtentReports extentReports ;
    public static ExtentTest extentTest ;
    public WebDriver driver;

    @BeforeTest
    public void initialiseReport(){
        String baseDirectory=System.getProperty("user.dir");
        extentSparkReporter =new ExtentSparkReporter(baseDirectory+"/report/extentreport.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

    }

    public static void createTest(String testcaseName){
        extentTest=extentReports.createTest(testcaseName);
    }



    @AfterTest
    public void closeReport(){
        extentReports.flush();
    }
}
