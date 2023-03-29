package com.example.myandroidskills.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myandroidskills.model.db.dao.product.ProductDAO
import com.example.myandroidskills.model.db.dao.quote.QuoteDAO
import com.example.myandroidskills.model.db.entities.product.Product
import com.example.myandroidskills.model.db.entities.quote.Quote

@Database(entities = [Quote::class,Product::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDAO
    abstract fun getProductDao() : ProductDAO

    /*
       this is the implementation of database initialization without DI
     */

    /*companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(applicationContext: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this)
                {
                    INSTANCE = Room.databaseBuilder(
                        applicationContext,
                        AppDatabase::class.java,
                        "appDatabase"
                    ).createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }*/
}