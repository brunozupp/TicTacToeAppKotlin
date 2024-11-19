package com.novelitech.tictactoeappkotlin.core.validations

import com.novelitech.tictactoeappkotlin.models.Player
import com.novelitech.tictactoeappkotlin.models.Position

class GameValidation {

    companion object {

        fun getPositionsWinner(board: List<List<Player?>>, currentPlayer: Player) : List<Position>? {

            // Vertical
            if(board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) {
                return listOf(Position(0,0),Position(1,0),Position(2,0))
            }

            if(board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) {
                return listOf(Position(0,1),Position(1,1),Position(2,1))
            }

            if(board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) {
                return listOf(Position(0,2),Position(1,2),Position(2,2))
            }

            // Horizontal
            if(board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer) {
                return listOf(Position(0,0),Position(0,1),Position(0,2))
            }

            if(board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer) {
                return listOf(Position(1,0),Position(1,1),Position(1,2))
            }

            if(board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer) {
                return listOf(Position(2,0),Position(2,1),Position(2,2))
            }

            // Diagonal
            if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
                return listOf(Position(0,0),Position(1,1),Position(2,2))
            }

            if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
                return listOf(Position(0,2),Position(1,1),Position(2,0))
            }

            return null
        }

        fun isEveryBoxFulfilled(board: List<List<Player?>>) : Boolean {

            for (i in board.indices) {
                for (j in board.indices) {
                    if(board[i][j] == null) {
                        return false
                    }
                }
            }

            return true
        }
    }
}