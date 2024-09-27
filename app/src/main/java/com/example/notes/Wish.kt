package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-description")
    val description: String = ""
)

object  DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 2", description = "An android Watch"),
        Wish(title = "iphone 15 pro max", description = "An ios platform"),
        Wish(title = "Atomic Habbit", description = "An exited Book")
    )
}
