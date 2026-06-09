package com.apexlytics.robolectric

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apexlytics.robolectric.ui.DashboardScreen
import com.apexlytics.robolectric.ui.LoginScreen
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

// JUnit creates a fresh ComposeTestRule instance per @Test method,
// so each screen needs its own test — this is the standard multi-page pattern.
@RunWith(AndroidJUnit4::class)
@Config(sdk = [34])
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class MultiPageTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun page1_login_screenshot() {
        composeRule.setContent { LoginScreen() }
        composeRule.onRoot().captureRoboImage(
            "src/test/snapshots/images/multi_page__1_login.png"
        )
    }

    @Test
    fun page2_dashboard_screenshot() {
        composeRule.setContent { DashboardScreen() }
        composeRule.onRoot().captureRoboImage(
            "src/test/snapshots/images/multi_page__2_dashboard.png"
        )
    }
}
