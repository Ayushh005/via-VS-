package com.example.notes

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao : WishDao) {

    suspend fun addAWish(wish: Wish){
        wishDao.addWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()    // write it as both ways

    fun getAWishById(id:Long) : Flow<Wish> {
        return wishDao.getWishById(id)
    }

    suspend fun updateAWish(wish: Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteWish(wish)
    }
}