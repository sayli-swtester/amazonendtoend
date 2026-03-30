package package2.AmazonProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage 
{
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver)
    {
        this.driver = driver;   // ✅ IMPORTANT (you missed this earlier sometimes)
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath="//input[@aria-label='Add to Wish List']")
    private WebElement wishListButton;

    @FindBy(xpath="(//span[@id='submit.add-to-cart'])[2]")
    private WebElement addToCartButton;

    @FindBy(xpath="//span[contains(@class,'attach-primary-cart-button')]")
    private WebElement cartButton;

    // ------------------ METHODS ------------------

    public void wishListAddition()
    {
        // Click Wishlist
        wait.until(ExpectedConditions.elementToBeClickable(wishListButton)).click();

        // Locators for dynamic popups
        By createBtn = By.xpath("//span[text()='Create']");
        By continueBtn = By.xpath("//span[text()='Continue shopping']");

        // Handle Create popup
        if(driver.findElements(createBtn).size() > 0)
        {
            wait.until(ExpectedConditions.elementToBeClickable(createBtn)).click();
        }
        // Handle Continue Shopping popup
        else if(driver.findElements(continueBtn).size() > 0)
        {
            wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        }
    }

    public void addingToCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }
}