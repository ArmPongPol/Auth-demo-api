package com.example.auth_demo.user.controller

import com.example.auth_demo.user.request.LoginRequest
import com.example.auth_demo.user.service.UserService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController @Autowired constructor(
  private val userService: UserService
) {
  val logger: Logger = LoggerFactory.getLogger(UserController::class.java)

  @PostMapping("/login")
  fun signIn(
    @Valid @RequestBody request: LoginRequest
  ): ResponseEntity<Any> {
    logger.info("Login request: $request")
    return ResponseEntity.ok(userService.login(request))
  }
}