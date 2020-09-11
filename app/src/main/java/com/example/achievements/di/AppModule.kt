package com.example.achievements.di

import android.content.Context
import androidx.room.Room
import com.example.achievements.data_source.network.ApiService
import com.example.achievements.data_source.room.AchievementsDao
import com.example.achievements.data_source.room.AchievementsDatabase
import com.example.achievements.data_source.repository.AchievementsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext appContext: Context) = appContext

    @Provides
    @Singleton
    fun provideAchievementsDB(appContext: Context): AchievementsDatabase {
        return Room.databaseBuilder(
            appContext,
            AchievementsDatabase::class.java,
            AchievementsDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAchievementsDao(achievementsDatabase: AchievementsDatabase): AchievementsDao {
        return achievementsDatabase.achievementsDao()
    }

    @Singleton
    @Provides
    fun provideGson() : Gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

//    @Singleton
//    @Provides
//    fun provideInterceptor(@ApplicationContext context: Context): OkHttpClient.Builder {
//        val logging = HttpLoggingInterceptor()
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//        return    OkHttpClient.Builder()
//            .addInterceptor(NetworkConnectionInterceptor(context))
//    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gson: Gson,
        //oktHttpClient: OkHttpClient.Builder
    ) : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(NetworkConstants.BaseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(oktHttpClient.build())

    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit.Builder) : ApiService {
        return retrofit.build().create(ApiService::class.java)
    }



    @Provides
    @Singleton
    fun provideAchievementRepository(dao: AchievementsDao, api: ApiService) = AchievementsRepository(
        dao,   // data access object
        api    //retrofit api
    )

}