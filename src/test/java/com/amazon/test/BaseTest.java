package com.amazon.test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.amazon.Utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseTest {
	
	public static WebDriver driver;
	static String userDirectory = System.getProperty("user.dir").replaceAll("\\\\", "/");
	public static final ExtentReports extentReports = new ExtentReports();
	public static  ExtentTest test;

	
	static String reportPath = userDirectory + "/src/test/resources/Reports/"; 
	
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath + "YellowBricks Amazon Test-report.html");
        reporter.config().setReportName("Amazon Automation Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("https://www.yellowbrick.nl/", "Parking App");
        extentReports.setSystemInfo("Veerasekaran Mariappan", "Automation Tester");
		
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	@Parameters(value= {"browserName"})
	public void beforeMethod(String browserName,Method testMethod) {
		test = extentReports.createTest(testMethod.getName());
		createWebdriver(browserName);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		
	}
	
	
	
	@AfterMethod
	public void afterMethd(ITestResult result) {
		if (result.getStatus()==ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText = " Test Case "+methodName+" Passed ";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.log(Status.PASS, m);
			
		} else if(result.getStatus()==ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logText = " Test Case "+methodName+" Passed ";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			test.log(Status.FAIL, m);

		}
		driver.quit();
	}
	
	
	@AfterSuite 
	public void afterSuite() {
		extentReports.flush();
	}
	
	public void createWebdriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", userDirectory + "/src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", userDirectory + "/src/test/resources/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}

}
