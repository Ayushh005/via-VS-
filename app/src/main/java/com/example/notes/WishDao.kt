package com.example.notes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    @Query("Select * from `wish-table`")
    abstract suspend fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id = id")
    abstract suspend fun getWishById(id: Long): Flow<Wish>
}