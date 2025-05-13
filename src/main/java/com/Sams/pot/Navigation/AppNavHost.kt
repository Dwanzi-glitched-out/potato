package com.Sams.pot.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Sams.pot.ui.screens.Dash
import com.Sams.pot.ui.screens.HomeScreen
import com.Sams.pot.ui.screens.LoginScreen
import com.Sams.pot.ui.screens.RegisterScreen
import com.Sams.pot.ui.screens.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String=Splash
) {
    NavHost(navController = navController, startDestination = startDestination){
        composable (Dashboard){ Dash(navController) }
        composable(Splash) { SplashScreen{navController.navigate(Home){
            popUpTo(Splash){inclusive=true}
        } } }
        composable (Register){ RegisterScreen(navController) }
        composable (Login){ LoginScreen(navController) }
        composable (Home){ HomeScreen(navController) }

    }
}