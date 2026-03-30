package package2.AmazonProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ExcelSheetCode;
import utility.ListnersLogic;
import utility.RetryLogic;
@Listeners(ListnersLogic.class)

public class TC_3_LoginSearchingWishListcartLogout extends BaseClass{
        @Test(retryAnalyzer=RetryLogic.class)
        public void searchingTheProduct_WL_Cart() throws Exception {
                Reporter.log("Browser and URL launched successfully");
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
        Reporter.log("UserName and Password has been entered and login is successful");
        
        homepage.searchingProduct();
        SearchResultPage searchresultpage=new SearchResultPage(driver);
        searchresultpage.clickFirstProduct_movingTheControl(driver);
        Reporter.log("Searching the product(Laptop),clicking on the first result and moving the control to it is successful");
        
        ProductPage productpage= new ProductPage(driver);
        productpage.wishListAddition();
        Thread.sleep(2000);
        productpage.addingToCart();
        Thread.sleep(2000);
        Reporter.log("click on WishList,click on add to cart is successful");
        
        homepage.hoverOverOnAccountandList(driver);
        homepage.signOutClick();
Reporter.log("Hoverover on account and List and Click on signout is successful");
        
        Assert.assertEquals(driver.getTitle(), "Amazon Sign-In");
        
        Reporter.log("Test Case is Pass as Assertion is alos Pass");
        
        }

}
