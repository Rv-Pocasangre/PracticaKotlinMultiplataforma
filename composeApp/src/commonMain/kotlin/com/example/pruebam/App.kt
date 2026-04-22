package com.example.pruebam

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App() {
    MaterialTheme {
        // Variable de estado: cuando cambia, Compose redibuja la pantalla
        var mostrarMensaje by remember { mutableStateOf(false) }

        // Surface ocupa toda la pantalla con el color de fondo del tema
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),           // margen interno
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center  // centra verticalmente
            ) {

                Text(
                    text = "Mi primera app KMP",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(32.dp)) // espacio entre elementos

                Button(
                    onClick = {
                        // Cada click alterna entre mostrar/ocultar el mensaje
                        mostrarMensaje = !mostrarMensaje
                    },
                    modifier = Modifier.fillMaxWidth(0.7f) // 70% del ancho
                ) {
                    Text(
                        text = if (mostrarMensaje) "Ocultar mensaje" else "Mostrar mensaje",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // AnimatedVisibility: aparece/desaparece con animación
                AnimatedVisibility(
                    visible = mostrarMensaje,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = "¡Hola desde Kotlin Multiplatform! 🎉\nEste mensaje funciona en Android e iOS.",
                            modifier = Modifier.padding(16.dp),
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}