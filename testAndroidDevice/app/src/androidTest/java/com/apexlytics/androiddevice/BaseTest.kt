package com.apexlytics.androiddevice

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until

abstract class BaseTest {

    protected val instrumentation = InstrumentationRegistry.getInstrumentation()
    protected val device: UiDevice = UiDevice.getInstance(instrumentation)

    companion object {
        const val APP_PACKAGE = "com.apexlytics.analyticsxandroid"
        const val LAUNCH_TIMEOUT = 5_000L
        const val NAV_TIMEOUT = 5_000L
        const val DEVICE_SNAPSHOTS_DIR = "/sdcard/roborazzi-snapshots"
    }

    protected fun launchApp() {
        device.pressHome()
        val intent = Intent().apply {
            setClassName(APP_PACKAGE, "$APP_PACKAGE.LoginActivity")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        instrumentation.context.startActivity(intent)
        device.wait(Until.hasObject(By.pkg(APP_PACKAGE).depth(0)), LAUNCH_TIMEOUT)
        Thread.sleep(2000)
    }

    protected fun login(username: String = "user", password: String = "user") {
        device.findObject(By.res(APP_PACKAGE, "usernameInput"))?.apply {
            clear(); text = username
        }
        device.findObject(By.res(APP_PACKAGE, "passwordInput"))?.apply {
            clear(); text = password
        }
        device.findObject(By.res(APP_PACKAGE, "loginButton"))?.click()
        device.wait(Until.hasObject(By.res(APP_PACKAGE, "flowSelectorTitle")), NAV_TIMEOUT)
        Thread.sleep(1000)
    }

    protected fun navigateToFullFlow() {
        device.findObject(By.text("Full Flow"))?.click()
        device.wait(Until.hasObject(By.res(APP_PACKAGE, "dashboardTitle")), NAV_TIMEOUT)
        Thread.sleep(1500)
    }

    protected fun navigateToAiPlayground() {
        device.findObject(By.text("Visual AI Playground"))?.click()
        device.wait(Until.hasObject(By.res(APP_PACKAGE, "playgroundTitle")), NAV_TIMEOUT)
        Thread.sleep(1500)
    }

    protected fun captureScreen(name: String) {
        // screencap runs as shell user — always has write access to /sdcard/
        device.executeShellCommand("mkdir -p $DEVICE_SNAPSHOTS_DIR")
        device.executeShellCommand("screencap -p $DEVICE_SNAPSHOTS_DIR/$name.png")
    }

    protected fun scrollDown(times: Int = 1) {
        repeat(times) {
            device.swipe(540, 1600, 540, 600, 25)
            Thread.sleep(500)
        }
    }
}
