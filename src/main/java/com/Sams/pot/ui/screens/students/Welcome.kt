package com.Sams.pot.ui.screens.students

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Sams.pot.Navigation.Home
import com.Sams.pot.Navigation.Login
import com.Sams.pot.Navigation.ROUTE_ADD_ATTACHMENT
import com.Sams.pot.R
import com.Sams.pot.ui.screens.BottomNav
import com.Sams.pot.ui.screens.TopBar


@Composable
fun StudHome(navController: NavController) {
    Scaffold(
        topBar = { TopBar("WELCOME ") },
        bottomBar = {BottomNav(navController)}
    )
    { innerpadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),  // First Image
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(400.dp)
                )
                Text(
                    text = "__SEND YOUR REPORTS BELOW__",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily.Cursive
                )
                Button(
                    onClick = { navController.navigate(ROUTE_ADD_ATTACHMENT) },
                    modifier = Modifier
                        .padding(10.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        "REPORT",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
