package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R

@Composable
fun PerfilFragment() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nombre + letra inicial
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE8DAFF)),
                contentAlignment = Alignment.Center
            ) {
                Text("J", fontWeight = FontWeight.Bold, color = Color(0xFF5E35B1))
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text("JOSE JULIAN CONTRERAS SALCEDO", fontWeight = FontWeight.Bold)
                Text("Josejulian19999@gmail.com", fontSize = 14.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Avatar grande
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color(0xFFE8DAFF))
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Información básica
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Información Básica", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Nombres: Jose Julian")
            Text("Apellidos: Contreras Salcedo")
            Text("Correo: Josejulian19999@gmail.com")
            Text("Teléfono: 3012561715")
            Text("Sexo: Masculino")
            Text("País: Colombia")
            Text("Dirección: Carrera 3B #45-02")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "No olvides revisar y actualizar tu información personal en caso de ser requerido",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botones
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            OutlinedButton(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Editar")
            }

            Button(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9575CD)),
            ) {
                Text("Guardar")
            }
        }
    }
}
