package com.novelitech.tictactoeappkotlin.core.validations

import com.novelitech.tictactoeappkotlin.models.Player

class GameValidation {

    companion object {

        fun isWinner(board: List<List<Player?>>, currentPlayer: Player) : Boolean {

            // Vertical
            if(board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) {
                return true
            }

            if(board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) {
                return true
            }

            if(board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) {
                return true
            }


            // Horizontal
            if(board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer) {
                return true
            }

            if(board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer) {
                return true
            }

            if(board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer) {
                return true
            }

            // Diagonal
            if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
                return true
            }

            if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
                return true
            }

            return false
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