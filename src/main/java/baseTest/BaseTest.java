package baseTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;
	protected static org.apache.logging.log4j.Logger log; 
	protected static Properties prop;
	private static String url;
	private static String browserName;
	
	
	@BeforeTest
	public static void launchApplication() throws InterruptedException {
		log=LogManager.getLogger(BaseTest.class);
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\EcommerceTest\\src\\main\\resources\\config.properties");
			prop.load(fis);
			log.info("File Loaded Successfully");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to load file");
			throw new RuntimeException("Failed to load File");
		}
		
		url=prop.getProperty("URL").toLowerCase();
		browserName=prop.getProperty("browserName").toLowerCase();
		
		if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			log.info("edge Driver Setup");
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			log.info("FireFox Driver Setup");
		}else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("Chrome Driver Setup");
			
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		driver.manage().window().maximize();
		log.info("Application of " + url + " launched successfully");
		
	}
	
//	@AfterTest
//	public static void tearDown() {
//		driver.quit();
//	}
	
	
	

	
}
