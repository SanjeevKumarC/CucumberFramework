package stepDefinations;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Resources.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepo.CreateAccountPage;
import pageObjectRepo.LandingPage;

public class LoginWithDatatprovider extends base {
	public static Logger log=LogManager.getLogger(LoginWithDatatprovider.class.getName());
	
	@Given("^Initialize the browser with chrome$")
	public void Initialize_the_browser_With_chrome() throws Throwable {
		driver = initializeDriver();
		log.info("Browser Opened Succesfully"); 
	}
	
	@And("^Navigate To \"([^\"]*)\" sites$")
	public void Navigate_To_Url_sites(String url) {
		driver.get(url);
		log.info("Navigated To reddif home page");
	}
	
	@And("^Verify Home Page Is Displayed$")
	public void Verify_Home_Page_Is_Displayed() throws IOException {
		LandingPage lp = new LandingPage(driver);
		WaitUntilvisibilityOf(lp.Create_Account());
		log.info("Wait Until visibility Of Create Account link");
		Assert.assertTrue(lp.Create_Account().isDisplayed());
		lp.Create_Account().click();
		log.info("Successfully Clicked on create Account");
	}
	
		@When("^Enter (.+) and (.+)$")
		public void enter_fullName_and_RediffMail(String FullName,String chooseARediffmailid) throws IOException {
			CreateAccountPage cap=new CreateAccountPage(driver);
			WaitUntilvisibilityOf(cap.Full_Name());
			cap.Full_Name().click();
			log.info("Successfully Clicked on Full Name TextField");
			cap.Full_Name().sendKeys(FullName);
			log.info("Successfully Entered Full Name in Full Name TextField");
			cap.Choose_a_Rediffmail_ID().click();
			log.info("Successfully Clicked on Choose a Rediffmail Id TextField");
			cap.Choose_a_Rediffmail_ID().sendKeys(chooseARediffmailid);
			log.info("Successfully Choose a Rediffmail Id  in Choose a Rediffmail Id TextField");
		}
		
		@Then("^Check for email availability$")
		public void Check_for_email_availability() {
			CreateAccountPage cap=new CreateAccountPage(driver);
			Assert.assertTrue(cap.Check_availability().isDisplayed());
			log.info("Successfully Clicked Check availability Button");
		}
		
		@Then("^Close browser$")
		public void Close_browser() throws InterruptedException {
			Thread.sleep(500);
			driver.close();
			driver=null;
			log.info("Successfully Browser closed");
			
		}



}
