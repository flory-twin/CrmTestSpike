package kflory.web.selenium.testCrm.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Expects properties file entries "username" and "password".
 * @author kflory
 *
 */
public class SimplePropsReader
{
   // Copied with minor changes from https://www.baeldung.com/java-properties.
   public static final Path permsFilePath = RootPather.rootPath.resolve("perms.properties");
   
   private Properties permProps;
   
   public SimplePropsReader( ) {
      permProps = new Properties();
      // Set default values so consumers of this class have a (sort of) fallback.
      permProps.put("username", "FLAG_VALUE_PREREAD");
      permProps.put("password", "FLAG_VALUE_PREREAD");
   }
         
   public void readPermissions() throws FileNotFoundException, IOException {
      permProps = new Properties();
      permProps.load(new FileInputStream(permsFilePath.toFile()));
   }

}
