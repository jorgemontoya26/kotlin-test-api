package com.minisocial.minisocialapi.controller.auth

data class AuthenticationResponse (
    val accessToken: String,
    val refreshToken: String
)
