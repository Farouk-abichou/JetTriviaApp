package com.example.jettriviaapp.network

import com.example.jettriviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton




//Go to the Question path(think of it like the DAO)
@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions():Question
}