package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novelitech.tictactoeappkotlin.core.validations.GameValidation
import com.novelitech.tictactoeappkotlin.models.Player
import com.novelitech.tictactoeappkotlin.models.Position
import com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.board.Board
import com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.display.Display
import kotlinx.coroutines.launch

/**
 * I had some issues with the update of the board using the mutableState in a collection.
 * https://blog.zachklipp.com/two-mutables-dont-make-a-right/
 * https://tigeroakes.com/posts/mutablestateof-list-vs-mutablestatelistof/
 * The links above explain why it happens
 */

@OptIn(ExperimentalMaterial3Api::class)
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

    // Control the snackBar
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
//            TopAppBar(
//                modifier = Modifier.background(Color.Blue),
//                title = {
//                    Text(
//                        text = "Tic Tac Toe",
//                    )
//                },
//            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 48.dp, bottom = 28.dp)

                ) {
                    Text(
                        text = "Tic Tac Toe",
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
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

                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "The player $currentPlayer won the game.",
                                    withDismissAction = true,
                                )

                                cleanBoard()
                            }
                        } else if(GameValidation.isEveryBoxFulfilled(board)) {

                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "Game ended up as a draw",
                                    withDismissAction = true,
                                )

                                cleanBoard()
                            }
                        }

                        changeCurrentPlayer()
                    }
                }
            )
        }
    }


}