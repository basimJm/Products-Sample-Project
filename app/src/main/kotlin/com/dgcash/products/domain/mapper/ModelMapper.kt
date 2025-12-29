package com.dgcash.products.domain.mapper

interface ModelMapper<Entity> {
    fun toEntity(): Entity
}