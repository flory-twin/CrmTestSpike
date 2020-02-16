package kflory.web.selenium.testCrm.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;

import kflory.web.selenium.testCrm.properties.RootPather;
import kflory.web.selenium.testCrm.properties.SimplePropsReader;

public class BasePage
{
   WebDriver driver;
   
   protected String url;
   protected FluentWait<WebDriver> pageWait;
   // Poor man's context: Place permissions properties file (and potentially others) in scope for everybody.
   protected SimplePropsReader reader;
   
   private BasePage() {
      // Fetch the project/permissions properties.
      reader = new SimplePropsReader();
      try
      {
         reader.readPermissions();
      } catch (FileNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      // Set up the Firefox binary location.
      Path firefoxBinaryPath = Paths.get("/usr/bin/firefox");
      //System.setProperty("webdriver.firefox.bin", firefoxBinaryPath);
      
      //System.getProperties().forEach((k, v) -> System.out.println("Key: " + k + "; Value: " + v));
      
    //TODO: Probably would not work in Production version
      Path geckodriverBinaryPath =
            RootPather.rootPath.resolve("include/geckodriver-v0.26.0-linux64/geckodriver");
      
      System.setProperty("webdriver.gecko.driver", geckodriverBinaryPath.toString());
      //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
      //FirefoxOptions options = new FirefoxOptions();
      //options.setBinary(geckodriverBinaryPath);
      //capabilities.setCapability("marionette",true);
      driver = new FirefoxDriver();
      
      // Near-verbatim pull from https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
      pageWait = new FluentWait<WebDriver>(driver)       
            .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
            .pollingEvery(Duration.of(5, ChronoUnit.SECONDS))
            .ignoring(NoSuchElementException.class);
   }
   
   protected BasePage(String pageUrl) {
      this();
      url = pageUrl;
   }
   
   public String getUrl() {
      return url;
   }
   
   public void openPage(WebElement waitUntilElementPresent) {
      driver.navigate().to(url);
   }
   
   // Temporary--allows driver validation
   public void openPage() {
      //driver.get("https://makepi-ui.i3detroit.org/login");
      driver.navigate().to("https://makepi-ui.i3detroit.org/login");
      pageWait.until(ExpectedConditions.urlToBe(url));
   }
}
