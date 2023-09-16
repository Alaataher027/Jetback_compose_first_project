package com.example.facebookpostj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.facebookpostj.ui.theme.FacebookPostJTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookPostJTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {

                RV(
                    data = listOf<PostModel>(
                        PostModel(
                            PersonalImage = R.drawable.pr1,
                            name = "Alaa Taher",
                            time = "2h",
                            imagePost = R.drawable.pr1,
                            NoLikes = "50",
                            Noshares = "3",
                            caption = "Good Morning"
                        ),
                        PostModel(
                            PersonalImage = R.drawable.pr2,
                            name = "Mona Ahmed",
                            time = "5h",
                            imagePost = R.drawable.pr2,
                            NoLikes = "120",
                            Noshares = "8",
                            caption = "Hello World!"
                        ),
                        PostModel(
                            PersonalImage = R.drawable.pr3,
                            name = "Taher Mohammed",
                            time = "1h",
                            imagePost = R.drawable.pr3,
                            NoLikes = "700",
                            Noshares = "50",
                            caption = "Welcome"
                        ),
                        PostModel(
                            PersonalImage = R.drawable.pr1,
                            name = "Alaa Taher",
                            time = "2h",
                            imagePost = R.drawable.pr1,
                            NoLikes = "50",
                            Noshares = "3",
                            caption = "Good Morning again!"
                        )

                    )

                )

            }
        }
    }
}

@Composable
fun Post(
    modifier: Modifier = Modifier,
    postModel: PostModel
) {
//    val constrainSet = ConstraintSet {
//        val personImage = createRefFor("personImage")
//        val name = createRefFor("name")
//        val time = createRefFor("time")
//        val imagePost = createRefFor("imagePost")
//        val noLikes = createRefFor("noLikes")
//        val noshares = createRefFor("noshares")
//        val caption = createRefFor("caption")
//    }
    ConstraintLayout(
        modifier
            .fillMaxWidth()
            .height(505.dp)
            .padding(8.dp)
            .background(color = Color.White)

    ) {
        val (personImage, name, time,
            imagePost, noLikes, noshares, caption,
            moretop, like, share, colors, mored, btns) = createRefs()
        Image(
            painter = painterResource(id =postModel.PersonalImage),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(personImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)

                }
                .clip(CircleShape)
        )

        Text(
            text = postModel.name ?: "",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .constrainAs(name) {
                    start.linkTo(personImage.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(time.top)
                }
                .padding(start = 12.dp, top = 15.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.more_dot_ic),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(moretop) {
                    start.linkTo(parent.start)
                    bottom.linkTo(caption.top)
                    end.linkTo(parent.end)
                }
                .padding(start = 290.dp, bottom = 40.dp)

        )

        Text(
            text = postModel.time ?: "",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier
                .constrainAs(time) {
                    start.linkTo(personImage.end)
                    top.linkTo(name.bottom)
                }
                .padding(start = 12.dp, top = 5.dp)
        )

        Text(
            text = postModel.caption ?: "",
            style = TextStyle(
                fontSize = 21.sp,
            ),
            modifier = Modifier
                .constrainAs(caption) {
                    start.linkTo(parent.start)
                    top.linkTo(personImage.bottom)
                }
                .padding(start = 12.dp, top = 15.dp)

        )

        Image(
            painter = painterResource(id = postModel.imagePost),
            contentDescription = "",
            modifier = Modifier
                .size(280.dp)
                .constrainAs(imagePost) {
                    top.linkTo(caption.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 12.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.baseline_thumb_up_24),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(like) {
                    start.linkTo(parent.start)
                    top.linkTo(imagePost.bottom)


                }
                .padding(start = 8.dp, top = 10.dp)
        )
        Text(
            text = postModel.NoLikes ?: "",
            style = TextStyle(
                fontSize = 20.sp,
            ),
            modifier = Modifier
                .constrainAs(noLikes) {
                    start.linkTo(like.end)
                    top.linkTo(imagePost.bottom)

                }
                .padding(start = 8.dp, top = 10.dp)
        )

        Text(
            text = postModel.Noshares ?: "",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .constrainAs(noshares) {
                    start.linkTo(noLikes.end)
                    top.linkTo(imagePost.bottom)

                }
                .padding(start = 190.dp, top = 10.dp)
        )

        Text(
            text = "Share",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .constrainAs(share) {
                    start.linkTo(noshares.end)
                    top.linkTo(imagePost.bottom)

                }
                .padding(start = 5.dp, top = 10.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.circle_ic),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(colors) {
                    start.linkTo(share.end)
                    top.linkTo(imagePost.bottom)
                }
                .padding(start = 5.dp,top = 13.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.baseline_expand_more_24),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(mored) {
                    start.linkTo(colors.end)
                    top.linkTo(imagePost.bottom)
                }
                .padding(top = 13.dp)

        )

        Row(
            modifier = Modifier
                .constrainAs(btns){
                    top.linkTo(like.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(Color.White),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_thumb_up_24),
                    contentDescription = "Like",
                )
                Text("Like")
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.textButtonColors( Color.White),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.comment_ic),
                    contentDescription = "Comment"
                )
                Text("Comment")
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.textButtonColors(Color.White),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.share_24),
                    contentDescription = "Share"
                )
                Text("Share")
            }
        }



    }


}

@Composable
fun RV(
    modifier: Modifier = Modifier,
    data: List<PostModel>
) {
    LazyColumn {
        items(data.size) {
            Post(postModel = data.get(it))
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    FacebookPostJTheme {
        RV(
            data = listOf<PostModel>(
                PostModel(
                    PersonalImage = R.drawable.pr1,
                    name = "Alaa Taher",
                    time = "2h",
                    imagePost = R.drawable.pr1,
                    NoLikes = "50",
                    Noshares = "3",
                    caption = "Good Morning"
                ),
                PostModel(
                    PersonalImage = R.drawable.pr2,
                    name = "Mona Ahmed",
                    time = "5h",
                    imagePost = R.drawable.pr2,
                    NoLikes = "120",
                    Noshares = "8",
                    caption = "Hello World!"
                ),
                PostModel(
                    PersonalImage = R.drawable.pr3,
                    name = "Taher Mohammed",
                    time = "1h",
                    imagePost = R.drawable.pr3,
                    NoLikes = "700",
                    Noshares = "50",
                    caption = "Welcome"
                ),
                PostModel(
                    PersonalImage = R.drawable.pr1,
                    name = "Alaa Taher",
                    time = "2h",
                    imagePost = R.drawable.pr1,
                    NoLikes = "50",
                    Noshares = "3",
                    caption = "Good Morning again!"
                )

            )

        )
    }
}