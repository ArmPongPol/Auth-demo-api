package com.example.auth_demo.user.dto

data class LoginResponse(
  val username: String,
  val token: String,
)
