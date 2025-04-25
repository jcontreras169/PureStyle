package com.example.proyectopoli.screens.fragments.content


import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R
import com.example.proyectopoli.viewmodel.UserViewModel

@Composable
fun PerfilFragment(userViewModel: UserViewModel) {
    val context = LocalContext.current
    var isEditing by remember { mutableStateOf(false) }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar grande con opción de cambiar imagen
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color(0xFFE8DAFF))
                .clickable { imagePickerLauncher.launch("image/*") },
            contentAlignment = Alignment.Center
        ) {
            val bitmap = remember(selectedImageUri) {
                selectedImageUri?.let {
                    context.contentResolver.openInputStream(it)?.use { stream ->
                        BitmapFactory.decodeStream(stream)
                    }
                }
            }
            if (bitmap != null) {
                Image(
                    painter = BitmapPainter(bitmap.asImageBitmap()),
                    contentDescription = "Avatar",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Información básica editable
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Información Básica", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            if (isEditing) {
                EditableField("Nombres", userViewModel.name.value) { userViewModel.name.value = it }
                EditableField("Apellidos", userViewModel.lastName.value) { userViewModel.lastName.value = it }
                EditableField("Correo", userViewModel.email.value) { userViewModel.email.value = it }
                EditableField("Teléfono", userViewModel.phone.value) { userViewModel.phone.value = it }
                EditableField("Sexo", userViewModel.gender.value) { userViewModel.gender.value = it }
                EditableField("País", userViewModel.country.value) { userViewModel.country.value = it }
                EditableField("Dirección", userViewModel.address.value) { userViewModel.address.value = it }
            } else {
                Text("Nombres: ${userViewModel.name.value}")
                Text("Apellidos: ${userViewModel.lastName.value}")
                Text("Correo: ${userViewModel.email.value}")
                Text("Teléfono: ${userViewModel.phone.value}")
                Text("Sexo: ${userViewModel.gender.value}")
                Text("País: ${userViewModel.country.value}")
                Text("Dirección: ${userViewModel.address.value}")
            }
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
                onClick = { isEditing = !isEditing },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(if (isEditing) "Cancelar" else "Editar")
            }

            if (isEditing) {
                Button(
                    onClick = { isEditing = false },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9575CD)),
                ) {
                    Text("Guardar")
                }
            }
        }
    }
}

@Composable
fun EditableField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    )
}

