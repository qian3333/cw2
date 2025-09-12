package com.example.cw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cw2.ui.theme.Cw2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cw2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // first card：size + padding + border + background
                        ColorCard(
                            color = Color(0xFF6200EE),
                            label = "Card 1",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(8.dp)
                                .border(
                                    border = BorderStroke(3.dp, Color.DarkGray)
                                )
                        )

                        // second card：size + padding + border + background
                        ColorCard(
                            color = Color(0xFF03DAC6),
                            label = "Card 2",
                            modifier = Modifier
                                .padding(12.dp)
                                .size(180.dp)
                                .border(
                                    border = BorderStroke(3.dp, Color.Black)

                                )
                        )

                        // third card：size + padding + border + background
                        ColorCard(
                            color = Color(0xFFFF5722),
                            label = "Card 3",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(15.dp)
                                .border(
                                    border = BorderStroke(3.dp, Color.White)
                                )
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ColorCard(
    color: Color,
    label: String,
    modifier: Modifier = Modifier
) {
    // Use the background modifier in Box, ensuring that all four modifiers are used.
    Box(
        modifier = modifier
            .background(color)
    ) {
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.Center) // Center the text
                .padding(4.dp) // Extra padding for the text
        )
    }
}




@Preview(showBackground = true)
@Composable
fun ColorCardsPreview() {
    Cw2Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ColorCard(
                color = Color(0xFF6200EE),
                label = "Card 1",
                modifier = Modifier.size(200.dp)
            )
            ColorCard(
                color = Color(0xFF03DAC6),
                label = "Card 2",
                modifier = Modifier.size(180.dp)
            )
            ColorCard(
                color = Color(0xFFFF5722),
                label = "Card 3",
                modifier = Modifier.size(220.dp)
            )
        }
    }
}
