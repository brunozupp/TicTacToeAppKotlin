package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.board

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.novelitech.tictactoeappkotlin.models.Position
import com.novelitech.tictactoeappkotlin.ui.components.BoxSymbol

@Composable
fun Board(
    modifier: Modifier = Modifier,
    onTap: (Position) -> Unit,
) {

    Column(
        modifier = modifier,
    ) {
        Row {
            for(i in 0..2) {
                BoxSymbol(
                    modifier = Modifier.weight(1f),
                    position = Position(0, i),
                    onTap = onTap,
                    allowBorderTop = false,
                    allowBorderLeft = i != 0,
                    allowBorderRight = i != 2,
                )
            }
        }
        Row {
            for(i in 0..2) {
                BoxSymbol(
                    modifier = Modifier.weight(1f),
                    position = Position(1, i),
                    onTap = onTap,
                    allowBorderLeft = i != 0,
                    allowBorderRight = i != 2,
                )
            }
        }
        Row {
            for(i in 0..2) {
                BoxSymbol(
                    modifier = Modifier.weight(1f),
                    position = Position(2, i),
                    onTap = onTap,
                    allowBorderBottom = false,
                    allowBorderLeft = i != 0,
                    allowBorderRight = i != 2,
                )
            }
        }
    }
}