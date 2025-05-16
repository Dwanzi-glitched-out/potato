package com.Sams.pot.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Sams.pot.ui.screens.teachers.Dash
import com.Sams.pot.ui.screens.HomeScreen
import com.Sams.pot.ui.screens.teachers.LoginScreen
import com.Sams.pot.ui.screens.RegisterScreen
import com.Sams.pot.ui.screens.SplashScreen
import com.Sams.pot.ui.screens.students.AddAttachment
import com.Sams.pot.ui.screens.teachers.ViewAttachments
import com.Sams.pot.ui.screens.students.LoginStudent
import com.Sams.pot.ui.screens.students.StudHome
import com.Sams.pot.ui.theme.students.AddstudentScreen
import com.Sams.pot.ui.theme.students.ViewStudents

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
        composable(ROUTE_ADD_STUDENT) { AddstudentScreen(navController) }
        composable(ROUTE_VIEW_STUDENTS){ ViewStudents(navController) }
        composable (ROUTE_ADD_ATTACHMENT){ AddAttachment(navController) }
        composable (ROUTE_VIEW_ATTACHMENT){ ViewAttachments(navController) }
        composable (WELCOME){ StudHome(navController) }
        composable (Loginstudents){ LoginStudent(navController) }
    }
}