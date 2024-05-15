package com.jbgcomposer.flixhub.presentation.details_sc.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbgcomposer.flixhub.data.dto.Rating

@Composable
fun MovieRatings(
    ratings: List<Rating>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = "Ratings:",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0XFF3559E0),
                fontWeight = FontWeight.SemiBold
            )
        )
        ratings.forEach { rating ->
            Text(
                text = "${rating.source}: ${rating.value}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            )
        }
    }
}
