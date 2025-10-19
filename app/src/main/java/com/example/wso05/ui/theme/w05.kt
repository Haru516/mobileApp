package com.example.wso05.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.w05.ui.theme.MyApplicationTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val count = remember { mutableStateOf(0) }

                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CounterApp(count)
                    Spacer(modifier = Modifier.height(32.dp))
                    StopWatchApp()
                }
            }
        }
    }
}

@Composable
fun CounterApp(count: MutableState<Int>) {
    // TODO: 상태 변수 정의
    // TODO: 버튼 클릭 시 상태 변경 로직 작성

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Count: ${count.value}",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ) // TODO: 상태값 표시
        Row {
            Button(onClick = { count.value++  }) {
                Text("Increase")
            }
            Button(onClick = { count.value = 0 }) {
                Text("Reset")
            }
        }
    }
}

@Composable
fun StopWatchApp() {
    // TODO: 시작, 중지, 리셋 버튼과 시간 표시 로직 작성
    var timeInMillis by remember { mutableStateOf(1234L) }
    var isRunning by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "00:00",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        ) // TODO: 시간 표시
        Row {
            Button(onClick = {isRunning = true }) { Text("Start") }
            Button(onClick = {isRunning = false}) { Text("Stop") }
            Button(onClick = {isRunning = false
                timeInMillis = 0L
            }) { Text("Reset") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    val count = remember {mutableStateOf(value = 0)}
    CounterApp(count)
}

@Preview(showBackground = true)
@Composable
fun StopWatchPreview() {
    StopWatchApp()
}