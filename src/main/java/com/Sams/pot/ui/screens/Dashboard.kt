package com.Sams.pot.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Sams.pot.Navigation.Brave
import com.Sams.pot.Navigation.Chrome
import com.Sams.pot.Navigation.Edge
import com.Sams.pot.Navigation.Firefox
import com.Sams.pot.Navigation.Google
import com.Sams.pot.Navigation.Opera


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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
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
                            title = "CHROME",
                            description = "Class of 30",
                            icon = Icons.Default.Person,
                            backgroundcolor = (Color.Yellow),
                            onClick = {navController.navigate(Chrome)}
                        )
                    }
                    item {
                        dashcard(
                            title = "FIREFOX",
                            description = "Class of 30",
                            icon = Icons.Default.Person,
                            backgroundcolor = (Color.Red),
                            onClick = {navController.navigate(Firefox)}
                        )
                    }
                    item {
                        dashcard(
                            title = "EDGE",
                            description = "Class of 35",
                            icon = Icons.Default.Person,
                            backgroundcolor = (Color.Blue),
                            onClick = {navController.navigate(Edge)}
                        )
                    }
                    item {
                        dashcard(
                            title = "OPERA",
                            description = "Class of 30",
                            icon = Icons.Default.Person,
                            backgroundcolor = (Color.Magenta),
                            onClick = {navController.navigate(Opera)}
                        )
                    }
                    item {
                        dashcard(
                            title = "GOOGLE",
                            description = "Class of 40",
                            icon = Icons.Default.Person,
                            backgroundcolor = (Color.Transparent),
                            onClick = {navController.navigate(Google)}
                        )
                    }
                    item {
                        dashcard(
                            title = "BRAVE",
                            description = "Class of 30",
                            icon = Icons.Default.Person,
                            backgroundcolor = (Color.Unspecified),
                            onClick = {navController.navigate(Brave)}
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
            Text(text = title, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold, color = Color.Red,
                fontSize=15.sp)
            Text(text = description,color = Color.Black,fontSize=13.sp)
        }
    }
}