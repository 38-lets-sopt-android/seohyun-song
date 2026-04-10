package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var emailInput by remember { mutableStateOf("") }
    var pwInput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
            .padding(all = 20.dp),
    ) {
        // 로고
        Text(
            text = "watcha",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            color = Color(0xFFE8003C),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 60.dp),
        )

        // 이메일로 로그인
        Text (
            text = "이메일로 로그인",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 26.dp),
        )

        // 이메일
        Text (
            text = "이메일",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            color = Color(0xFF999999),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 36.dp),
        )

        Spacer(modifier = Modifier.height(3.dp))

        TextField (
            value = emailInput,
            onValueChange = { emailInput = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            ),
            placeholder = { Text(
                text = "이메일 주소를 입력하세요",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                color = Color(0xFF666666),
            ) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        // 비밀번호
        Text (
            text = "비밀번호",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            color = Color(0xFF999999),
            modifier = Modifier
                .align(Alignment.Start)
                //.padding(top = 36.dp),
        )

        Spacer(modifier = Modifier.height(3.dp))

        TextField (
            value = pwInput,
            onValueChange = { pwInput = it },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            ),
            placeholder = { Text(
                text = "비밀번호를 입력하세요",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                color = Color(0xFF666666),
            ) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        // 회원가입 이동 텍스트
        Text(
            text = "아직 계정이 없으신가요? 회원가입",
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            color = Color(0xFF999999),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                // .padding(top = 200.dp)
                .clickable(onClick = {
                    val intent = Intent(context,SignUpActivity::class.java)
                    context.startActivity(intent)
                })
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 로그인 버튼
        Button(
            onClick = { Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8003C),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(
                "로그인",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LETSSOPTTheme {
        LoginScreen("Android")
    }
}