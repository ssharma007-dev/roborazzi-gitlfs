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
    fun singlePage_aiPlayground_screenshot() {
        login()
        navigateToFullFlow()
        navigateToAiPlayground()
        captureScreen("single_page__ai_playground")
    }
}
