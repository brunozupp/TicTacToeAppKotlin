package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.board

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.novelitech.tictactoeappkotlin.models.Player
import com.novelitech.tictactoeappkotlin.models.Position
import com.novelitech.tictactoeappkotlin.ui.components.BoxSymbol

@Composable
fun Board(
    modifier: Modifier = Modifier,
    boardProgress: List<List<Player?>>,
    positionsWinner: List<Position>,
    onTap: (Position) -> Unit,
) {

    fun getSymbolFromPlayer(player: Player?) : Char? {

        println("The player is $player")

        if(player == null) return null

        println("Here ${player.name[0]}")
        return player.name[0]
    }

    fun getBackgroundColor(position: Position) : Color {

        if(positionsWinner.contains(position)) {
            return Color.Green
        }

        return Color.White
    }

    Column(
        modifier = modifier,
    ) {
        Row {
            for(i in 0..2) {

                val position = Position(0, i)

                BoxSymbol(
                    modifier = Modifier.weight(1f),
                    symbol = getSymbolFromPlayer(boardProgress[0][i]),
                    position = position,
                    backgroundColor = getBackgroundColor(position),
                    onTap = onTap,
                    allowBorderTop = false,
                    allowBorderLeft = i != 0,
                    allowBorderRight = i != 2,
                )
            }
        }
        Row {
            for(i in 0..2) {

                val position = Position(1, i)

                BoxSymbol(
                    modifier = Modifier.weight(1f),
                    symbol = getSymbolFromPlayer(boardProgress[1][i]),
                    position = position,
                    backgroundColor = getBackgroundColor(position),
                    onTap = onTap,
                    allowBorderLeft = i != 0,
                    allowBorderRight = i != 2,
                )
            }
        }
        Row {
            for(i in 0..2) {

                val position = Position(2, i)

                BoxSymbol(
                    modifier = Modifier.weight(1f),
                    symbol = getSymbolFromPlayer(boardProgress[2][i]),
                    position = position,
                    backgroundColor = getBackgroundColor(position),
                    onTap = onTap,
                    allowBorderBottom = false,
                    allowBorderLeft = i != 0,
                    allowBorderRight = i != 2,
                )
            }
        }
    }
}