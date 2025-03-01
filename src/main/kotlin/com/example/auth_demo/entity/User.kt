package com.example.auth_demo.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.Date

@Entity
@Table(name = "users")
data class User(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val username: String,
  val password: String,
  val email: String,
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  @CreationTimestamp
  val createdAt: Date = Date(),
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  @UpdateTimestamp
  val updatedAt: Date = Date()
)
