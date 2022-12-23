import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class automation {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.example.calculator");
        dc.setCapability("appActivity", ".MainActivity");

        AndroidDriver ad= new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),dc);


        WebElement el7 = (WebElement ) ad.findElement(By.id("com.example.calculator:id/tvSeven"));
        el7.click();
        WebElement  el8 = (WebElement ) ad.findElement(By.id("com.example.calculator:id/tvPlus"));
        el8.click();
        WebElement  el9 = (WebElement ) ad.findElement(By.id("com.example.calculator:id/tvEight"));
        el9.click();
        WebElement  el10 = (WebElement ) ad.findElement(By.id("com.example.calculator:id/tvEquals"));
        el10.click();

        Assert.assertEquals(ad.findElement(By.id("com.example.calculator:id/tvResult")).getText(),10);
    }
}
