package com.example.proyectopoli.screens.fragments.content

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R

@Composable
fun BotonesFragment() {
    var backgroundColor by remember { mutableStateOf(Color(0xFFF7EDF8)) }
    var textColor by remember { mutableStateOf(Color.Black) }
    var showProducts by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Usa Nuestros Botones interactivos",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = textColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botones
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedButton(onClick = {
                // Mostrar saludo
                Toast.makeText(context, "¡Hola desde PureStyle!", Toast.LENGTH_SHORT).show()
            }) {
                Text("Saluda", color = textColor)
            }

            Button(onClick = {
                // Invertir colores
                backgroundColor = if (backgroundColor == Color(0xFFF7EDF8)) Color(0xFF3E4A6C) else Color(0xFFF7EDF8)
                textColor = if (textColor == Color.Black) Color.White else Color.Black
            }) {
                Text("Invierte Color")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showProducts = !showProducts }) {
            Text("Listar 3 productos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (showProducts) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Producto 1", "Producto 2", "Producto 3").forEach { product ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFFE8D9FA),
                                modifier = Modifier.size(32.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "A",
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF6A4FA3)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(product, color = textColor)
                        }
                        Icon(imageVector = Icons.Default.CheckBox, contentDescription = null, tint = Color(0xFF6A4FA3))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Ingresa y Síguenos en nuestras redes sociales",
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = textColor
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Redes sociales
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf(
                Triple(R.drawable.instagram, "https://www.instagram.com/", "Instagram"),
                Triple(R.drawable.youtube, "https://www.youtube.com/", "YouTube")
            ).forEach { (icon, url, desc) ->
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = desc,
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf(
                Triple(R.drawable.facebook, "https://www.facebook.com/", "Facebook"),
                Triple(R.drawable.twitter, "https://twitter.com/", "Twitter")
            ).forEach { (icon, url, desc) ->
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = desc,
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        }
                )
            }
        }
    }
}
