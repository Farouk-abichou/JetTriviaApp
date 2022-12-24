package com.example.jettriviaapp.di

import com.example.jettriviaapp.model.Question
import com.example.jettriviaapp.network.QuestionApi
import com.example.jettriviaapp.repository.QuestionRepository
import com.example.jettriviaapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



//Convert to Gson
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi)= QuestionRepository(api)

    @Singleton
    @Provides
    fun provideQuestionApi():QuestionApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }
}