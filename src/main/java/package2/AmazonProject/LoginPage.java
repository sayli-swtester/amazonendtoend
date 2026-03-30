package package2.AmazonProject;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage 
{
	 WebDriver driver;
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 

     public LoginPage(WebDriver driver)
     {
             PageFactory.initElements(driver, this);
     }
     
     
     @FindBy(name="email")
     private WebElement username;
     
     @FindBy(id="continue")
     private WebElement continuebutton;
     
     @FindBy(name="password")
     private WebElement password;
     
     @FindBy(id="signInSubmit")
     private WebElement signIn;
     
     public void enterUsername(String user)
     {
         wait.until(ExpectedConditions.visibilityOf(username));
         username.sendKeys(user);
     }
     public void enterIncorrectUsername()
     {  wait.until(ExpectedConditions.visibilityOf(username));
             username.sendKeys("kamble@yahoo.in");
             }
     
     public void continueClick()
     {  wait.until(ExpectedConditions.elementToBeClickable(continuebutton));
             continuebutton.click();
     }
     
     public void enterPassword(String pass)
     { 
    	 wait.until(ExpectedConditions.visibilityOf(password));
             password.sendKeys(pass);        
             }
     
     public void enterIncorrectPassword()
     { wait.until(ExpectedConditions.visibilityOf(password));
             password.sendKeys("asdffg");        
             }
     public void signinClick()
     { wait.until(ExpectedConditions.elementToBeClickable(signIn));
             signIn.click();
     }
     
     
}
