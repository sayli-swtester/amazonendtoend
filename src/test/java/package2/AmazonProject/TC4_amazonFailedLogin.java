package package2.AmazonProject;

	
import org.testng.asserts.SoftAssert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.BaseClass;

	public class TC4_amazonFailedLogin extends BaseClass {

		@Test
		public void login() throws InterruptedException
		{
			 HomePage homepage=new HomePage(driver);
	            homepage.hoverOverOnAccountandList(driver);
	            homepage.signinClick();
	            Reporter.log("Hoverover on account and List and Click on sigin is successful");
	            
	    LoginPage loginpage=new LoginPage(driver);
	    loginpage.enterIncorrectUsername();;
	    loginpage.continueClick();
	    loginpage.enterIncorrectPassword();;
	    loginpage.signinClick();
	    
		 Thread.sleep(2000);

		 SoftAssert soft = new SoftAssert();

		 String expected = "There was a problem";
		 String actual = driver.findElement(By.xpath("//h4")).getText();

		 soft.assertEquals(actual, expected);
		 soft.assertAll();
		 Reporter.log("Error message displayed correctly for invalid username/password");
		}

	}


