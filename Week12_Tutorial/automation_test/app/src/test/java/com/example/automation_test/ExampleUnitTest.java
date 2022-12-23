package com.example.automation_test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void calculation_test() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.calculator");
        dc.setCapability("appActivity", ".MainActivity");

        AndroidDriver ad= new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),dc);


        WebElement el7 = (WebElement ) ad.findElement(By.id("com.calculator:id/tvSeven"));
        el7.click();
        WebElement  el8 = (WebElement ) ad.findElement(By.id("com.calculator:id/tvPlus"));
        el8.click();
        WebElement  el9 = (WebElement ) ad.findElement(By.id("com.calculator:id/tvEight"));
        el9.click();
        WebElement  el10 = (WebElement ) ad.findElement(By.id("com.calculator:id/tvEquals"));
        el10.click();

        assertEquals(ad.findElement(By.id("com.calculator:id/tvResult")).getText(),"15");
    }
}