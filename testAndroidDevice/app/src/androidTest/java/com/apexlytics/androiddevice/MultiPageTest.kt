package com.apexlytics.androiddevice

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MultiPageTest : BaseTest() {

    @Before
    fun setUp() = launchApp()

    @Test
    fun multiPage_fullFlow_aiPlayground() {
        // Page 1 — Login screen (before submitting)
        captureScreen("multi_page__1_login")

        login()

        // Page 2 — Flow Selector
        captureScreen("multi_page__2_flow_selector")

        navigateToFullFlow()

        // Page 3 — Dashboard (top, AI Playground card visible)
        captureScreen("multi_page__3_dashboard")

        navigateToAiPlayground()

        // Page 4 — AI Playground top (Strict Match + Layout Match sections)
        captureScreen("multi_page__4_ai_playground_top")

        // Scroll to Dynamic Match + Floating Region sections
        scrollDown(3)

        // Page 5 — AI Playground middle (dynamic timestamp, floating element)
        captureScreen("multi_page__5_ai_playground_dynamic")

        // Scroll to Exact Match + Scroll Test Cards
        scrollDown(4)

        // Page 6 — AI Playground end (Scroll Test Cards + end of page)
        scrollDown(8)
        captureScreen("multi_page__6_ai_playground_end")
    }
}
