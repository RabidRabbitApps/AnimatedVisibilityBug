package com.sample.bugexample.ui.screens

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.bugexample.ui.theme.BugTheme

@Composable
fun SampleScreen() {
    val scrollState = rememberScrollState()
    var showMessage by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(vertical = 32.dp)) {
            Column(modifier = Modifier.fillMaxWidth().weight(1f).verticalScroll(scrollState)) {
                InputItem(showMessage = showMessage, modifier = Modifier.fillMaxWidth().padding(16.dp))
            }

            Button(onClick = { showMessage = true }, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text(text = "Submit")
            }
        }
    }
}

@Composable
private fun InputItem(showMessage: Boolean, modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf<PaymentOption?>(null) }

    Column(modifier = modifier) {
        Text(
            text = "Payment Amount",
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = "Choose the amount you would like to pay...",
            modifier = Modifier.padding(vertical = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                selectedOption = PaymentOption.Custom
            }.fillMaxWidth().padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            RadioButton(
                selected = selectedOption == PaymentOption.Custom,
                onClick = null
            )

            Text(
                text = "Custom Amount",
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        AnimatedVisibility(visible = selectedOption == PaymentOption.Custom) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surfaceVariant,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.inversePrimary)
            ) {
                Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(
                        text = "How much would you like to pay?",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "The amount must be between $1.00 and your remaining balance",
                        modifier = Modifier.padding(bottom = 16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    TextField(
                        value = "",
                        onValueChange = {}
                    )

                    Text(
                        text = if(showMessage) "You have not entered an amount. Please enter a value of $1.00 or more, and less than your remaining balance and try again" else "",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                selectedOption = PaymentOption.Balance
            }.fillMaxWidth().padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            RadioButton(
                selected = selectedOption == PaymentOption.Balance,
                onClick = null
            )

            Text(
                text = "Remaining Balance of $122.50",
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

private enum class PaymentOption { Custom, Balance }

@Preview(name = "Light Theme")
@Preview(name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PlanFinancialsScreenPreview() {
    BugTheme {
        SampleScreen()
    }
}
