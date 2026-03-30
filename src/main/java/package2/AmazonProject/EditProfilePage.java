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


    public class EditProfilePage 
    {
            WebDriver driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            public EditProfilePage(WebDriver driver)
            {
                    PageFactory.initElements(driver, this);
            }
                     
            
            @FindBy(xpath="//span[text()='Your Account']")
            private WebElement myaccount;
            
            @FindBy(xpath="//span[text()='Edit login, name, and mobile number']")
            private WebElement editinfo;
            
            @FindBy(xpath="//a[@aria-label='Edit name']")
            private WebElement editname;
            
            @FindBy(xpath="//span[@class='Save changes']")
            private WebElement savechanges;
            
                    @FindBy (xpath="//span[text()='Name updated.']")
                    WebElement nameupdated;
            public void clickeditaccount()
            {wait.until(ExpectedConditions.elementToBeClickable(myaccount));
            	myaccount.click();
            }
            
            public void clickeditinfo()
            {wait.until(ExpectedConditions.elementToBeClickable(editinfo));
            	editinfo.click();
            }
            public void clickeditname()
            {wait.until(ExpectedConditions.elementToBeClickable(editname));
            	editname.click();
            }
            public void savechanges()
            {wait.until(ExpectedConditions.elementToBeClickable(savechanges));
            	savechanges.click();
            }
            
            public String updatedname(String msg1)
            { wait.until(ExpectedConditions.visibilityOf(nameupdated));
            	String msg = nameupdated.getText();
            	return msg;
            }
    }

