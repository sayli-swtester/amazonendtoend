package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersLogic implements ITestListener
{
        public static WebDriver driver;
        static String pathOfScannershot(String status)
        {
               

          String path="D:\\seleniummay2024\\AmazonProject\\test-output\\screenshots\\"+status+"\\";   
          
          return path;
                
        }
        
         @Override
            public void onTestSuccess(ITestResult result) {
             
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                String path1=        pathOfScannershot("Pass");
                File destination = new File(path1+result.getName()+".png");

                try {
                    FileHandler.copy(source, destination);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onTestFailure(ITestResult result) {
                   WebDriver driver = (WebDriver) result.getTestContext()
                        .getAttribute("driver");   // ✅ get driver dynamically

                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                String path1 = pathOfScannershot("Fail");
                File destination = new File(path1 + result.getName() + ".png");

                try {
                    FileHandler.copy(source, destination);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
}


