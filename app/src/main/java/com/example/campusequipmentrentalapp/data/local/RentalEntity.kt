package com.example.campusequipmentrentalapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 대여 신청 한 건
 * SQLite rental 테이블에 저장 하기
 *
 * */

@Entity(
    tableName =  "rentals"
)
data class RentalEntity (

    /*  primarykey  DB 자동 증가  autoincrement  */
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    /*기자재 번호*/
    val equipmentId: Int,

    /*신청시 사용자 번호 */
    val userId: String,

    /* 대여기간 */
    val rentalDays: Int,

    /* 대여목적 */
    val purpose : String,

    /* 대여 상태 */
    val status : String

    )