package com.example.auth_demo.user.request

import jakarta.validation.constraints.NotBlank

class LoginRequest {
  @NotBlank(message = "Email is required")
  val email: String = ""
  @NotBlank(message = "Password is required")
  val password: String = ""
}