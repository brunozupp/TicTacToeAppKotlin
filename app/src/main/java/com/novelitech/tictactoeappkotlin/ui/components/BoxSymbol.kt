package com.novelitech.tictactoeappkotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novelitech.tictactoeappkotlin.models.Position

/**
 * Canvas is represented with a coordinate system, so every point is defined by two values x and y.
 * Top-left corner of our UI component’s canvas, is represented with (0, 0). Bottom-right corner
 * has the x value of canvas width and y of canvas height.
 *
 * bottom
 * start: x = 0 | y = height
 * end: x = width | y = height
 *
 * top
 * start: x = 0 | y = 0
 * end: x = width | y = 0
 *
 * left
 * start: x = 0 | y = 0
 * end: x = 0 | y = height
 *
 * right
 * start: x = width | y = 0
 * end: x = width | y = height
 */
@Composable
fun BoxSymbol(
    modifier: Modifier = Modifier,
    symbol: Char? = null,
    position: Position,
    onTap: (Position) -> Unit,
    backgroundColor: Color = Color.White,
    borderStrokeWidth: Float = 4f,
    borderColor: Color = Color.Black,
    allowBorderBottom: Boolean = true,
    allowBorderTop: Boolean = true,
    allowBorderRight: Boolean = true,
    allowBorderLeft: Boolean = true,
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .background(backgroundColor)
            .drawBehind {

                val borderSize = borderStrokeWidth.dp.toPx()

                if(allowBorderBottom) {
                    drawLine(
                        color = borderColor,
                        strokeWidth = borderSize,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                    )
                }

                if(allowBorderTop) {
                    drawLine(
                        color = borderColor,
                        strokeWidth = borderSize,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                    )
                }

                if(allowBorderLeft) {
                    drawLine(
                        color = borderColor,
                        strokeWidth = borderSize,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height),
                    )
                }

                if(allowBorderRight) {
                    drawLine(
                        color = borderColor,
                        strokeWidth = borderSize,
                        start = Offset(size.width, 0f),
                        end = Offset(size.width, size.height),
                    )
                }

            }
            .clickable {
                onTap(position)
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = symbol?.toString() ?: "",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}