package finalproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base 
{

	public static WebDriver driver;
    public static Properties prop;
    public static void loadConfiguration()
    {
        try {
            prop=new Properties();
            System.out.println("super construtor invoked");
            FileInputStream ip=new FileInputStream("C:\\Users\\Suman\\eclipse-workspace\\finalproject\\config\\config.properties");
            prop.load(ip);
            }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
public static void launchApp() 
    
    {
        WebDriverManager.edgedriver().setup();
        String browserName = prop.getProperty("browser");
        if (browserName.contains("Chrome")) {
            driver = (WebDriver)new ChromeDriver();
        }
        else if (browserName.contains("Edge")) {
            base.driver = (WebDriver)new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }
public static String getUsername() {
    return prop.getProperty("username");
   }

}
