package com.example.campusequipmentrentalapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EquipmentDao {

    /** 기자재 추가 */
    @Insert
    suspend fun insertEquipment(equipmentEntity: EquipmentEntity): Long

    /** 모든 기자재 조회 */
    @Query("SELECT * FROM equipments ORDER BY id DESC")
    suspend fun getEquipmentsAll(): List<EquipmentEntity>

    /** 기자재 번호로 기자재 조회 */
    @Query("SELECT * FROM equipments WHERE id = :id LIMIT 1")
    suspend fun getEquipmentId(id: Int): EquipmentEntity?
}
