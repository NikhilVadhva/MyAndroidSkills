package com.example.myandroidskills

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myandroidskills.ui.theme.MyAndroidSkillsTheme

class LearnComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAndroidSkillsTheme {
                MessageCard(Message("Nikhil", "Learning Compose "))
                // CustomizeImage()
            }
        }
    }
}


@Composable
fun CustomizeImage() {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }

    val imageModifier = Modifier
        .size(250.dp)
        //.border(BorderStroke(3.dp, rainbowColorsBrush), RectangleShape)
        //.background(Color.Yellow)
        .clip(RectangleShape)
    // .padding(3.dp)
//         .aspectRatio(16f/9f)

    Image(
        painter = painterResource(id = R.drawable.dog_back),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = imageModifier,
        colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Darken)
    )
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {

    Column {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            // load bitmap drawable(jpeg, jpg, png)
            Image(
                painter = painterResource(id = R.drawable.avtar),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color.Magenta, CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }
        Row(modifier = Modifier.padding(all = 8.dp)) {
            // load image using url
            AsyncImage(
                "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RectangleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.my_android_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RectangleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }

        Row(modifier = Modifier.padding(all = 8.dp)) {
            Icon(Icons.Rounded.Face, contentDescription = "")
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }
    }


}

@Preview
@Composable
fun MessageCardPreview() {
    MessageCard(Message("Nikhil", "Learning Jetpack Compose"))
}


@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!"
    )
}

@Preview
@Composable
fun GreetingPreview() {
//    MyAndroidSkillsTheme {
//        Greeting("Android")
//    }
    Greeting("Android")
}