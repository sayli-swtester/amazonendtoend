package package2.AmazonProject;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


    public class HomePage 
    {
            WebDriver driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            public HomePage(WebDriver driver)
            {
                    PageFactory.initElements(driver, this);
            }
            
            @FindBy(id="nav-item-signout")
            private WebElement logout;
            
            public void signOutClick()
            {
                    logout.click();
            }
            @FindBy(xpath="//span[@class='nav-line-2 ']")
            private WebElement accountAndList;
            
            @FindBy(xpath="//a[@class='nav-action-signin-button']")
            private WebElement signIn;

            @FindBy(id="twotabsearchtextbox")
            private WebElement searchBar;
            
            @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
            private WebElement newcustomer;
            
            @FindBy(id="ap_email_login")
            private WebElement emaillogin;
            
            public void hoverOverOnAccountandList(WebDriver driver)
            {       wait.until(ExpectedConditions.visibilityOf(accountAndList));
                    Actions a1=new Actions(driver);
                    a1.moveToElement(accountAndList).perform();
            }
            public void signinClick()
            { wait.until(ExpectedConditions.elementToBeClickable(signIn));
                    signIn.click();
            }
            public void searchingProduct()
            {  wait.until(ExpectedConditions.visibilityOf(searchBar));
                    searchBar.sendKeys("Laptop"+Keys.ENTER);
            }
            public void clickNewRegistration()
            {  wait.until(ExpectedConditions.elementToBeClickable(newcustomer));
            	newcustomer.click();
            }
          
    }

