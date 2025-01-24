package com.example.auth_demo.user.service

import com.example.auth_demo.user.dto.LoginResponse
import com.example.auth_demo.user.request.LoginRequest

interface UserService {
  fun login(request: LoginRequest): LoginResponse
}