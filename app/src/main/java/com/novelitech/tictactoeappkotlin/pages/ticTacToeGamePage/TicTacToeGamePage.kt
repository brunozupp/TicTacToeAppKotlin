package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.novelitech.tictactoeappkotlin.models.Position
import com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.board.Board
import com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.display.Display

@Composable
fun TicTacToeGamePage(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Display()
            
            Spacer(modifier = Modifier.size(24.dp))
            
            Board(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                onTap = { position: Position ->
                    println("Clicked position: x: ${position.x} | y: ${position.y}")
                }
            )
        }
    }
}