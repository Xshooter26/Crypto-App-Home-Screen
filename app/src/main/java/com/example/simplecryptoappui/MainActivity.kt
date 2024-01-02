package com.example.simplecryptoappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecryptoappui.ui.theme.SimpleCryptoAppUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCryptoAppUiTheme {
                // A surface container using the 'background' color from the theme

HomeScreen()


            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(){


    Scaffold(
    ){

        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {

            TabSection()

            Spacer(modifier = Modifier.height(16.dp))

            PriceSection()

            //CheckOutSection()
            Spacer(modifier = Modifier.height(16.dp))

            TradingSection()

        }


    }
}