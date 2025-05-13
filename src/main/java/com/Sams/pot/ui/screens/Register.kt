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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Sams.pot.Navigation.Login
import com.Sams.pot.Navigation.Register
import com.Sams.pot.R

@Composable
fun RegisterScreen(navController: NavController){
    var firstname by remember { mutableStateOf(value = "") }
    var lastname by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    val passwordVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Register Here",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            color = Color.Green,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp)

        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "logo",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .size(300.dp)
        )
        OutlinedTextField(
            value = firstname,
            onValueChange = {newFirstName -> firstname = newFirstName},
            label = { Text(text = "Enter first name") }, 
            placeholder = { Text(text = "Please enter first name") },
            modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon")
            }
        )
        OutlinedTextField(
            value = lastname,
            onValueChange = {newLastName->lastname=newLastName},
            label = { Text(text = "Enter Last Name") },
            placeholder = { Text(text = "Please enter last name") },
            modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon")
            }
        )
        OutlinedTextField(
            value = email,
            onValueChange = {newEmail->email=newEmail}, 
            label = { Text(text = "Enter Email") }, placeholder = { Text(text = "Please enter email") },
            modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon")
            }
        )
        OutlinedTextField(
            value = password,
            onValueChange = {newPassword->password=newPassword}, 
            label = { Text(text = "Enter Password") },
            placeholder = { Text(text = "Please enter Password") },
            modifier = Modifier.wrapContentWidth().align(
            Alignment.CenterHorizontally),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon")
                          },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )
        Button(onClick = {navController.navigate(Login)},
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
            Color.Green)
        )
        {
            Text(text = "Register", fontSize = 20.sp)
        }
        Text(text ="ALREADY HAVE AN ACCOUNT?LOGIN HERE",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {navController.navigate(Login) },
            fontSize = 15.sp
        )
    }
}