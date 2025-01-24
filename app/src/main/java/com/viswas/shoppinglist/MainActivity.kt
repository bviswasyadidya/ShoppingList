package com.viswas.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.viswas.shoppinglist.ui.theme.ShoppingListTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashIconAnimation()
                }
            }
        }
    }
}

@Composable
fun SplashIconAnimation(){
    var showMainScreen by remember { mutableStateOf(false) }
    val alpha: Float by animateFloatAsState(
        targetValue = if(showMainScreen) 0f else 1f,
        animationSpec = androidx.compose.animation.core.tween(3000,easing = androidx.compose.animation.core.FastOutSlowInEasing),
        label = "Fade Out Animation"
    )
    
    LaunchedEffect(true){
        delay(3000)
        showMainScreen = true
    }
    if(showMainScreen){
        ShoppingListApp()
    }else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .alpha(alpha)
        ) {
            Image(painter = painterResource(id = R.mipmap.ic_launcher_foreground), contentDescription = "App Icon", modifier = Modifier.size(150.dp))
        }
    }


}
