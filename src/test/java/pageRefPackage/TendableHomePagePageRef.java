package pageRefPackage;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.Gson;

import io.cucumber.datatable.DataTable;

public class TendableHomePagePageRef extends TestUtility
{
	//Constructor Method
	public TendableHomePagePageRef(RemoteWebDriver driver) throws Exception
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Operational Methods
	public void launchWebApplication(String url) throws Exception
	{
		driver.get(url);
		fnExpectedConditionsvisibilityOfElementLocated("//*[@alt='Tendable Logo']");
	}
	
	public void verifyTopLevelMenus(String menuList) throws Exception
	{
		List<String> allMenuItems=new Gson().fromJson(menuList, List.class);
		for(int i=0;i<allMenuItems.size();i++)
		{
			if(allMenuItems.get(i).equals("tendable"))
			{
				fnhighlightElement("//*[@alt='Tendable Logo']");
				fnclick("//*[@alt='Tendable Logo']");
				fnscrollIntoView("//*[text()='What is Tendable?']");
				fnhighlightElement("//*[text()='What is Tendable?']");
			}
			else if(allMenuItems.get(i).equals("Our Story"))
			{
				fnhighlightElement("//*[text()='Our Story']");
				fnclick("//*[text()='Our Story']");
				fnscrollIntoView("//*[text()='Our Origin Story']");
				fnhighlightElement("//*[text()='Our Origin Story']");
			}
			else if(allMenuItems.get(i).equals("Our Solution"))
			{
				fnhighlightElement("//*[text()='Our Solution']");
				fnclick("//*[text()='Our Solution']");
				fnscrollIntoView("//*[text()='Quality inputs deliver']");
				fnhighlightElement("//*[text()='Quality inputs deliver']");
			}
			else if(allMenuItems.get(i).equals("Why Tendable?"))
			{
				fnhighlightElement("//*[text()='Why Tendable?']");
				fnclick("//*[text()='Why Tendable?']");
				fnscrollIntoView("//*[starts-with(text(),'Why should you')]");
				fnhighlightElement("//*[starts-with(text(),'Why should you')]");
			}
		}
	}
	
	public void verifyRequestADemoButton(String button, String menuList) throws Exception
	{
		List<String> allMenuItems=new Gson().fromJson(menuList, List.class);
		for(int i=0;i<allMenuItems.size();i++)
		{
			if(allMenuItems.get(i).equals("tendable"))
			{
				fnclick("//*[@alt='Tendable Logo']");
				fnExpectedConditionsvisibilityOfElementLocated("//*[text()='What is Tendable?']");
				try
				{
					if(driver.findElement(By.xpath("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']")).isDisplayed())
					{
						fnscrollIntoView("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']");
						fnhighlightElement("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']");
						System.out.println("Request a Demo button is displayed under "+allMenuItems.get(i));
					}
				}
				catch(Exception ex)
				{
					System.out.println("Request a Demo button is not displayed under "+allMenuItems.get(i));
				}
			}
			else if(allMenuItems.get(i).equals("Our Story"))
			{
				fnclick("//*[text()='Our Story']");
				fnExpectedConditionsvisibilityOfElementLocated("//*[text()='Our Origin Story']");
				try
				{
					if(driver.findElement(By.xpath("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']")).isDisplayed())
					{
						fnscrollIntoView("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']");
						fnhighlightElement("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']");
						System.out.println("Request a Demo button is displayed under "+allMenuItems.get(i));
					}
				}
				catch(Exception ex)
				{
					System.out.println("Request a Demo button is not displayed under "+allMenuItems.get(i));
				}
			}
			else if(allMenuItems.get(i).equals("Our Solution"))
			{
				fnclick("//*[text()='Our Solution']");
				fnExpectedConditionsvisibilityOfElementLocated("//*[text()='Quality inputs deliver']");
				try
				{
					if(driver.findElement(By.xpath("//*[@id='top-banner']/following-sibling::div//*[text()='Request a demo']")).isDisplayed())
					{
						fnscrollIntoView("//*[@id='top-banner']/following-sibling::div//*[text()='Request a demo']");
						fnhighlightElement("//*[@id='top-banner']/following-sibling::div//*[text()='Request a demo']");
						System.out.println("Request a Demo button is displayed under "+allMenuItems.get(i));
					}
				}
				catch(Exception ex)
				{
					System.out.println("Request a Demo button is not displayed under "+allMenuItems.get(i));
				}
			}
			else if(allMenuItems.get(i).equals("Why Tendable?"))
			{
				fnclick("//*[text()='Why Tendable?']");
				fnExpectedConditionsvisibilityOfElementLocated("//*[starts-with(text(),'Why should you')]");
				try
				{
					if(driver.findElement(By.xpath("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']")).isDisplayed())
					{
						fnscrollIntoView("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']");
						fnhighlightElement("//*[@id='top-banner']/following-sibling::div//*[text()='"+button+"']");
						System.out.println("Request a Demo button is displayed under "+allMenuItems.get(i));
					}
				}
				catch(Exception ex)
				{
					System.out.println("Request a Demo button is not displayed under "+allMenuItems.get(i));
				}
			}
		}
	}
	
	public void clickOnMenu(String menuName) throws Exception
	{
		fnclick("//*[text()='"+menuName+"']");
		Thread.sleep(2000);
	}
	
	public void clickOnContact(String btnName, String section) throws Exception
	{
		fnclickUsingJS("//*[contains(text(),'"+section+"')]/following-sibling::*//*[text()='"+btnName+"']");
		Thread.sleep(2000);
	}
	
	public void fillMarketingContactForm(DataTable dt) throws Exception
	{
		fnExpectedConditionsvisibilityOfElementLocated("//form[contains(@id,'contactMarketing') and @class='registerForm']");
		List<Map<String,String>> list=dt.asMaps();
		fnsendKeys("(//input[@placeholder='Full Name'])[1]", list.get(0).get("Full Name"));
		fnsendKeys("(//input[@placeholder='Organisation Name '])[1]", list.get(0).get("Organisation Name"));
		fnsendKeys("(//input[@placeholder='Phone Number'])[1]", list.get(0).get("Phone Number"));
		fnsendKeys("(//input[@placeholder='Email'])[1]", list.get(0).get("Email"));
		Select s=new Select(driver.findElement(By.xpath("(//select[@name='jobRole'])[1]")));
		s.selectByVisibleText("Executive Board Member");
		Thread.sleep(2000);
		fnclick("(//label[text()='Consent Agreed']/following-sibling::*[text()='I Agree']/input[@name='consentAgreed'])[1]");
		fnscrollIntoView("(//label[text()='Consent Agreed']/following-sibling::*[text()='I Agree']/input[@name='consentAgreed'])[1]");
		Thread.sleep(2000);
		fnclick("(//button[text()='Submit'])[1]");
		Thread.sleep(3000);
		try
		{
			if(driver.findElement(By.xpath("(//textarea[@placeholder='Type your message here '])[1]/following-sibling::*//*[text()='This field is required']")).isDisplayed())
			{
				fnscrollIntoView("(//textarea[@placeholder='Type your message here '])[1]");
				Thread.sleep(2000);
				fnhighlightElement("(//textarea[@placeholder='Type your message here '])[1]/following-sibling::*//*[text()='This field is required']");
				Thread.sleep(2000);
				Assert.assertTrue(true);
				System.out.println("Error message is displayed");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error message is not displayed");
			Assert.assertTrue(false);
		}
	}
}