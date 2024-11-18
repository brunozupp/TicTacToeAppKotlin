package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.board

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.novelitech.tictactoeappkotlin.models.Player
import com.novelitech.tictactoeappkotlin.models.Position
import com.novelitech.tictactoeappkotlin.ui.components.BoxSymbol

@Composable
fun Board(
    modifier: Modifier = Modifier,
    boardProgress: List<List<Player?>>,
    onTap: (Position) -> Unit,
) {

    fun getSymbolFromPlayer(player: Player?) : Char? {

        println("The player is $player")

        if(player == null) return null

        println("Here ${player.name[0]}")
        return player.name[0]
    }

    Column(
        modifier = modifier,
    ) {
        Row {
            for(i in 0..2) {
                BoxSymbol(
                    modifier = Modifier.weight(1f),
                    symbol = getSymbolFromPlayer(boardProgress[0][i]),
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
                    symbol = getSymbolFromPlayer(boardProgress[1][i]),
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
                    symbol = getSymbolFromPlayer(boardProgress[2][i]),
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