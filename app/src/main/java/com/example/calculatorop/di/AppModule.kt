package com.example.calculatorop.di

import androidx.compose.ui.input.key.Key.Companion.Calculator
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.calculatorop.history.HistoryDatabase
import com.example.calculatorop.history.HistoryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = HistoryDatabase::class.java,
            name = "history.db"
        ).build().dao
    }
    viewModel {
        HistoryViewModel(get())
    }




}