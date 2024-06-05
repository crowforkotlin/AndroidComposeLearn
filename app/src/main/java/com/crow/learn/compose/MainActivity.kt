package com.crow.learn.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crow.learn.compose.ui.initializeSplashScreen
import com.crow.learn.compose.ui.theme.AndroidComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initializeSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeLearnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        AnimatedNavHostDemo()
//                        AnimatedSwitch()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidComposeLearnTheme {
        Greeting("Android")
    }
}

@Composable
fun AnimatedSwitch() {
    var showScreenA by remember { mutableStateOf(true) }

    Crossfade(targetState = showScreenA) {
        if (it) {
            ScreenA(onClick = { showScreenA = false })
        } else {
            ScreenB(onClick = { showScreenA = true })
        }
    }
}

@Composable
fun ScreenA(onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onClick) {
            Text("Go to Screen B")
        }
    }
}

@Composable
fun ScreenB(onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onClick) {
            Text("Go back to Screen A")
        }
    }
}

@Composable
fun AnimatedNavHostDemo() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "ScreenA") {
        composable("ScreenA") { ScreenA(navController) }
        composable("ScreenB") { ScreenB(navController) }
    }
}

@Composable
fun ScreenA(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navController.navigate("ScreenB") }) {
            Text("Go to Screen B")
        }
    }
}

@Composable
fun ScreenB(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navController.navigate("ScreenA") }) {
            Text("Go back to Screen A")
        }
    }
}