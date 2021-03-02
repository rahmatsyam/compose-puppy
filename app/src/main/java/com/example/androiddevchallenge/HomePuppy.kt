package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.Puppy


@Composable
fun HomePuppy(
    puppyList: List<Puppy>,
    navigateToPuppyDetail: (Puppy) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Text(text = "Puppy List")
                },

                )
        },
        content = {
            LazyColumn {
                items(puppyList) { puppy ->
                    PuppyCard(puppy = puppy,
                        modifier = Modifier.clickable { navigateToPuppyDetail(puppy) })

                }
            }
        }
    )

}


@Composable
fun PuppyCard(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = modifier.padding(8.dp)) {
            Surface(
                modifier = modifier.size(80.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                Image(
                    painter = painterResource(puppy.imgPuppy),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
            MaterialTheme {
                val typography = MaterialTheme.typography
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)

                ) {
                    Text(
                        text = puppy.title,
                        style = typography.h6
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            text = puppy.desc,
                            style = typography.body2,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

        }

    }

}

@Preview
@Composable
fun DefaultPreview() {

}