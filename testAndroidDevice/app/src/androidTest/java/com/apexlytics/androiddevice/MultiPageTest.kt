package com.apexlytics.androiddevice

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MultiPageTest : BaseTest() {

    @Before
    fun setUp() = launchApp()

    @Test
    fun multiPage_screenshots() {
        captureScreen("multi_page__1_login")

        // TODO: replace with real credentials
        device.findObject(By.res(APP_PACKAGE, "usernameField"))?.text = "user@example.com"
        device.findObject(By.res(APP_PACKAGE, "passwordField"))?.text = "password123"
        device.findObject(By.text("LOG IN"))?.click()
            ?: device.findObject(By.text("Login"))?.click()
        device.wait(Until.gone(By.res(APP_PACKAGE, "loginButton")), NAV_TIMEOUT)
        Thread.sleep(2000)

        captureScreen("multi_page__2_flow_selector")

        device.findObject(By.clickable(true).pkg(APP_PACKAGE))?.click()
        Thread.sleep(2000)

        captureScreen("multi_page__3_dashboard")
    }
}
