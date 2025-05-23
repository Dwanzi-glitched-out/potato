package com.Sams.pot.data

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.Sams.pot.Navigation.Dashboard
import com.Sams.pot.Navigation.Login
import com.Sams.pot.Navigation.Loginstudents
import com.Sams.pot.Navigation.ROUTE_ADD_STUDENT
import com.Sams.pot.Navigation.WELCOME
import com.Sams.pot.model.UserModel

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val mAuth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("users")

    // expose loading & error as before
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    /**
     * @param expectedRole The role this login is supposed to have (e.g. "teacher" or "student")
     */
    fun login(
        email: String,
        password: String,
        expectedRole: String,
        navController: NavController,
        onSuccessDestination: String,
        context: Context
    ) {
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Email and password required", Toast.LENGTH_LONG).show()
            return
        }

        _isLoading.value = true

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isLoading.value = false

                if (!task.isSuccessful) {
                    // surface the FirebaseAuth exception message
                    val message = task.exception?.message ?: "Unknown error"
                    _errorMessage.value = message
                    Toast.makeText(context, "Login failed: $message", Toast.LENGTH_LONG).show()
                    return@addOnCompleteListener
                }

                // fetch the user's role from RTDB
                val uid = mAuth.currentUser?.uid ?: return@addOnCompleteListener
                db.child(uid).child("role")
                    .get()
                    .addOnSuccessListener { snapshot ->
                        val role = snapshot.getValue(String::class.java)
                        if (role == expectedRole) {
                            Toast.makeText(context, "Welcome, $role!", Toast.LENGTH_SHORT).show()

                            navController.navigate(onSuccessDestination) {
                                // pop everything off so you can't go back to login
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                }
                            }
                        } else {
                            // wrong role: sign out immediately
                            mAuth.signOut()
                            Toast.makeText(
                                context,
                                "Unauthorized: you are a \"$role\", not a \"$expectedRole\".",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    .addOnFailureListener { dbEx ->
                        // failed to read role: sign out and show the DB exception
                        mAuth.signOut()
                        val dbMsg = dbEx.message ?: "Unknown error"
                        Toast.makeText(
                            context,
                            "Could not verify role: $dbMsg",
                            Toast.LENGTH_LONG
                        ).show()
                    }
            }
    }


    fun register(
        name: String,
        email: String,
        password: String,
        role: String, // "teacher" or "student"
        navController: NavController,
        context: Context
    ) {
        if (email.isBlank() || password.isBlank() || name.isBlank()) {
            Toast.makeText(context, "All fields are required", Toast.LENGTH_LONG).show()
            return
        }

        _isLoading.value = true

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isLoading.value = false

                if (task.isSuccessful) {
                    val uid = mAuth.currentUser?.uid ?: return@addOnCompleteListener
                    val userMap = mapOf(
                        "name" to name,
                        "email" to email,
                        "role" to role
                    )

                    db.child(uid).setValue(userMap)
                        .addOnSuccessListener {
                            Toast.makeText(context, "Registered as $role!", Toast.LENGTH_SHORT)
                                .show()
                            // Navigate to role-based dashboard
                            if (role == "teacher") {
                                navController.navigate(Dashboard)
                            } else {
                                navController.navigate(ROUTE_ADD_STUDENT)
                            }
                        }
                        .addOnFailureListener {
                            Toast.makeText(context, "Failed to save user data", Toast.LENGTH_LONG)
                                .show()
                        }
                } else {
                    _errorMessage.value = task.exception?.message
                    Toast.makeText(
                        context,
                        "Registration failed: PLEASE TRY AGAIN",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
}
