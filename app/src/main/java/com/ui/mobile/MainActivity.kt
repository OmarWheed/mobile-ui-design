package com.ui.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ui.mobile.feature.auth.AuthView
import com.ui.mobile.feature.auth.VerificationView
import com.ui.mobile.feature.onboarding.OnBoardingView
import com.ui.mobile.ui.theme.MobileUiDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MobileUiDesignTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // OnBoardingView(modifier = Modifier.padding(innerPadding))
                    VerificationView( Modifier.padding(innerPadding))
                }
            }
        }
    }
}
