package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.ui.theme.outlineColor
import com.example.androiddevchallenge.viewmodel.puppyList

@Composable
fun PuppyListItem(puppy: Puppy, onPuppyClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp, top = 4.dp, bottom = 8.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onPuppyClick(puppy.id)
            },
        elevation = 8.dp,
        border = BorderStroke(1.dp, MaterialTheme.colors.outlineColor)
    ) {
        Column {
            NetworkImage(data = puppy.image, modifier = Modifier.height(180.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    puppy.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    fontWeight = FontWeight.SemiBold
                )
                if (puppy.sex == Sex.MALE) {
                    Image(
                        painterResource(R.drawable.ic_male),
                        "male",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp)
                    )
                } else if (puppy.sex == Sex.FEMALE) {
                    Image(
                        painterResource(R.drawable.ic_female),
                        contentDescription = "female",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
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
    PuppyListItem(puppy = puppyList[0], onPuppyClick = { })
}