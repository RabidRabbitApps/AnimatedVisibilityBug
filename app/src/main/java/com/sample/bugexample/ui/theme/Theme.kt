package com.sample.bugexample.ui.theme

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BugTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme(),
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}

@Preview(name = "Light Theme", widthDp = 125, showBackground = true)
@Preview(name = "Dark Theme", widthDp = 125, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun BugThemePreview() {
    BugTheme {
        Surface {
            Column {
                Checkbox(checked = false, onCheckedChange = {})
                Checkbox(checked = true, onCheckedChange = {})

                TextField(value = "Preview", onValueChange = {})
                OutlinedTextField(value = "Preview", onValueChange = {})

                Switch(checked = false, onCheckedChange = {})
                Switch(checked = true, onCheckedChange = {})

                Button(onClick = { }) { Text(text = "Click me!") }
                OutlinedButton(onClick = { }) { Text(text = "Click me!") }
            }
        }
    }
}
