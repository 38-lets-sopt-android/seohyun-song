package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.ui.theme.LETSSOPTTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        "홈",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class Contents(
    val title: String,
    val time: String,
    val imageRes: Int
)

@Composable
fun HomeScreen(
    name: String, modifier: Modifier = Modifier
) {
    val viewModel: ContentViewModel = viewModel()
    // 변수 선언

    // 위젯
}