package com.example.myandroidskills.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myandroidskills.model.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDB(@ApplicationContext  context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "appDatabase")
            .fallbackToDestructiveMigration()
            .createFromAsset("quotes.db")
            .build()
    }
}