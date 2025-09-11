package com.example.cw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // 显示可点击切换消息的卡片
                        ToggleCard(
                            modifier = Modifier
                                .size(300.dp)
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * 可点击切换消息的卡片组件
 * @param modifier 应用于卡片的修饰符
 */
@Composable
fun ToggleCard(modifier: Modifier = Modifier) {
    // 使用rememberSaveable保存状态，确保配置变化时状态不丢失
    var isToggled by rememberSaveable { mutableStateOf(false) }

    // 根据状态决定显示的消息
    val message = if (isToggled) {
        "Kotlin was created by JetBrains!"
    } else {
        "Tap to see a fun fact!"
    }

    // 卡片组件，点击时切换状态
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        onClick = { isToggled = !isToggled } // 点击事件：切换状态
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.titleMedium,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToggleCardPreview() {
    Cw2Theme {
        ToggleCard(
            modifier = Modifier
                .size(300.dp)
                .padding(16.dp)
        )
    }
}
