package com.example.pruebam

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform