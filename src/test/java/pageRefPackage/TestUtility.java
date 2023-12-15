package pageRefPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility
{
	public RemoteWebDriver driver;
	public WebDriverWait wdwait;
	public int twentySecondsTimeout=20;
	
	public TestUtility(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to wait until an element becomes visible using xpath locator
	 */
	public void fnExpectedConditionsvisibilityOfElementLocated(String xpathLocator) throws Exception
	{
		wdwait=new WebDriverWait(driver, Duration.ofSeconds(twentySecondsTimeout));
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
	}

	/**
	 * This method is used to wait until an element becomes visible using any locator which is already located in page class
	 */
	public void fnExpectedConditionsvisibilityOf(WebElement element) throws Exception
	{
		wdwait=new WebDriverWait(driver, Duration.ofSeconds(twentySecondsTimeout));
		wdwait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until an element becomes clickable using xpath locator
	 */
	public void fnExpectedConditionselementToBeClickable(String xpathLocator) throws Exception
	{
		wdwait=new WebDriverWait(driver, Duration.ofSeconds(twentySecondsTimeout));
		wdwait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
	}

	/**
	 * This method is used to wait until an element becomes clickable using any locator which is already located in page class
	 */
	public void fnExpectedConditionselementToBeClickable(WebElement element) throws Exception
	{
		wdwait=new WebDriverWait(driver, Duration.ofSeconds(twentySecondsTimeout));
		wdwait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to wait and click an element using xpath locator
	 */
	public void fnclick(String xpathLocator) throws Exception
	{
		fnExpectedConditionsvisibilityOfElementLocated(xpathLocator);
		fnExpectedConditionselementToBeClickable(xpathLocator);
		WebElement element=driver.findElement(By.xpath(xpathLocator));
		fnhighlightElement(element);
		element.click();
	}

	/**
	 * This method is used to wait and click an element using any locator which is already located in page class
	 */
	public void fnclick(WebElement element) throws Exception
	{
		fnExpectedConditionsvisibilityOf(element);
		fnExpectedConditionselementToBeClickable(element);
		fnhighlightElement(element);
		element.click();
	}

	/**
	 * This method is used to wait and send data into an element using xpath locator
	 */
	public void fnsendKeys(String xpathLocator, String data) throws Exception
	{
		fnExpectedConditionsvisibilityOfElementLocated(xpathLocator);
		WebElement element=driver.findElement(By.xpath(xpathLocator));
		fnhighlightElement(element);
		element.sendKeys(data);
	}

	/**
	 * This method is used to wait and send data into an element using any locator which is already located in page class
	 */
	public void fnsendKeys(WebElement element, String data) throws Exception
	{
		fnExpectedConditionsvisibilityOf(element);
		fnhighlightElement(element);
		element.sendKeys(data);
	}
	
	/**
	 * This method is used to wait and click an element using xpath locator using JavaScript
	 */
	public void fnclickUsingJS(String xpathLocator) throws Exception
	{
		fnExpectedConditionsvisibilityOfElementLocated(xpathLocator);
		fnExpectedConditionselementToBeClickable(xpathLocator);
		WebElement element=driver.findElement(By.xpath(xpathLocator));
		fnhighlightElement(element);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method is used to wait and click an element using any locator which is already located in page class using JavaScript
	 */
	public void fnclickUsingJS(WebElement element) throws Exception
	{
		fnExpectedConditionsvisibilityOf(element);
		fnExpectedConditionselementToBeClickable(element);
		fnhighlightElement(element);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method is used to highlight an element using xpath locator
	 */
	public void fnhighlightElement(String xpathLocator) throws Exception
	{
		fnExpectedConditionsvisibilityOfElementLocated(xpathLocator);
		WebElement element=driver.findElement(By.xpath(xpathLocator));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red';", element);
	}

	/**
	 * This method is used to highlight an element using any locator which is already located in page class
	 */
	public void fnhighlightElement(WebElement element) throws Exception
	{
		fnExpectedConditionsvisibilityOf(element);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red';", element);
	}
	
	/**
	 * This method is used to scroll to an element to bring it to visibility using xpath locator
	 */
	public void fnscrollIntoView(String xpathLocator) throws Exception
	{
		fnExpectedConditionsvisibilityOfElementLocated(xpathLocator);
		WebElement element=driver.findElement(By.xpath(xpathLocator));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method is used to scroll to an element to bring it to visibility using any locator which is already located in page class
	 */
	public void fnscrollIntoView(WebElement element) throws Exception
	{
		fnExpectedConditionsvisibilityOf(element);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}