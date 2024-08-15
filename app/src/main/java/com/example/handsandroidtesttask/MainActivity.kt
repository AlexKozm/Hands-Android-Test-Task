package com.example.handsandroidtesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.handsandroidtesttask.cellScreen.CellsScreen
import com.example.handsandroidtesttask.cellScreen.CellsScreenViewModel
import com.example.handsandroidtesttask.ui.theme.HandsAndroidTestTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandsAndroidTestTaskTheme {
                AppScaffold(
                    topAppBarText = stringResource(R.string.cells_screen_top_app_bar)
                ) { innerPadding ->
                    val vm: CellsScreenViewModel = viewModel()
                    CellsScreen(
                        modifier = Modifier.padding(innerPadding),
                        items = vm.cells.collectAsStateWithLifecycle().value,
                        onCreateClick = { vm.addRandomSell() }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    topAppBarText: String,
    content: @Composable (PaddingValues) -> Unit
) {
    val backgroundBrush = Brush.verticalGradient(
        listOf(Color(0xFF310050), Color(0xFF000000))
    )
    Scaffold(
        modifier = modifier
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
                        text = topAppBarText,
                        textAlign = TextAlign.Center,
                    )
                }
            )
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}

@Preview
@Composable
private fun Preview() {
    HandsAndroidTestTaskTheme {
        AppScaffold(
            topAppBarText = stringResource(R.string.cells_screen_top_app_bar)
        ) {

        }
    }
}
