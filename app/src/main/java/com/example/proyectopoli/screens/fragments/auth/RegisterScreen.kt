package com.example.proyectopoli.screens.fragments.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectopoli.R

@Composable
fun RegisterScreen(navController: NavHostController) {
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var pais by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var aceptaTerminos by remember { mutableStateOf(false) }
    var aceptaPrivacidad by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // LOGO
        Image(
            painter = painterResource(id = R.drawable.logo_purestyle),
            contentDescription = "Logo de PureStyle",
            modifier = Modifier
                .height(120.dp)
                .width(120.dp),
            contentScale = ContentScale.Fit
        )

        // Título
        Text(
            text = "Registro",
            style = MaterialTheme.typography.headlineSmall
        )

        // Campos
        OutlinedTextField(
            value = nombres,
            onValueChange = { nombres = it },
            label = { Text("Nombres") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apellidos,
            onValueChange = { apellidos = it },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        OutlinedTextField(
            value = pais,
            onValueChange = { pais = it },
            label = { Text("País") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = sexo,
            onValueChange = { sexo = it },
            label = { Text("Sexo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.weight(1f),
                visualTransformation = PasswordVisualTransformation()
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirmar") },
                modifier = Modifier.weight(1f),
                visualTransformation = PasswordVisualTransformation()
            )
        }


        // Checkboxes y botón confirmación
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = aceptaTerminos,
                        onCheckedChange = { aceptaTerminos = it },
                        colors = CheckboxDefaults.colors(checkedColor = Color(0xFF9575CD))
                    )
                    Text("Acepto términos y condiciones.")
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = aceptaPrivacidad,
                        onCheckedChange = { aceptaPrivacidad = it },
                        colors = CheckboxDefaults.colors(checkedColor = Color(0xFF9575CD))
                    )
                    Text("Acepto políticas de privacidad.")
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Botón confirmar
            Button(
                onClick = {
                    navController.navigate("login")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9575CD)),
                modifier = Modifier
                    .height(43.dp)
            ) {
                Text("Confirmar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(navController = rememberNavController())
}
