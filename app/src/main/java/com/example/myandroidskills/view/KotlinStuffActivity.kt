package com.example.myandroidskills.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myandroidskills.view.ui.theme.MyAndroidSkillsTheme
import com.example.myandroidskills.viewModel.DefaultViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class KotlinStuffActivity : ComponentActivity() {

    private val viewModel by viewModels<DefaultViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED)
            {
                viewModel.mFlowData.collect {
                    Log.d("mData:", it.toString())
                }
            }

        }

        setContent {
            MyAndroidSkillsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // viewModel.runFlowData()

                    // GetData(viewModel.number.value.toString())
                }
            }
        }
    }
}


@Composable
fun GetData(data: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $data",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyAndroidSkillsTheme {
        GetData("Android")
    }
}