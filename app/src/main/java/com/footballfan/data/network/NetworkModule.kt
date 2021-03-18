package com.footballfan.data.network

import com.footballfan.data.network.football.FootballApi
import com.footballfan.data.network.news.NewsApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NewsnetworkModule {
    //TODO fix typo NetworkModule
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            // .baseUrl(BuildConfig.BASE_URL)
                //https://v3.football.api-sports.io/
            //.baseUrl("https://newsapi.org/")
                .baseUrl("https://v3.football.api-sports.io/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFootballApi(retrofit: Retrofit): FootballApi{
        return retrofit.create(FootballApi::class.java)
    }
}