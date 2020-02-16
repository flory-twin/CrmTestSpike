package kflory.web.selenium.testCrm.pages;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage
{
   WebDriver driver;
   
   public BasePage() {
      // Set up the Firefox binary location.
      Path firefoxBinaryPath = Paths.get("/usr/bin/firefox");
      //System.setProperty("webdriver.firefox.bin", firefoxBinaryPath);
      
      //System.getProperties().forEach((k, v) -> System.out.println("Key: " + k + "; Value: " + v));
      
    //TODO: Probably would not work in Production version
      String geckodriverBinaryPathString = 
            System.getProperty("user.dir") +
            "/include/geckodriver-v0.26.0-linux64/geckodriver";
      Path geckodriverBinaryPath = Paths.get(geckodriverBinaryPathString);
      
      System.setProperty("webdriver.gecko.driver", geckodriverBinaryPathString);
      //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
      //FirefoxOptions options = new FirefoxOptions();
      //options.setBinary(geckodriverBinaryPath);
      //capabilities.setCapability("marionette",true);
      driver = new FirefoxDriver();
   }
   
   // Temporary--allows driver validation
   public void doOpenPage() {
      //driver.get("https://makepi-ui.i3detroit.org/login");
      driver.navigate().to("https://makepi-ui.i3detroit.org/login");
   }
}
