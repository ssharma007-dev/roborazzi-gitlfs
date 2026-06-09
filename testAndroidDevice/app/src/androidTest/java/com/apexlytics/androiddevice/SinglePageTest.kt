package com.apexlytics.androiddevice

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SinglePageTest : BaseTest() {

    @Before
    fun setUp() = launchApp()

    @Test
    fun singlePage_login_screenshot() {
        captureScreen("single_page__login")
    }
}
