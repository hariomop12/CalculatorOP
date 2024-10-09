package com.example.calculatorop.history

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert
    suspend fun insertCalculation(calculation: Calculation)

    @Delete
    suspend fun deleteCalculation(calculation: Calculation)

    @Delete
    suspend fun deleteAllCalculations(calculations: List<Calculation>)

    @Query("SELECT * FROM calculation")
    fun getAllCalculation(): Flow<List<Calculation>>
}