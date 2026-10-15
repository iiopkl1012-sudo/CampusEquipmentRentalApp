package com.example.campusequipmentrentalapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.campusequipmentrentalapp.model.RentalStatus

@Entity(tableName = "equipments")
data class EquipmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val category: String,
    val icon: String,
    val status: RentalStatus,
    val maxRentalDays: Int,
    val location: String,
    val description: String
)
