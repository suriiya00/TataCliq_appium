package pac1;
 
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
public class su{
 
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:platformVersion","15");
		caps.setCapability("appium:deviceName","Nothing Phone (2a)");
		  caps.setCapability("appium:udid", "000453487000064");
		  caps.setCapability("appium:appPackage", "com.google.android.calculator");
		  caps.setCapability("appium:appActivity","com.android.calculator2.Calculator");
		  caps.setCapability("appium:automationName", "UiAutomator2");
		  URL url = new URL("http://127.0.0.1:4723");
		  AndroidDriver driver = new AndroidDriver(url, caps);
		  Thread.sleep(5000);
		  
		 // AndroidDriver driver=new AndroidDriver(new URL("https://127.0.0.1:4723/wd/hub"),caps);
 
		  driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		  driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		  driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		  driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		  String total=driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		  System.out.println("The sum is:"+total);
 
 
	}
 
}
 