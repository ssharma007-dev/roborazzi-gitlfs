package com.apexlytics.robolectric

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apexlytics.robolectric.ui.LoginScreen
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@Config(sdk = [34])
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class SinglePageTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun singlePage_login_screenshot() {
        composeRule.setContent { LoginScreen() }
        composeRule.onRoot().captureRoboImage(
            filePath = "src/test/snapshots/images/single_page__login.png"
        )
    }
}
