package package2.AmazonProject;

import org.testng.annotations.Test;

import utility.BaseClass;

public class TC_6_AmazonRegistration extends BaseClass{
    
    @Test
    public void withValidCredentials() 
    {
            
            HomePage homepage=new HomePage(driver);
            
            homepage.hoverOverOnAccountandList(driver);
}
}
