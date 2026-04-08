package com.serge.medlife.di

import android.content.Context
import com.serge.medlife.repository.CartRepository
import com.serge.medlife.roomdb.CartDB
import com.serge.medlife.roomdb.CartDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app: Context): CartDB {
        return CartDB.getDatabase(app)
    }

    @Provides
    fun provideCartDao(db: CartDB) = db.cartDao()

    @Provides
    fun provideRepository(dao: CartDao) = CartRepository(dao)
}