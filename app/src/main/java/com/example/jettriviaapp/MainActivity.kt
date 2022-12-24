package com.example.jettriviaapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettriviaapp.model.Question
import com.example.jettriviaapp.screens.QuestionsViewModel
import com.example.jettriviaapp.ui.theme.JetTriviaAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTriviaAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TriviaHome()
                }
            }
        }
    }
}


@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()){
    Questions(viewModel)
}

@Composable
fun Questions(viewModel: QuestionsViewModel) {

    val question= viewModel.data.value.data?.toMutableList()

    Log.d("SIZE", "Questions : ${question?.size}")


}
