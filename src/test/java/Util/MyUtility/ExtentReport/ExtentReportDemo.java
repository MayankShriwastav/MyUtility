package Util.MyUtility.ExtentReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	ChromeDriver driver;
	
	@BeforeTest
	public void config(){
			String path = System.getProperty("user.dir")+"\\reports\\ind.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Report");
			reporter.config().setDocumentTitle("Test Results");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);			
			extent.setSystemInfo("Tester", "Mayank Srivastava");
			extent.setSystemInfo("Env", "SIT");
			extent.setSystemInfo("Test", "Regression");
			
			
	}
	
	@Test
	public void launchApp() throws InterruptedException{		
		ExtentTest test = extent.createTest("Launch Application");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		extent.flush();		
	}
	
	 //@AfterTest
	    public void endreport()
	    {
	        driver.close();
	        extent.flush();
	    }

}
