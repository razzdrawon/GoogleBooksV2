package com.razzdrawon.googlebookskotlin.services

import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    companion object {
        val BASE_URL = "https://www.googleapis.com/books/v1/"
    }

    @Provides
    fun providesGson(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesRxJava(): CallAdapter.Factory {
        return RxJavaCallAdapterFactory.create()
    }

    @Provides
    fun providesRetrofit(rxJava: CallAdapter.Factory, gsonConverter: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(rxJava)
            .addConverterFactory(gsonConverter)
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun providesService(retrofit: Retrofit): GoogleBooksService {
        return retrofit.create(GoogleBooksService::class.java)
    }

}
