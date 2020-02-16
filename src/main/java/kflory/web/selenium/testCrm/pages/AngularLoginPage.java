package kflory.web.selenium.testCrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AngularLoginPage extends BasePage
{
   //By usernameInputLocator = By.xpath("//app-login//input[@formcontrolname='email']");
   By usernameInputLocator = By.xpath("//input[@formcontrolname='email']");
   WebElement userEntryField;
   By passwordInputLocator = By.xpath("//app-login//input[@formcontrolname='password']");
   WebElement passwordEntryField;
   By rememberMeInputLocator = By.xpath("//app-login//input[@formcontrolname='remember']");
   WebElement rememberMeCheckbox;
   By forgotPasswordLinkLocator = By.xpath("//app-login//a[contains(text(), 'Forg')][contains(text(), 'Password')]");
   WebElement forgotPasswordLink;
   By loginButtonLocator = By.xpath("//app-login//button[text() = 'Login']");
   WebElement loginButton;
   
   //TODO: Contained class for navbar.
   
   public AngularLoginPage() {
      super("https://makepi-ui.i3detroit.org/login");
      openPage();
      userEntryField = driver.findElement(usernameInputLocator);
      passwordEntryField = driver.findElement(passwordInputLocator);
      rememberMeCheckbox = driver.findElement(rememberMeInputLocator);
      forgotPasswordLink = driver.findElement(forgotPasswordLinkLocator);
      loginButton = driver.findElement(loginButtonLocator);
   }
   
   public void openPage() {
      super.openPage();
      pageWait.until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator));
   }
   public void doLogin(String username, String password) {
      userEntryField.sendKeys(username);
      passwordEntryField.sendKeys(password);
      loginButton.click();
   }

   
   
}
