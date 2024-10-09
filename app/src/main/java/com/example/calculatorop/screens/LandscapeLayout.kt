package com.example.calculatorop.screens

import android.R.attr.text
import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.InterceptPlatformTextInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.AppBar
import com.example.calculatorop.components.CuteButton
import com.example.calculatorop.components.CuteIconButton
import com.example.calculatorop.history.HistoryEvents
import com.example.calculatorop.history.HistoryState
import com.example.calculatorop.history.HistoryViewModel
import com.example.calculatorop.logic.CalcAction
import com.example.calculatorop.logic.CalculatorViewModel
import com.example.calculatorop.logic.Evaluator
import com.example.calculatorop.logic.navigation.Screens
import com.example.calculatorop.logic.rememberDecimal
import com.example.calculatorop.logic.rememberUseHistory
import com.example.calculatorop.ui.theme.GlobalFont
import kotlinx.coroutines.awaitCancellation




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LandscapeLayout(
    viewModel: CalculatorViewModel,
    historyViewModel: HistoryViewModel,
    historyState: HistoryState
) {

    val saveToHistory = rememberUseHistory().value
    val scrollState = rememberScrollState()

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(15.dp)
        ) {
            LaunchedEffect(viewModel.displayText) {
                scrollState.animateScrollTo(scrollState.maxValue)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align((Alignment.BottomCenter))
                    .navigationBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .align(Alignment.End)
                ) {
                    Text(
                        text = viewModel.displayText.text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        fontSize = 35.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = GlobalFont
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CuteButton(
                        text = "",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {}
                    )
                    CuteButton(
                        text = "9",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("9"))
                        }
                    )
                    CuteButton(
                        text = "8",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("8"))
                        }
                    )
                    CuteButton(
                        text = "7",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("7"))
                        }
                    )
                    CuteButton(
                        text = "×",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.outlineVariant),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("×"))
                        }
                    )
                    CuteButton(
                        text = viewModel.parenthesis,
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.outlineVariant),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField(viewModel.parenthesis))
                        }
                    )
                    CuteButton(
                        text = "C",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.ResetField)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CuteButton(
                        text = "3",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("3"))
                        }
                    )
                    CuteButton(
                        text = "4",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("4"))
                        }
                    )
                    CuteButton(
                        text = "5",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("5"))
                        }
                    )
                    CuteButton(
                        text = "6",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("6"))
                        }
                    )
                    CuteButton(
                        text = "+",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.outlineVariant),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("+"))
                        }
                    )
                    CuteButton(
                        text = "^",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.outlineVariant),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("^"))
                        }
                    )
                    CuteButton(
                        text = "⌫",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.RemoveLast)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    CuteButton(
                        text = "2",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("2"))
                        }
                    )
                    CuteButton(
                        text = "1",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("1"))
                        }
                    )
                    CuteButton(
                        text = "0",
                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("0"))
                        }
                    )
                    CuteButton(
                        text = ".",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("."))
                        }
                    )
                    CuteButton(
                        text = "-",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.outlineVariant),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("-"))
                        }
                    )
                    CuteButton(
                        text = "/",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.outlineVariant),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            viewModel.handleAction(CalcAction.AddToField("/"))
                        }
                    )
                    CuteButton(
                        text = "=",
                        color = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.outlineVariant),

                        modifier = Modifier
                            .weight(0.15f),
                        onClick = {
                            if (saveToHistory) {
                                historyState.operation.value =
                                    viewModel.displayText.text
                                historyState.result.value =
                                    Evaluator.eval(viewModel.displayText.text)

                                historyViewModel.onEvent(
                                    HistoryEvents.AddCalculation(
                                        operation = historyState.operation.value,
                                        result = historyState.result.value
                                    )
                                )
                            }
                            viewModel.handleAction(CalcAction.GetResult)
                        }
                    )
                }
            }
        }
    }
}