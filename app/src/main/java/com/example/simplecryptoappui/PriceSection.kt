package com.example.simplecryptoappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecryptoappui.ui.theme.BlueEnd
import com.example.simplecryptoappui.ui.theme.BlueStart
import com.example.simplecryptoappui.ui.theme.GreenEnd
import com.example.simplecryptoappui.ui.theme.GreenStart
import com.example.simplecryptoappui.ui.theme.OrangeEnd
import com.example.simplecryptoappui.ui.theme.OrangeStart
import com.example.simplecryptoappui.ui.theme.PurpleEnd
import com.example.simplecryptoappui.ui.theme.PurpleStart
import kotlin.contracts.contract


val coins = listOf(
    Price(icon = R.drawable.bitcoin,
        name = "Bitcoin",
        price = "₹37,43,263",
        color = getGradient(BlueStart, BlueEnd)),
    Price(icon = R.drawable.ethereum,
        name = "Ethereum",
        price = "₹1,97,959",
        color = getGradient(GreenStart, GreenEnd)),
    Price(icon = R.drawable.litecoin,
        name = "Litecoin",
        price = "₹6,266",
        color = getGradient(PurpleStart, PurpleEnd)),
    Price(icon = R.drawable.ripple,
        name = "Ripple",
        price = "₹53.11",
        color = getGradient(OrangeStart, OrangeEnd)),
    Price(icon = R.drawable.litecoin,
        name = "Solana",
        price = "₹9,287",
        color = getGradient(BlueStart, BlueEnd)),
    Price(icon = R.drawable.dogecoin,
        name = "Dogecoin",
        price = "₹7.78",
        color = getGradient(GreenStart, GreenEnd)),
    Price(icon = R.drawable.tether,
        name = "Tether",
        price = "₹83.26",
        color = getGradient(OrangeStart, OrangeEnd)),
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}


@Composable
fun PriceSection() {
    
    LazyRow{
        items(coins.size) { index ->
            BitcoinCard(index)
        }

    }
}

@Composable
fun BitcoinCard(index: Int) {

    val coin = coins[index]
    var lastItemPadding = 0.dp
    if (index == coins.size - 1) {
        lastItemPadding = 16.dp
    }
    Box(modifier = Modifier
        .padding(8.dp)
       // .width(250.dp)
        //.height(170.dp)
        , contentAlignment=  Alignment.Center){

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(coin.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp), verticalArrangement = Arrangement.SpaceBetween
        ){
            Box(modifier = Modifier
                .padding(4.dp)
                , contentAlignment=  Alignment.Center) {

               Image(painter = painterResource(id = coin.icon), contentDescription = null,modifier = Modifier.size(34.dp))
            }
            Text(text = coin.name, fontSize = 25.sp,color = Color.White, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = coin.price, fontSize = 35.sp,color = Color.White, fontWeight = FontWeight.Bold)


            }
        }

    }
