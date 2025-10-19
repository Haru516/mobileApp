package com.example.w04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.w04.ui.theme.Wso05Theme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val Message.body: Any
private val Message.author: Any

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Wso05Theme {
                HomeScreen()
            }
        }
    }
}

annotation class HomeScreen

class Message(val name: String, val msg: String)
class Profile(val name: String, val intro: String)

@Composable
fun CounterApp() {
    // TODO: 상태 변수 정의
    // TODO: 버튼 클릭 시 상태 변경 로직 작성
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Count: 0",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ) // TODO: 상태값 표시
        Row {
            Button(onClick = { /* TODO: 카운터 증가 로직 */ }) {
                Text("Increase")
            }
            Button(onClick = { /* TODO: 카운터 증가 로직 */ }) {
                Text("Reset")
            }
        }
    }
}

@Composable
fun StopWatchApp() {
    // TODO: 시작, 중지, 리셋 버튼과 시간 표시 로직 작성
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "00:00",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ) // TODO: 시간 표시
        Row {
            Button(onClick = { /* 시작 */ }) { Text("Start") }
            Button(onClick = { /* 중지 */ }) { Text("Stop") }
            Button(onClick = { /* 리셋 */ }) { Text("Reset") }
        }
    }
}

@Preview(
    name = "Message Card Dark Mode",
)
@Composable
fun PreviewMessageCard() {
    MyApplicationTheme {
        MessageCard(Message("Android", "Jetpack Compose"))
    }
}

@Composable
fun MessageCard(x0: Message) {
    TODO("Not yet implemented")
}