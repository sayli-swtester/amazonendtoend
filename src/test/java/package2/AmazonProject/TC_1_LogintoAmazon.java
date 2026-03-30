package package2.AmazonProject;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ExcelSheetCode;

public class TC_1_LogintoAmazon extends BaseClass{
    
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
    loginpage.enterPassword(password);
    loginpage.signinClick();
    
    Reporter.log("UserName and Password has been entered successfully");

    SoftAssert s1=new SoftAssert();
    s1.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Assertion Failed for Test Case 1 since the title is not matching");
    s1.assertAll();
    Reporter.log("Test Case is Pass as Assertion is also Pass");
    }

}
