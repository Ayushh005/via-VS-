package com.example.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mywishlistapp.R


@Composable
fun HomeView(){

    Scaffold(
        topBar = {AppBarView(title = "Notes")},
        scaffoldState = rememberScaffoldState(),
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = { /*TODO*/ })
            {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }


    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it))
        {
            items(DummyWish.wishList){
           //     wish -> WishItem(wish = wish)
            }
        }
    }
}


fun WishItem(wish: Wish, onClick: () -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 4.dp, start = 4.dp, end = 4.dp)
        .clickable { onClick },
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.white))
        {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(wish.title, fontWeight = FontWeight.ExtraBold)
                Text(wish.description)
            }
        }
}
