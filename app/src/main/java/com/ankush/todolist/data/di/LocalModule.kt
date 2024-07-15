package com.ankush.todolist.data.di

import android.app.Application
import androidx.room.TypeConverters
import com.ankush.todolist.data.local.AppDao
import com.ankush.todolist.util.Converter
import com.ankush.todolist.util.ListConverter
import com.ankush.todolist.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



/**
 * Providing LocalModule dependency for DI
 */
@Module
@InstallIn(SingletonComponent::class)
@TypeConverters(Converter::class, ListConverter::class)
object LocalModule {

        @Singleton
        @Provides
        fun getAppDB(context: Application): AppDatabase {
            return AppDatabase.getAppDb(context) as AppDatabase
        }

        @Singleton
        @Provides
        fun getDao(appDB: AppDatabase): AppDao {
            return appDB.getDAO()
        }

}
