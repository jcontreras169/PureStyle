package com.example.proyectopoli.screens

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectopoli.R

@Composable
fun HomeScreen(navController: NavHostController) {
    val scrollState = rememberScrollState() // Para permitir el desplazamiento en pantallas pequeñas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // LOGO
        Image(
            painter = painterResource(id = R.drawable.logo_purestyle), // Asegúrate de tener el logo en drawable
            contentDescription = "Logo de PureStyle",
            modifier = Modifier
                .padding(top = 32.dp)
                .height(150.dp)
                .fillMaxWidth()
        )

        // Título de bienvenida
        Text(
            text = "Bienvenido a PureStyle",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Texto divertido relacionado con la app
        Text(
            text = "¡Tu estilo a un clic de distancia!",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )

        // Espaciado
        Spacer(modifier = Modifier.height(32.dp))

        // Botón para ir al perfil
        Button(
            onClick = { navController.navigate("login") }, // Navega a la pantalla de perfil
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "Ir Ya !!!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
