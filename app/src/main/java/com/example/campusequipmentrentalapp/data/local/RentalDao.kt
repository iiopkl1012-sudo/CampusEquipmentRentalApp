package com.example.campusequipmentrentalapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RentalDao {

    /** 대여 신청 저장 **/
    @Insert
    suspend  fun insert(rentalEntity: RentalEntity): Long

    /** 모든 대여 신청 조회
     * */
    @Query("SELECT * FROM rentals ORDER BY id DESC")
    suspend  fun getAll(): List<RentalEntity>


    /** 특정 사용자의 대여 신청 조회 **/
    @Query("SELECT * FROM rentals WHERE userId = :userId ORDER BY id DESC")
    suspend   fun getByUserId(userId: String): List<RentalEntity>

}