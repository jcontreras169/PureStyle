package com.example.proyectopoli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectopoli.screens.fragments.auth.LoginScreen
import com.example.proyectopoli.screens.fragments.auth.RegisterScreen
import com.example.proyectopoli.screens.HomeScreen
import com.example.proyectopoli.screens.MenuHomeScreen
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.proyectopoli.ui.theme.ProyectoPOLITheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoPOLITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    // ✅ Asegúrate de tener estos imports arriba
                    // import androidx.compose.runtime.*
                    var selectedOption by remember { mutableStateOf("perfil") }

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("register") {
                            RegisterScreen(navController)
                        }
                        composable("menuhome") {
                            MenuHomeScreen(
                                navController = navController,
                                selectedOption = selectedOption,
                                onOptionSelected = { selectedOption = it }
                            )
                        }
                    }
                }
            }
        }
    }
}