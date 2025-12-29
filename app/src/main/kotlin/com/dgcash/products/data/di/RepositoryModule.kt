package com.dgcash.products.data.di

import com.dgcash.products.data.repository.ProductRepositoryImpl
import com.dgcash.products.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun provideProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository

}