package com.example.proyectopoli.screens.fragments.content.menu

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.proyectopoli.R

@Composable
fun VideosFragment() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo de la tienda
        Image(
            painter = painterResource(id = R.drawable.logo_purestyle),
            contentDescription = "Logo PureStyle",
            modifier = Modifier
                .height(100.dp)
                .padding(bottom = 16.dp)
        )

        // Título principal
        Text(
            text = "Descubre tu estilo",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Video promocional
        AndroidView(
            factory = {
                VideoView(it).apply {
                    val uri = Uri.parse("android.resource://${context.packageName}/raw/promo")
                    setVideoURI(uri)
                    setMediaController(MediaController(it))
                    start()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
        )

        // Frase promocional
        Text(
            text = "Moda que se adapta a ti. ¡Exprésate con PureStyle!",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Línea divisora
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        )

        // Descripción adicional
        Text(
            text = "En PureStyle creemos que la moda debe expresar quién eres. " +
                    "Nuestra colección está pensada para adaptarse a tu estilo único, " +
                    "con prendas cómodas, modernas y llenas de actitud.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(horizontal = 8.dp),
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón atractivo (sin acción aún)
        Button(
            onClick = { /* Acción futura, como navegar al catálogo */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Explorar Colección")
        }
    }
}