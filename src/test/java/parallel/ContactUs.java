package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUs extends ConfigReader
{
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
	private ConfigReader configReader;
	Properties prop;
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() 
	
	{
		
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
		
	    
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException
	
	{
		configReader = new ConfigReader();
        prop = configReader.init_prop();
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData(prop.getProperty("excelpath"), sheetName);
		
		String email = testData.get(rowNumber).get("email");
		String orderRef = testData.get(rowNumber).get("reference");
		String messageText = testData.get(rowNumber).get("messageText");

		
		contactUsPage.fillContactUsForm(email, orderRef, messageText);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() 
	{
		contactUsPage.clickSend();
	  
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMessage) 
	{
	
	    
	}



}
