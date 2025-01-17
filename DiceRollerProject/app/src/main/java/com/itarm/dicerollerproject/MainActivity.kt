package com.itarm.dicerollerproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.itarm.dicerollerproject.ui.theme.DiceRollerProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerProjectTheme {
                DiceRollerApp()
            }
        }
    }
}


@Composable
fun DiceRollerApp() {
    // A surface container using the 'background' color from the theme
    DiceRollerWithImageAndButton()
}

@Composable
fun DiceRollerWithImageAndButton(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var num by remember { mutableStateOf(1) }
    val imageResource = when (num) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val image = painterResource(id = imageResource)
        Image(
            painter = image,
            contentDescription = num.toString(),
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
        Button(
            onClick = {
                num = (1..6).random()

            }
        ) {
            Text(
                text = stringResource(R.string.roll),
                modifier = Modifier.padding(10.dp),
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerProjectTheme {
        DiceRollerApp()
    }
}