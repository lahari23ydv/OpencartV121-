package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	private static final Logger logger = LogManager.getLogger(TC001_AccountRegistrationTest.class);
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest   *****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		
	
AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
logger.info("Providing customer details....");
regpage.setFirstName(randomeString().toUpperCase());
regpage.setLastName(randomeString().toUpperCase());
regpage.setEmail(randomeString()+"@gmail.com"); //randomly generated the email
regpage.setTelephone(randomeNumber());


String password=randomeAlphaNumeric();

regpage.setPassword(password);
regpage.setConfirmPassword(password);

regpage.setPrivacyPolicy();
regpage.clickContinue();

logger.info("Validating expected message...");

String confmsg= regpage.getConfirmationMsg();
Assert.assertEquals(confmsg, "Your Account Has Been Created!");

}
		catch(Exception e)
		{
			//logger.error("Test failed....");
			logger.error("Test failed due to exception: ", e);
			logger.debug("Debug logs....");
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		

		logger.info("Finished Test Case...");
	}
	

	
		
}
