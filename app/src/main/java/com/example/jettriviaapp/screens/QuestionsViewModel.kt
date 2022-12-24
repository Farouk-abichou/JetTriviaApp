package com.example.jettriviaapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettriviaapp.data.DataOrException
import com.example.jettriviaapp.model.QuestionItem
import com.example.jettriviaapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository)
    : ViewModel() {
     val data: MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception("")) )

    init {
        getAllQuestion()
    }

    private fun getAllQuestion(){
        viewModelScope.launch {
            data.value.loading=true
            data.value = repository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading =false
            }
        }
    }



}