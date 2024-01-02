package com.example.simplecryptoappui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecryptoappui.ui.theme.BlueEnd
import com.example.simplecryptoappui.ui.theme.BlueStart
import com.example.simplecryptoappui.ui.theme.GreenEnd
import com.example.simplecryptoappui.ui.theme.GreenStart
import com.example.simplecryptoappui.ui.theme.OrangeEnd
import com.example.simplecryptoappui.ui.theme.OrangeStart
import com.example.simplecryptoappui.ui.theme.Pink40
import com.example.simplecryptoappui.ui.theme.PurpleEnd
import com.example.simplecryptoappui.ui.theme.PurpleStart


val trades = listOf(
    LiveTrading(icon = R.drawable.bitcoin,
        name = "Bitcoin",
        price = "₹37,43,263",
        currentPrice = "₹7,232",
        availableCoin = "0.458 COIN",
        color = getGradient(BlueStart, BlueEnd)),
    LiveTrading(icon = R.drawable.ethereum,
        name = "Ethereum",
        price = "₹1,97,959",
        currentPrice = "₹24,221",
        availableCoin = "5.674 COIN",
        color = getGradient(GreenStart, GreenEnd)),
    LiveTrading(icon = R.drawable.litecoin,
        name = "Litecoin",
        price = "₹6,266",
        currentPrice = "₹2,123",
        availableCoin = "873.233 COIN",
        color = getGradient(PurpleStart, PurpleEnd)
),
    LiveTrading(icon = R.drawable.ripple,
        name = "Ripple",
        price = "₹53.11",
        currentPrice = "₹23.23",
        availableCoin = "3.233 COIN",
        color = getGradient(OrangeStart, OrangeEnd)
),
    LiveTrading(icon = R.drawable.solana,
        name = "Solana",
        price = "₹9,287",
        currentPrice = "₹2.23",
        availableCoin = "3.12 COIN",
        color = getGradient(BlueStart, BlueEnd)
),
    LiveTrading(icon = R.drawable.dogecoin,
        name = "Dogecoin",
        price = "₹7.78",
        currentPrice = "₹0.23",
        availableCoin = "29932.12 COIN",
        color = getGradient(GreenStart, GreenEnd)

    ),
    LiveTrading(icon = R.drawable.tether,
        name = "Tether",
        price = "₹83.26",
        currentPrice = "₹51.23",
        availableCoin = "72.12 COIN",
        color = getGradient(OrangeStart, OrangeEnd)
    )
)



@Composable

fun TradingSection() {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .padding(10.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Live Trading",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 15.dp, start = 7.dp)
            )


            Button(
                onClick = { }, modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Pink40)
            ) {
                Text(text = "BUY")
            }


        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn{
            items (trades.size){
                index ->
                CryptoCard(index)
            }
        }

    }


}

@Composable
fun CryptoCard(index : Int) {
    val trade = trades[index]
    var lastItemPadding = 0.dp
    if (index == coins.size - 1) {
        lastItemPadding = 16.dp
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .wrapContentHeight().background(MaterialTheme.colorScheme.secondary),
        border = BorderStroke(1.dp,color = PurpleEnd),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Box(
                modifier = Modifier
                    .padding(10.dp, top = 12.dp)
                    .background(trade.color)

            ) {
                Image(
                    painter = painterResource(id =trade.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(
                            RoundedCornerShape(18.dp),
                        )
                )
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = trade.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 15.dp, start = 7.dp)
                )
                Text(
                    text = trade.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp, start = 7.dp)
                )
            }


            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = trade.currentPrice,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 15.dp, start = 7.dp)
                )
                Text(
                    text = trade.availableCoin,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 7.dp)
                )
            }

        }
    }
}


fun getGradientcolor(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

