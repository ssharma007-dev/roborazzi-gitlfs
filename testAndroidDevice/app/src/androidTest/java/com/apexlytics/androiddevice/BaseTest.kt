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
        const val NAV_TIMEOUT = 3_000L
        // Device-side sdcard directory; pulled to host by pullScreenshots Gradle task after tests
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

    protected fun captureScreen(name: String) {
        // screencap runs as the shell user and always has write access to /sdcard/
        device.executeShellCommand("mkdir -p $DEVICE_SNAPSHOTS_DIR")
        device.executeShellCommand("screencap -p $DEVICE_SNAPSHOTS_DIR/$name.png")
    }
}
