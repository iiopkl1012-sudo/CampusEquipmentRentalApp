package com.example.campusequipmentrentalapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.campusequipmentrentalapp.model.UserRole

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: String,
    val name: String,
    val department: String,
    val role: UserRole
)
