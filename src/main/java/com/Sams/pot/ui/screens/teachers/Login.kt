package com.Sams.pot.ui.screens.teachers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.Sams.pot.Navigation.Dashboard
import com.Sams.pot.Navigation.Register
import com.Sams.pot.R
import com.Sams.pot.data.AuthViewModel

@Composable
fun LoginScreen(navController: NavController){
    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Black), // Black background
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WELCOME BACK TO E-TECH",
            fontSize = 35.sp,
            color = Color.White, // White text
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Login!!",
            fontSize = 40.sp,
            color = Color.White, // White title
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )

        Text(
            text = "WELCOME BACK",
            color = Color.White, // White subtitle
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(R.drawable.img_2),
            contentDescription = "logo",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .height(200.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { newEmail -> email = newEmail },
            label = { Text(text = "Enter Email", color = Color.White) },
            placeholder = { Text(text = "Please enter your email", color = Color.LightGray) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { newPassword -> password = newPassword },
            label = { Text(text = "Enter Password", color = Color.White) },
            placeholder = { Text(text = "Please enter password", color = Color.LightGray) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null, tint = Color.White)
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                authViewModel.login(
                    email,
                    password,
                    expectedRole = "teacher",
                    navController,
                    onSuccessDestination = Dashboard,
                    context
                )
            },
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Login", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}
