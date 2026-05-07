package com.example.letssopt.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.component.SignUpTextField
import com.example.letssopt.ui.theme.LETSSOPTTheme

@Composable
fun SignUpScreen(
    uiState: SignUpUiState,
    onLoginIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onPartChange: (String) -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
            .padding(horizontal = 20.dp)
            .navigationBarsPadding(),
    ) {
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

        Text(
            text = "회원가입",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 26.dp),
        )

        Spacer(modifier = Modifier.height(36.dp))

        SignUpTextField(
            label = "아이디",
            value = uiState.loginIdInput,
            onValueChange = onLoginIdChange,
            placeholder = "아이디를 입력하세요",
        )

        SignUpTextField(
            label = "비밀번호",
            value = uiState.pwInput,
            onValueChange = onPasswordChange,
            placeholder = "비밀번호를 입력하세요",
            visualTransformation = PasswordVisualTransformation()
        )

        SignUpTextField(
            label = "비밀번호 확인",
            value = uiState.pwConfirm,
            onValueChange = onPasswordConfirmChange,
            placeholder = "비밀번호를 다시 입력하세요",
            visualTransformation = PasswordVisualTransformation()
        )

        SignUpTextField(
            label = "이름",
            value = uiState.nameInput,
            onValueChange = onNameChange,
            placeholder = "이름을 입력하세요"
        )

        SignUpTextField(
            label = "이메일",
            value = uiState.emailInput,
            onValueChange = onEmailChange,
            placeholder = "이메일을 입력하세요"
        )

        SignUpTextField(
            label = "나이",
            value = uiState.ageInput,
            onValueChange = onAgeChange,
            placeholder = "나이를 입력하세요",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        SignUpTextField(
            label = "파트",
            value = uiState.partInput,
            onValueChange = onPartChange,
            placeholder = "파트를 입력하세요"
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                onSignUpClick()
            },
            enabled = uiState.isButtonEnabled,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8003C),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFF333333),
                disabledContentColor = Color(0xFF666666)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 26.dp)
                .heightIn(min = 52.dp)
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
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen(
            uiState = SignUpUiState(),
            onLoginIdChange = {},
            onPasswordChange = {},
            onPasswordConfirmChange = {},
            onNameChange = {},
            onEmailChange = {},
            onAgeChange = {},
            onPartChange = {},
            onSignUpClick = {}
        )
    }
}