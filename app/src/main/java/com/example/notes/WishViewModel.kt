package com.example.notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository =
): ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")



    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }

    fun OnWIshDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }




    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }




    fun addWish(wish: Wish){
        viewModelScope.launch {
            wishRepository.addAWish(wish)
        }

        fun updateWish(wish: Wish){
            viewModelScope.launch {
                wishRepository.deleteAWish(wish)
            }
        }

        fun deleteWish(wish: Wish){
            viewModelScope.launch {
                wishRepository.deleteAWish(wish)
            }
        }

        fun getWishById(wish: Wish){
            viewModelScope.launch {
                wishRepository.getAWishById(wish)
            }
        }
    }
}