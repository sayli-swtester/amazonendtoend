package package2.AmazonProject;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ExcelSheetCode;

import org.testng.Reporter;
public class TC_2_LogintoAmazonandLogout extends BaseClass{
    @Test
    public void withValidCredentials() throws Exception 
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
    Thread.sleep(2000);
    loginpage.enterPassword(password);
    loginpage.signinClick();
    Thread.sleep(3000);
    Reporter.log("UserName and Password has been entered and login is successful");
    
    homepage.hoverOverOnAccountandList(driver);
    homepage.signOutClick();
    Reporter.log("Hoverover on account and List and Click on signout is successful");
    
  //  Assert.assertEquals(driver.getTitle(), "Amazon Sign-In"); //hard assert
    
    SoftAssert soft = new SoftAssert();

    soft.assertEquals(driver.getTitle(), "Amazon Sign-In");
    soft.assertAll();
    
    Reporter.log("Test Case is Pass as Assertion is also Pass");
    
    }
}
