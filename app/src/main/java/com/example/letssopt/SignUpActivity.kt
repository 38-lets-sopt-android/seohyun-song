package com.example.letssopt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(name: String, modifier: Modifier) {
    val context = LocalContext.current
    var emailInput by remember { mutableStateOf("") }
    var pwInput by remember { mutableStateOf("") }
    var pwConfirm by remember { mutableStateOf("") }

    val isButtonEnabled = emailInput.isNotBlank() && pwInput.isNotBlank() && pwConfirm.isNotBlank()

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

        // 회원가입
        Text (
            text = "회원가입",
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

        Spacer(modifier = Modifier.height(18.dp))

        // 비밀번호 확인
        Text (
            text = "비밀번호 확인",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            color = Color(0xFF999999),
            modifier = Modifier
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(3.dp))

        TextField (
            value = pwConfirm,
            onValueChange = { pwConfirm = it },
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
                text = "비밀번호를 다시 입력하세요",
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

        // 회원가입 버튼
        Button(
            onClick = {
                when {
                    // 이메일 형식: !EMAIL_ADDRESS.matcher(emailText).matches()
                    !EMAIL_ADDRESS.matcher(emailInput).matches() -> {
                        Toast.makeText(context, "이메일 형식이 올바르지 않습니다", Toast.LENGTH_SHORT).show()
                    }
                    // 비밀번호 길이: pwText.length !in 8..12
                    pwInput.length !in  8..12 -> {
                        Toast.makeText(context, "비밀번호는 8자 이상 12자 이하로 입력해 주세요", Toast.LENGTH_SHORT).show()
                    }
                    // 비밀번호 일치: pwText != pwConfirmText
                    pwInput != pwConfirm -> {
                        Toast.makeText(context, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                    }
                    // 회원가입 성공
                    else -> {
                        Toast.makeText(context, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                        val resultIntent = Intent().apply {
                            putExtra("email", emailInput)
                            putExtra("password", pwInput)
                        }
                        (context as Activity).setResult(Activity.RESULT_OK, resultIntent)
                        context.finish()
                    }
                }
            },
            enabled = isButtonEnabled,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8003C),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFF333333),
                disabledContentColor = Color(0xFF666666)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(
                "회원가입",
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
private fun SignUpPreview() {
    LETSSOPTTheme {
        SignUpScreen("Android", modifier = Modifier)
    }
}