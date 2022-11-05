package ar.edu.ort.parcialtp3_g5.api

import ar.edu.ort.parcialtp3_g5.interfaces.rickandmortyAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyService {

    companion object {

        fun create( baseURL: String): rickandmortyAPI {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(rickandmortyAPI::class.java)
        }
    }

}