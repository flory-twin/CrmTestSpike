package kflory.web.selenium.testCrm;

import kflory.web.selenium.testCrm.pages.AngularLoginPage;
import kflory.web.selenium.testCrm.pages.BasePage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AngularLoginPage a = new AngularLoginPage();
        // TODO: Change to properties file (remember to add entry in .gitignore!!)
        a.doLogin("kflory", "TZlOtvJ36ioRst8fdZ2l");
    }
}
