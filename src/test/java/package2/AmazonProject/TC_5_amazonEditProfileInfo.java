package package2.AmazonProject;

import org.testng.Assert;
import org.testng.Reporter;

import utility.BaseClass;
import utility.ExcelSheetCode;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class TC_5_amazonEditProfileInfo  extends BaseClass{
	
	String msg;
	@Test
	 public void editProfile() throws Exception 
	    {
    HomePage homepage=new HomePage(driver);
    homepage.hoverOverOnAccountandList(driver);
    homepage.signinClick();
    Reporter.log("Hoverover on account and List and Click on sigin is successful");
    

    String username = ExcelSheetCode.getCellData(1, 0);
    String password = ExcelSheetCode.getCellData(1, 1);
    
LoginPage loginpage=new LoginPage(driver);
loginpage.enterUsername(username);
loginpage.continueClick();
loginpage.enterPassword(password);
loginpage.signinClick();
homepage.hoverOverOnAccountandList(driver);
EditProfilePage editpage=new EditProfilePage(driver);
editpage.clickeditaccount();
editpage.clickeditinfo();
//loginpage.enterPassword();
loginpage.signinClick();
editpage.clickeditname();
editpage.savechanges();
String actualMsg =editpage.updatedname(msg);



Assert.assertEquals(actualMsg, "Name updated.", "Name was not updated successfully");
}
}