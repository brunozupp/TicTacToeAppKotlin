package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.display

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.novelitech.tictactoeappkotlin.models.Player

@Composable
fun TextPlayerScore(
    modifier: Modifier = Modifier,
    title: String,
    score: Int,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = title)
        Text(
            text = "$score",
            style = TextStyle(
                fontSize = 40.sp,
            ),
        )
    }
}