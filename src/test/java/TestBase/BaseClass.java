package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;// Log4j
	public Properties p;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws Exception {

		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties"); // provide properties file path
																						// to read
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());// log method

		switch (br.toLowerCase()) // will keep browser text in lowercase if u entered in uppercase in testng
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return; // if browser is invalid it will stop the execution
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url")); // reading data from properties file
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}


	    

	public String captureScreen(String testName) throws IOException {
	    if (driver == null) {
	        throw new IllegalStateException("WebDriver is not initialized. Cannot take a screenshot.");
	    }
	    
	    if (!(driver instanceof TakesScreenshot)) {
	        throw new IllegalStateException("Current WebDriver does not support taking screenshots.");
	    }

	    // Generate a unique screenshot file name with timestamp
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    // Take screenshot
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    // Ensure the 'screenshots' directory exists
	    String screenshotsDir = System.getProperty("user.dir") + "/screenshots/";
	    File dir = new File(screenshotsDir);
	    if (!dir.exists()) {
	        dir.mkdirs(); // Create directory if it doesn't exist
	    }

	    // Save the screenshot to the specified location
	    String targetFilePath = screenshotsDir + testName + "_" + timestamp + ".png";
	    File targetFile = new File(targetFilePath);

	    // Use FileUtils to copy the file
	    FileUtils.copyFile(sourceFile, targetFile);  

	    return targetFilePath; // Return the path for reports/logs
	}	
	

	@AfterClass
	public void teradown() {
		driver.quit();
	}

}
