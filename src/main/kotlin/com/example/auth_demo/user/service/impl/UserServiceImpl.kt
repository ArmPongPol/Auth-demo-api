package com.example.auth_demo.user.service.impl

import com.example.auth_demo.user.dto.LoginResponse
import com.example.auth_demo.user.repository.UserRepository
import com.example.auth_demo.user.request.LoginRequest
import com.example.auth_demo.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
  private val userRepository: UserRepository,
) : UserService, UserDetailsService {
  override fun loadUserByUsername(email: String): UserDetails {
    val user = userRepository.findByEmail(email).orElseThrow {
      throw Exception("User not found")
    }

    return User(user.email, user.password, emptyList())
  }

  override fun login(request: LoginRequest): LoginResponse {
    val user = userRepository.findByEmail(request.email).orElseThrow {
      throw Exception("User not found")
    }

    if (request.password == user.password) {
      return LoginResponse(
        username = user.email,
        token = "Login successful"
      )
    } else {
      throw Exception("Invalid credentials")
    }
  }
}