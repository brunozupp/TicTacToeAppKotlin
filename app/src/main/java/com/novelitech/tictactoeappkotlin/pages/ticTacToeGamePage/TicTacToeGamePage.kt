package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.novelitech.tictactoeappkotlin.core.validations.GameValidation
import com.novelitech.tictactoeappkotlin.models.Player
import com.novelitech.tictactoeappkotlin.models.Position
import com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.board.Board
import com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.display.Display

/**
 * I had some issues with the update of the board using the mutableState in a collection.
 * https://blog.zachklipp.com/two-mutables-dont-make-a-right/
 * https://tigeroakes.com/posts/mutablestateof-list-vs-mutablestatelistof/
 * The links above explain why it happens
 */

@Composable
fun TicTacToeGamePage(modifier: Modifier = Modifier) {

    val board = remember {
        mutableStateListOf(
            mutableStateListOf<Player?>(null,null,null),
            mutableStateListOf<Player?>(null,null,null),
            mutableStateListOf<Player?>(null,null,null),
        )
    }

    var currentPlayer by remember {
        mutableStateOf<Player>(Player.X)
    }

    val currentScore = remember {
        mutableStateMapOf(
            Player.X to 0,
            Player.O to 0,
        )
    }

    fun changeCurrentPlayer() {
        currentPlayer = if(currentPlayer == Player.X) Player.O else Player.X
    }

    fun cleanBoard() {
        for (i in 0..<board.size) {
            for (j in 0..<board.size) {
                board[i][j] = null
            }
        }
    }

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Display(
                currentPlayer = currentPlayer,
                currentScore = currentScore,
            )
            
            Spacer(modifier = Modifier.size(24.dp))
            
            Board(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                boardProgress = board,
                onTap = { position: Position ->

                    if(board[position.x][position.y] == null) {
                        board[position.x][position.y] = currentPlayer

                        if(GameValidation.isWinner(board, currentPlayer)) {
                            currentScore[currentPlayer] = currentScore[currentPlayer]!! + 1

                            // Present message about the winner and restart board after 2 seconds
                            cleanBoard()
                        } else if(GameValidation.isEveryBoxFulfilled(board)) {

                            // It was a draw
                            // Present message about the draw and restart board after 2 seconds
                            cleanBoard()
                        }

                        changeCurrentPlayer()

//                        println("Clicked position: x: ${position.x} | y: ${position.y}")
//                        println("Current board: $board")
                    }
                }
            )
        }
    }


}