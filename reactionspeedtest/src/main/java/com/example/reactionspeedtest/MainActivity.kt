package com.example.w10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ★ 기본 MaterialTheme만 사용 (W10Theme 싹 제거)
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReactionGameScreen()
                }
            }
        }
    }
}

// 게임 상태 enum
private enum class GameState { Idle, Waiting, Ready, Result }

@Composable
fun ReactionGameScreen() {
    var gameState by remember { mutableStateOf(GameState.Idle) }
    var message by remember { mutableStateOf("시작 버튼을 누르세요") }
    var startTime by remember { mutableStateOf(0L) }
    var reactionTime by remember { mutableStateOf<Long?>(null) }

    // Waiting 상태일 때 1~3초 랜덤 대기 후 Ready 로 전환
    LaunchedEffect(gameState) {
        if (gameState == GameState.Waiting) {
            val delayTime = Random.nextLong(1000L, 3000L)
            delay(delayTime)
            startTime = System.currentTimeMillis()
            gameState = GameState.Ready
            message = "지금 화면을 터치하세요!"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                when (gameState) {
                    GameState.Ready -> Color.Green
                    GameState.Result -> Color.DarkGray
                    else -> Color.Black
                }
            )
            .clickable(enabled = gameState == GameState.Ready) {
                val end = System.currentTimeMillis()
                reactionTime = end - startTime
                gameState = GameState.Result
                message = "반응속도: ${reactionTime} ms"
            },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Reaction Game",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = message,
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    gameState = GameState.Waiting
                    reactionTime = null
                    message = "색이 초록색으로 바뀌면 바로 터치!"
                },
                enabled = gameState == GameState.Idle || gameState == GameState.Result
            ) {
                Text(text = "시작")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReactionGamePreview() {
    // ★ Preview 도 동일하게 MaterialTheme 사용
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ReactionGameScreen()
        }
    }
}