package com.novelitech.tictactoeappkotlin.core.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

fun Modifier.topBorder(
    color: Color,
    strokeWidth: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        strokeWidth = strokeWidth,
        start = Offset(0f, 0f),
        end = Offset(size.width, 0f),
    )
}

fun Modifier.bottomBorder(
    color: Color,
    strokeWidth: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        strokeWidth = strokeWidth,
        start = Offset(0f, size.height),
        end = Offset(size.width, size.height),
    )
}

fun Modifier.rightBorder(
    color: Color,
    strokeWidth: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        strokeWidth = strokeWidth,
        start = Offset(size.width, 0f),
        end = Offset(size.width, size.height),
    )
}

fun Modifier.leftBorder(
    color: Color,
    strokeWidth: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        strokeWidth = strokeWidth,
        start = Offset(0f, 0f),
        end = Offset(0f, size.height),
    )
}