package com.example.androiddevchallenge.ui.detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.ui.component.NetworkImage
import com.example.androiddevchallenge.viewmodel.puppyList

@Composable
fun PuppyDetail(puppyId: Int, back: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        val puppy = puppyList.first {
            it.id == puppyId
        }
        val ctx = LocalContext.current
        Box(modifier = Modifier.fillMaxSize()) {
            IconButton(
                onClick = { back() },
                modifier = Modifier
                    .zIndex(8f)
            ) {
                Icon(imageVector = Icons.TwoTone.ArrowBack, contentDescription = null)
            }
            Column {
                NetworkImage(
                    data = puppy.image,
                    modifier = Modifier
                        .fillMaxHeight(fraction = 0.45f)
                        .fillMaxWidth()
                )
                Card(
                    elevation = if (MaterialTheme.colors.isLight) 8.dp else 0.dp,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                    )
                    {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Name: ${puppy.name}")
                            if (puppy.sex == Sex.MALE) {
                                Image(
                                    painterResource(R.drawable.ic_male),
                                    null,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .padding(start = 10.dp)
                                )
                            } else if (puppy.sex == Sex.FEMALE) {
                                Image(
                                    painterResource(R.drawable.ic_female),
                                    null,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(start = 10.dp)
                                )
                            }
                        }
                        Text(text = "Breed: ${puppy.breed}")
                        Text(text = "Birth Date: ${puppy.birthDate}")
                        Text(text = "Location: ${puppy.location}")
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                        )
                        Text(text = puppy.desc)
                    }
                }
            }
            Button(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .absoluteOffset(y = (-24).dp),
                onClick = {
                    Toast.makeText(ctx, "Thank adopt!", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("Adopt Me")
            }
        }
    }
}

@Preview
@Composable
fun PuppyDetailPreview() {
    PuppyDetail(puppyId = 7245, back = { })
}