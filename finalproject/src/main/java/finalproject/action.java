package finalproject;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class action extends base {
	public static void click(WebDriver driver,WebElement locator) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(locator).click().build().perform();
		System.out.println("clicked on" + locator);
	}
	public static void selectDropdownOption(WebElement elem, String Textoption) {
        Select select = new Select(elem);
        select.selectByVisibleText(Textoption);
        elem.sendKeys(Keys.ENTER);
    }
	public static void Wait( WebDriver driver, int sec) {
        driver.manage().timeouts().implicitlyWait((long)sec, TimeUnit.SECONDS);
    }
	public static boolean type(WebElement elem, String text)
    {
        boolean flag =false;
        try
        {
            flag=elem.isDisplayed();
            elem.clear();
            elem.sendKeys(text);
            flag=true;
        }
        catch(Exception e)
        {
            System.out.println("Location not found");
            flag=false;
        }
        finally
        {
            if(flag)
            {
                System.out.println("Successfully entered value");
            }
            else
            {
                System.out.println("Unable to enter value");
            }
        }
        if (flag) {
            System.out.println("successfully enetered");
        }
        else {
            System.out.println("unable to enter value");
        }
        return flag;
    }
	
}
