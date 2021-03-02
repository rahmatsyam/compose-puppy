package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.Puppy

@Composable
fun PuppyDetail(
    puppy: Puppy,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(

//                actions = {
//                    IconButton(onClick = navigateBack) {
//                        Icon(
//                            Icons.Filled.ArrowBack,
//                            contentDescription = "back",
//                            tint = Color.White
//                        )
//                    }
//                },

                title = {
                    Text(text = puppy.title)
                },

                )
        },
        content = {
            PuppyDetailContent(puppy = puppy)
        }
    )
}

@Composable
private fun PuppyDetailContent(puppy: Puppy) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(puppy.imgPuppy),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = puppy.desc,
                style = typography.body2,

                )

        }

    }
}
//@Composable
//fun LayoutCodelabTest() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Layout Codelab Test")
//                },
//
//            )
//        }
//    ) { innerPadding ->
//        BodyContentTest(Modifier.padding(innerPadding))
//    }
//}