package stepDefPackage;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageRefPackage.TestUtility;

public class CucumberHooks
{
	public static RemoteWebDriver driver;
	public Scenario scenario;
	public Properties properties;
	public TestUtility testUtil;

	@Before
	public void beforeScenario(Scenario scenario) throws Exception
	{
		// Load Properties
		properties=new Properties();
		InputStream in=getClass().getResourceAsStream("/properties/config.properties");
		properties.load(in);
		if(properties.getProperty("Browser").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(co);
			driver.manage().window().maximize();
		}
		else if(properties.getProperty("Browser").equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			EdgeOptions eo=new EdgeOptions();
			eo.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(eo);
			driver.manage().window().maximize();
		}
		else
		{
			System.out.println("Browser name is invalid. Please check and run again..!");
			System.exit(0);
		}
		// Create PageObject class object
		testUtil=new TestUtility(driver);
	}

	@After
	public void afterScenario() throws Exception
	{
		driver.quit();
	}
}