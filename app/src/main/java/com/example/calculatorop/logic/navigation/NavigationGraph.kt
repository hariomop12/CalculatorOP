package com.example.calculatorop.logic.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculatorop.history.HistoryViewModel
import com.example.calculatorop.logic.CalculatorViewModel
import com.example.calculatorop.screens.CalculatorUI
import com.example.calculatorop.screens.HistoryScreen
import com.example.calculatorop.screens.SettingsScreen
import org.koin.androidx.compose.koinViewModel


@Composable
fun Nav() {
    val navController = rememberNavController()
    val historyViewModal = koinViewModel<HistoryViewModel>()
    val historyState by historyViewModal.state.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screens.Main
    ) {
        composable<Screens.Main> {
            val viewModel = viewModel<CalculatorViewModel>()
            CalculatorUI(
                viewModel = viewModel,
                historyViewModel = historyViewModal,
                historyState = historyState,
                onNavigateUp = navController::navigateUp,
                onNavigate = { navController.navigate(it) }
            )
        }
        composable<Screens.Settings> {
            SettingsScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = { navController.navigate(it) }
            )
        }
        composable<Screens.History> {
            HistoryScreen(
                state = historyState,
                onEvents = historyViewModal::onEvent,
                onNavigateUp = navController::navigateUp,
                onNavigate = { navController.navigate(it) }
            )
        }
    }
}