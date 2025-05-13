package com.Sams.pot.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Sams.pot.Navigation.Register
import com.Sams.pot.R



@Composable
fun LoginScreen(navController: NavController){
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Login!!",
            fontSize = 40.sp,
            color = Color.Green,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Black)
                .padding(20.dp)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "logo",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .height(380.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {newEmail->email=newEmail},
            label = { Text(text = "Enter Email") },
            placeholder = { Text(text = "Please enter your email") },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {newPassword -> password = newPassword},
            label = { Text(text = "Enter Password") },
            placeholder = { Text(text = "Please enter password") },
            modifier = Modifier

                .align(Alignment.CenterHorizontally)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {},
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
            Color.Green)
        )
        {
            Text(text = "Login", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "DON'T HAVE AN ACCOUNT??REGISTER NOW",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable{navController.navigate(Register)}
        )
    }
}

