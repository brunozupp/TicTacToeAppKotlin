package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.display

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.novelitech.tictactoeappkotlin.models.Player

@Composable
fun Display(
    modifier: Modifier = Modifier,
    currentPlayer: Player,
    currentScore: MutableMap<Player, Int>
) {
    Box(modifier = modifier) {
        Column {
            Text(text = "Current player: $currentPlayer.name")
            Text(text = "Score: ${Player.X} = ${currentScore[Player.X]} | ${Player.O} = ${currentScore[Player.O]}")
        }
    }
}