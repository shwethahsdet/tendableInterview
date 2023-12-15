package stepDefPackage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageRefPackage.TendableHomePagePageRef;

public class TendableHomePageStepDef
{
	public TendableHomePagePageRef thp;
	
	public TendableHomePageStepDef() throws Exception
	{
		thp=new TendableHomePagePageRef(CucumberHooks.driver);
	}
	
	@Given("^user launch the website using the URL \"(.*)\"$")
	public void launchWebApplication(String url) throws Exception
	{
		thp.launchWebApplication(url);
	}
	
	@Then("^user verify the accessibility of the \"(.*)\"$")
	public void verifyTopLevelMenus(String menuList) throws Exception
	{
		thp.verifyTopLevelMenus(menuList);
	}
	
	@And("^user verify \"(.*)\" button under \"(.*)\"$")
	public void verifyRequestADemoButton(String button, String menuList) throws Exception
	{
		thp.verifyRequestADemoButton(button, menuList);
	}
	
	@When("^user navigate to \"(.*)\" page$")
	public void clickOnMenu(String menuName) throws Exception
	{
		thp.clickOnMenu(menuName);
	}
	
	@And("^user clicks \"(.*)\" button under \"(.*)\" in Contact us page$")
	public void clickOnContact(String btnName, String section) throws Exception
	{
		thp.clickOnContact(btnName, section);
	}
	
	@When("^user fill the Marketing Contact form and validate the submission$")
	public void fillMarketingContactForm(DataTable dt) throws Exception
	{
		thp.fillMarketingContactForm(dt);
	}
}