package com.calculator

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.calculator", appContext.packageName)
    }

    @Test
    fun UnitTest(){
        val dc = DesiredCapabilities()
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        dc.setCapability("platformName", "android")
        dc.setCapability("appPackage", "com.calculator")
        dc.setCapability("appActivity", ".MainActivity")

        val ad = AndroidDriver(URL("http://127.0.0.1:4723/wd/hub"), dc)

        val el1 = ad.findElement(By.id("com.calculator:id/tvTwo")) as WebElement
        el1.click()
        val el2 = ad.findElement(By.id("com.calculator:id/tvFive")) as WebElement
        el2.click()
        val el3 = ad.findElement(By.id("com.calculator:id/tvPlus")) as WebElement
        el3.click()
        val el4 = ad.findElement(By.id("com.calculator:id/tvThree")) as WebElement
        el4.click()
        val el5 = ad.findElement(By.id("com.calculator:id/tvNine")) as WebElement
        el5.click()
        val el6 = ad.findElement(By.id("com.calculator:id/tvEquals")) as WebElement
        el6.click()

        assertEquals(ad.findElement(By.id("com.calculator:id/tvResult")).text, 64)
    }
}