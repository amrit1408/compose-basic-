package com.itarm.calculatorapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itarm.calculatorapp.scrollList.ScrollingActivity
import com.itarm.calculatorapp.ui.theme.CalculatorAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppTheme {
                // A surface container using the 'background' color from the theme
                CalculatorApp()
            }
        }
    }


}

@Composable
fun CalculatorApp() {
    var amount by remember { mutableStateOf("") }
    val localContext = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Calculate Tips.",
            fontSize = 17.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = amount,
            onValueChange = { textFieldValue -> amount = textFieldValue },
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Tip amount: $ $amount")

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            localContext.startActivity(
                Intent(
                    localContext,
                    ScrollingActivity::class.java
                )
            )
        }) {
            Text(text = "Go to Scroll Project")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorAppTheme {
        CalculatorApp()
    }
}