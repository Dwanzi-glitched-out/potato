package com.Sams.pot.ui.screens.teachers

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Sams.pot.Navigation.ROUTE_VIEW_ATTACHMENT
import com.Sams.pot.Navigation.ROUTE_VIEW_STUDENTS
import com.Sams.pot.R
import com.Sams.pot.ui.screens.BottomNav
import com.Sams.pot.ui.screens.TopBar


@Composable
fun Dash(navController: NavController){
    Scaffold(
        topBar = { TopBar("DASHBOARD") },
        bottomBar = { BottomNav(navController) }
    ){innerpadding->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
        ) {
            Image(
                painter = painterResource(R.drawable.img_2),
                contentDescription = "Background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(innerpadding)
                    .size(700.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    item {
                        dashcard(
                            title = "STUDENTS",
                            description = "View enrolled students",
                            icon = Icons.Default.Face,
                            backgroundcolor = (Color.Black),
                            onClick = {navController.navigate(ROUTE_VIEW_STUDENTS)}
                        )
                    }
                    item {
                        dashcard(
                            title = "ATTACHMENTS",
                            description = "View sent attachments",
                            icon = Icons.Default.Face,
                            backgroundcolor = (Color.Black),
                            onClick = {navController.navigate(ROUTE_VIEW_ATTACHMENT)}
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun dashcard(
    title:String,
    description:String,
    icon: ImageVector,
    backgroundcolor: Color,
    onClick:()->Unit
){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, color = Color.Black)
            .clickable{onClick()}
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundcolor),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        Column (
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )
            Text(text = title, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = Color.White,
                fontSize=15.sp)
            Text(text = description,color = Color.White,fontSize=15.sp)
        }
    }
}