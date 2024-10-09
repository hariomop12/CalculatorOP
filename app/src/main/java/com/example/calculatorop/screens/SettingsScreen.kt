package com.example.calculatorop.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.AppBar
import com.example.calculatorop.components.AboutCard
import com.example.calculatorop.components.History
import com.example.calculatorop.components.Misc
import com.example.calculatorop.components.ThemeManagement
import com.example.calculatorop.logic.navigation.Screens


@Composable
fun SettingsScreen(onNavigateUp: () -> Unit, onNavigate: (Screens) -> Unit) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Settings",
                showBackArrow = true,
                onNavigateUp = onNavigateUp,
                onNavigate = onNavigate
            )
        },
    ) { values ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AboutCard()
            ThemeManagement()
            History()
            Misc()
        }
    }
}