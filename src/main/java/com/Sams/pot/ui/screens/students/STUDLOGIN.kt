package com.Sams.pot.ui.screens.students

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.Sams.pot.Navigation.WELCOME
import com.Sams.pot.R
import com.Sams.pot.data.AuthViewModel
import com.Sams.pot.data.StudentViewModel

@Composable
fun LoginStudent(navController: NavController) {
    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
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
            color = Color.White,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Welcome, Student",
            color = Color.White,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(R.drawable.img_2),
            contentDescription = "logo",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter Email", color = Color.White) },
            placeholder = { Text("Please enter your email", color = Color.LightGray) },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.White),
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password", color = Color.White) },
            placeholder = { Text("Please enter password", color = Color.LightGray) },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.White),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null, tint = Color.White)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                authViewModel.login(
                    email = email,
                    password = password,
                    expectedRole = "student",
                    navController = navController,
                    onSuccessDestination = WELCOME,
                    context = context
                )
            },
            modifier = Modifier
                .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Login", fontSize = 20.sp)
        }
    }
}
