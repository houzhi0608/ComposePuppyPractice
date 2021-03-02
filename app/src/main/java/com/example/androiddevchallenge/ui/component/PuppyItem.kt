package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.ui.theme.darkGray
import com.example.androiddevchallenge.ui.theme.veryLightGray
import com.example.androiddevchallenge.viewmodel.puppyList

@Composable
fun PuppyListItem(puppy: Puppy, onPuppyClick: (Int) -> Unit, darkTheme: MutableState<Boolean>) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onPuppyClick(puppy.id)
            },
        elevation = 8.dp,
        border = BorderStroke(1.dp, if (darkTheme.value) darkGray else veryLightGray)
    ) {
        Column {
            NetworkImage(data = puppy.image, modifier = Modifier.height(180.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    puppy.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                if (puppy.sex == Sex.MALE) {
                    Image(
                        painterResource(R.drawable.ic_male),
                        null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(start = 8.dp)
                    )
                } else if (puppy.sex == Sex.FEMALE) {
                    Image(
                        painterResource(R.drawable.ic_female),
                        null,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(start = 8.dp)
                    )
                }
            }
            Text(
                puppy.breed,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PuppyListItemPreview() {
    PuppyListItem(puppy = puppyList[0], onPuppyClick = { }, mutableStateOf(true))
}