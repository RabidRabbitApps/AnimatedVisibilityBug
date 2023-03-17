package com.sample.bugexample.android

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sample.bugexample.ui.screens.SampleScreen
import com.sample.bugexample.ui.theme.BugTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        window.apply {
            setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
            setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BugTheme {
                val systemUiController = rememberSystemUiController()
                val darkIcons = !isSystemInDarkTheme()

                SideEffect {
                    systemUiController.setStatusBarColor(color = Color.Transparent, darkIcons = darkIcons)
                }

                SampleScreen()
            }
        }
    }
}
