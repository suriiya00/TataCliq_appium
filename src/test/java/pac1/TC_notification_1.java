package pac1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tatacliq.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.net.URL;

public class TC_notification_1 extends ExtentManager {

    public static void main(String[] args) {
        AndroidDriver<MobileElement> driver = null;

        // ✅ Initialize Extent Report
        ExtentReports extent = ExtentManager.getinstance();
        ExtentTest test = extent.createTest("TC_notification_1 - Add & Remove Product Flow");

        try {
            test.log(Status.INFO, "Setting up Desired Capabilities...");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 11T 5G");
            caps.setCapability(MobileCapabilityType.UDID, "VSXWQ4HQWSBMCMHA");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.NO_RESET, true);

            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tul.tatacliq");
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.tul.tatacliq.activities.NewHomeActivity");

            test.log(Status.INFO, "Initializing Appium Driver...");
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);

            WebDriverWait wait = new WebDriverWait(driver, 30);

            MobileElement girlElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().className(\"android.view.View\").instance(7)"
            );
            wait.until(ExpectedConditions.elementToBeClickable(girlElement));
            girlElement.click();
            test.pass("Clicked on the Girl element successfully!");

            Thread.sleep(5000);

            MobileElement fragnaceElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"com.tul.tatacliq:id/iv_prod_image\").instance(2)"
            );
            wait.until(ExpectedConditions.elementToBeClickable(fragnaceElement));
            fragnaceElement.click();
            test.pass("Clicked on the Fragrance element successfully!");

            MobileElement ProductElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"com.tul.tatacliq:id/imageView\").instance(0)"
            );
            wait.until(ExpectedConditions.elementToBeClickable(ProductElement));
            ProductElement.click();
            test.pass("Clicked on the Product element successfully!");

            MobileElement CartElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"com.tul.tatacliq:id/textViewAddToCart\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(CartElement));
            CartElement.click();
            test.pass("Clicked on the Cart element successfully!");

            Thread.sleep(5000);

            MobileElement GocartElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"com.tul.tatacliq:id/cartBadge\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(GocartElement));
            GocartElement.click();
            test.pass("Clicked on the GoCart element successfully!");

            Thread.sleep(5000);

            MobileElement RemoveElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"com.tul.tatacliq:id/text_view_remove_product\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(RemoveElement));
            RemoveElement.click();
            test.pass("Clicked on the Remove element successfully!");

            test.pass("Test completed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            // Log the error in Extent report
            ExtentTest test1 = extent.createTest("Exception");
            test1.fail("Test failed due to: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }

            // ✅ Must call this to actually create the HTML report
            extent.flush();
            System.out.println("Extent Report generated successfully!");
        }
    }
}
