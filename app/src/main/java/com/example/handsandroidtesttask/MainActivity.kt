package com.example.handsandroidtesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.handsandroidtesttask.ui.theme.HandsAndroidTestTaskTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandsAndroidTestTaskTheme {
                val backgroundBrush = Brush.verticalGradient(
                    listOf(Color(0xFF310050), Color(0xFF000000))
                )
                Scaffold(
                    modifier = Modifier
                        .background(backgroundBrush)
                        .fillMaxSize(),
                    containerColor = Color.Transparent,
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors().copy(
                                containerColor = Color.Transparent
                            ),
                            title = { 
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Клеточное наполнение",
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.headlineSmall
                                )
                            }
                        )
                    }
                ) { innerPadding ->
                    val vm: CellsScreenViewModel = viewModel()
                    CellsScreen(
                        modifier = Modifier.padding(innerPadding),
                        items = vm.cells.collectAsStateWithLifecycle().value,
                        onCreateClick = { vm.addSell() }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
}
