package com.sample.bugexample.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.bugexample.ui.theme.BugTheme

@Composable
fun SampleScreen() {
    val scrollState = rememberScrollState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
            Text(
                text = "Min-Height Bug Sample",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineLarge,
            )

            Spacer(
                modifier = Modifier.fillMaxWidth().sizeIn(minHeight = 10.dp).weight(1f).background(color = MaterialTheme.colorScheme.error),
            )

            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Everything is this area should be at the center of the screen", modifier = Modifier.padding(bottom = 16.dp))

                Text(
                    text = "The red boxes above and below this area should reduce their size when the keyboard is open",
                    modifier = Modifier.padding(bottom = 16.dp),
                )

                Text(text = "The red boxes should not however, be smaller than 10 dp", modifier = Modifier.padding(bottom = 16.dp))

                Text(
                    text = "Here is a text field that you can use to open the keyboard",
                    modifier = Modifier.padding(bottom = 4.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge,
                )

                OutlinedTextField(value = "", onValueChange = {})
            }

            Spacer(
                modifier = Modifier.fillMaxWidth().sizeIn(minHeight = 10.dp).weight(1f).background(color = MaterialTheme.colorScheme.error),
            )

            Text(text = "This is the bottom of the screen", modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Preview(name = "Light Theme")
@Preview(name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PlanFinancialsScreenPreview() {
    BugTheme {
        SampleScreen()
    }
}
