package com.sample.bugexample.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.sample.bugexample.ui.theme.BugTheme

@Composable
fun SampleScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth(),
            // .background(color = Color.Red) // Uncommenting this line causes the ConstraintLayout to fill the screen's height
        ) {
            val textRef = createRef()

            Text(
                text = "This text is centered inside of a ConstraintLayout",
                modifier = Modifier.constrainAs(textRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }.background(color = Color.White),
            )
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
