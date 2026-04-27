package com.example.letssopt

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import com.example.letssopt.ui.theme.LETSSOPTTheme
import kotlin.jvm.java

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val pref = getSharedPreferences("LoginPref", MODE_PRIVATE)
        val savedEmail = pref.getString("email", "")
        val savedPw = pref.getString("password", "")

        if (!savedEmail.isNullOrEmpty() && !savedPw.isNullOrEmpty()) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var emailInput by remember { mutableStateOf("") }
    var pwInput by remember { mutableStateOf("") }

    var registeredEmail by remember { mutableStateOf("") }
    var registeredPw by remember { mutableStateOf("") }

    val signUpLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result -> 
        if (result.resultCode == RESULT_OK) {
            registeredEmail = result.data?.getStringExtra("email") ?: ""
            registeredPw = result.data?.getStringExtra("password") ?: ""
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
            .padding(horizontal = 20.dp),
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
                .clickable(onClick = {
                    val intent = Intent(context,SignUpActivity::class.java)
                    signUpLauncher.launch(intent)
                })
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 로그인 버튼
        Button(
            onClick = {
                loginValidate(
                    context = context,
                    emailInput = emailInput,
                    pwInput = pwInput,
                    registeredEmail = registeredEmail,
                    registeredPw = registeredPw
                )
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8003C),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 26.dp)
                .heightIn(min = 52.dp)
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

private fun loginValidate (
    context: android.content.Context,
    emailInput: String,
    pwInput: String,
    registeredEmail: String,
    registeredPw: String
) {
    when {
        // 회원가입 정보가 없을 때
        registeredEmail.isEmpty() || registeredPw.isEmpty() -> {
            Toast.makeText(context, "먼저 회원가입을 진행해 주세요", Toast.LENGTH_SHORT).show()
        }
        // 이메일 또는 비밀번호 불일치
        emailInput != registeredEmail || pwInput != registeredPw -> {
            Toast.makeText(context, "이메일 또는 비밀번호가 올바르지 않습니다", Toast.LENGTH_SHORT).show()
        }
        // 로그인 성공
        else -> {
            context.getSharedPreferences("LoginPref", Context.MODE_PRIVATE).edit {
                putString("email", emailInput)
                putString("password", pwInput)
            }

            Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            context.startActivity(intent)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LETSSOPTTheme {
        LoginScreen()
    }
}