package com.novelitech.tictactoeappkotlin.pages.ticTacToeGamePage.widgets.display

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novelitech.tictactoeappkotlin.core.extensions.bottomBorder
import com.novelitech.tictactoeappkotlin.core.extensions.leftBorder
import com.novelitech.tictactoeappkotlin.core.extensions.rightBorder
import com.novelitech.tictactoeappkotlin.models.Player

@Composable
fun DisplayTableScore(
    modifier: Modifier = Modifier,
    currentScore: MutableMap<Player, Int>,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(4.dp, Color.Black)
            .background(Color(0xFFeeeeee)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .bottomBorder(
                        color = Color.Black,
                        strokeWidth = 4f,
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffe3e6e8))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(

                        text = "Score",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }
            }
            Row {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .rightBorder(
                            color = Color.Black,
                            strokeWidth = 4f,
                        )
                        .padding(16.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    TextPlayerScore(
                        title = "Player X",
                        score = currentScore[Player.X]!!,
                    )
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                    ) {
//                        Text(text = "Player X")
//                        Text(
//                            text = "${currentScore[Player.X]}",
//                            style = TextStyle(
//                                fontSize = 40.sp,
//                            ),
//                        )
//                    }
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .leftBorder(
                            color = Color.Black,
                            strokeWidth = 4f,
                        )
                        .padding(16.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    TextPlayerScore(
                        title = "Player O",
                        score = currentScore[Player.O]!!,
                    )
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                    ) {
//                        Text(text = "Player O")
//                        Text(
//                            text = "${currentScore[Player.O]}",
//                            style = TextStyle(
//                                fontSize = 40.sp,
//                            ),
//                        )
//                    }
                }
            }
        }
    }
}