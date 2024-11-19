package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.display

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novelitech.tictactoeappkotlin.models.Player

@Composable
fun Display(
    modifier: Modifier = Modifier,
    currentPlayer: Player,
    currentScore: MutableMap<Player, Int>
) {
    Box(
        modifier = modifier
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Current player: ${currentPlayer.name}",
                style = TextStyle(
                    fontSize = 24.sp,
                ),
            )

            Spacer(modifier = Modifier.height(24.dp))

            DisplayTableScore(
                currentScore = currentScore,
            )
        }
    }
}