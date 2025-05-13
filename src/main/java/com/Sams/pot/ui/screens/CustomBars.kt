package com.Sams.pot.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.Sams.pot.Navigation.Dashboard
import com.Sams.pot.Navigation.Home

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  TopBar(title: String){
    CenterAlignedTopAppBar(
        title = {Text(title, fontFamily = FontFamily.Cursive, fontSize = 40.sp)},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.Black
        )
    )
}
//data class to represent each nav item
data class BottomNavItem(
    val route:String,
    val label: String,
    val icon: ImageVector
)
@Composable
fun BottomNav(navController: NavController){
    val items=listOf(
        BottomNavItem(Home,"Home",Icons.Default.Home),
        BottomNavItem(Dashboard,"Dashboard",Icons.Default.AccountBox)
    )
    NavigationBar (
        contentColor=Color.Blue,
        containerColor = Red,
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute=navBackStackEntry?.destination?.route
        items.forEach {
                item ->

            NavigationBarItem(
                icon = {Icon(item.icon, contentDescription = item.label)},
                label ={Text(item.label)},
                selected = currentRoute==item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route)
                        {
                            popUpTo(item.route)
                            { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}
