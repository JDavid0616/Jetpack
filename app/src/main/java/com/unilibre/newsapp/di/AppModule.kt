package com.unilibre.newsapp.di

import com.unilibre.newsapp.data.remote.NewsProvider
import com.unilibre.newsapp.data.repository.NewsRepository
import com.unilibre.newsapp.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsProvider(retrofit: Retrofit): NewsProvider {
        return retrofit.create(NewsProvider::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsProvider: NewsProvider): NewsRepository {
        return NewsRepositoryImpl(newsProvider)
    }
}
