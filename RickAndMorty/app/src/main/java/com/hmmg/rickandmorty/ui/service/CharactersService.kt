package com.hmmg.rickandmorty.ui.service


import retrofit2.http.GET
import com.hmmg.rickandmorty.ui.model.CharacterListModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


interface CharacterService {
    @GET("character")
    suspend fun fetchCharacters(): Response<CharacterListModel>
}


@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun

}

