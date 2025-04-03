package com.fit2081.fit2081_a1_caileen_34375783

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fit2081.fit2081_a1_caileen_34375783.ui.theme.FIT2081_A1_Caileen_34375783Theme
import com.fit2081.fit2081_a1_caileen_34375783.ui.theme.Purple40
import java.io.BufferedReader
import java.io.InputStreamReader

class InsightsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FIT2081_A1_Caileen_34375783Theme {
                val navController: NavHostController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(navController)
                    }) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        InsightsScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun InsightsScreen(navController: NavHostController) {

    val mContext = LocalContext.current
    val sharedPref = mContext.getSharedPreferences("Assignment1", Context.MODE_PRIVATE)
    val mID = sharedPref.getString("id", "")
    val userData = getDataByID(mContext, "data.csv", mID.toString())
    println("user data id is: " + userData)
    val isFemale = userData[2] == "Female"
    println("isFemale"+ isFemale)
    val totalScoreMessage: String = "My total Score is " + calculateTotalScore() + "."


    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text =  "Insights: Food Score",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp)
        }


        Spacer(modifier = Modifier.height(25.dp))

        /** Sliders
         *
         */
        // 1. Vegetables
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Vegetables",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("veg is female and score is: " + userData[9].toFloat())
                mySlider(x = userData[9].toFloat(), y = 5f)
            } else {
                println("veg is male and score is: " + userData[8].toFloat())
                mySlider(x = userData[8].toFloat(), y = 5f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 2. Fruits
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Fruits",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("fruit is female and score is: " + userData[20].toFloat())
                mySlider(x = userData[20].toFloat(), y = 5f)
            } else {
                println("fruit is male and score is: " + userData[19].toFloat())
                mySlider(x = userData[19].toFloat(), y = 5f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 3. Grains and Cereals
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Grains and Cereals",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("grain is female and score is: " + userData[30].toFloat())
                mySlider(x = userData[30].toFloat(), y = 5f)
            } else {
                println("grain is male and score is: " + userData[29].toFloat())
                mySlider(x = userData[29].toFloat(), y = 5f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 4. Whole Grains
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Whole Grains",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("whole grain is female and score is: " + userData[34].toFloat())
                mySlider(x = userData[34].toFloat(), y = 5f)
            } else {
                println("whole grain is male and score is: " + userData[33].toFloat())
                mySlider(x = userData[33].toFloat(), y = 5f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 5. Meat and Alternatives
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Meat and Alternatives",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("meat is female and score is: " + userData[37].toFloat())
                mySlider(x = userData[37].toFloat(), y = 10f)
            } else {
                println("meat is male and score is: " + userData[36].toFloat())
                mySlider(x = userData[36].toFloat(), y = 10f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 6. Dairy
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Dairy",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("dairy is female and score is: " + userData[41].toFloat())
                mySlider(x = userData[41].toFloat(), y = 10f)
            } else {
                println("dairy is male and score is: " + userData[40].toFloat())
                mySlider(x = userData[40].toFloat(), y = 10f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 7. Water
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Water",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("water is female and score is: " + userData[50].toFloat())
                mySlider(x = userData[50].toFloat(), y = 5f)
            } else {
                println("water is male and score is: " + userData[49].toFloat())
                mySlider(x = userData[49].toFloat(), y = 5f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 8. Unsaturated Fats
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Unsaturated Fats",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("unsaturated fats is female and score is: " + userData[61].toFloat())
                mySlider(x = userData[61].toFloat(), y = 5f)
            } else {
                println("unsaturated fats is male and score is: " + userData[60].toFloat())
                mySlider(x = userData[60].toFloat(), y = 5f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 9. Sodium
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Sodium",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("sodium is female and score is: " + userData[44].toFloat())
                mySlider(x = userData[44].toFloat(), y = 10f)
            } else {
                println("sodium is male and score is: " + userData[43].toFloat())
                mySlider(x = userData[43].toFloat(), y = 10f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 10. Sugar
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Sugar",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("sugar is female and score is: " + userData[55].toFloat())
                mySlider(x = userData[55].toFloat(), y = 10f)
            } else {
                println("sugar is male and score is: " + userData[54].toFloat())
                mySlider(x = userData[54].toFloat(), y = 10f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 11. Alcohol
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Alcohol",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("alc is female and score is: " + userData[47].toFloat())
                mySlider(x = userData[47].toFloat(), y = 5f)
            } else {
                println("alc is male and score is: " + userData[46].toFloat())
                mySlider(x = userData[46].toFloat(), y = 5f)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 12. Discretionary Foods
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Discretionary Foods",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            if (isFemale) {
                println("Discretionary Foods is female and score is: " + userData[6].toFloat())
                mySlider(x = userData[6].toFloat(), y = 10f)
            } else {
                println("Discretionary Foods is male and score is: " + userData[5].toFloat())
                mySlider(x = userData[5].toFloat(), y = 10f)
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        // Score
        Text(
            text = "Total Food Quality Score",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.padding(start = 15.dp)
        ){
            if (isFemale) {
                println("total score is female and score is: " + userData[4].toFloat())
                mySlider(x = userData[4].toFloat(), y = 100f)
            } else {
                println("total score is male and score is: " + userData[3].toFloat())
                mySlider(x = userData[3].toFloat(), y = 100f)
            }
        }

        Spacer(modifier = Modifier.height(35.dp))


        //Buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                // Intent to share text
                val shareIntent = Intent(ACTION_SEND)
                // Set the type of data to share
                shareIntent.type = "text/plain"
                // Set the data to share (the total score
                shareIntent.putExtra(Intent.EXTRA_TEXT, totalScoreMessage)
                // The
                mContext.startActivity(Intent.createChooser(shareIntent, "Share text via"))
            }) {
                Text(
                    text = "Share with Someone"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Build,
                    contentDescription = "Tool Icon",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Improve my diet!"
                )
            }
        }
    }
    }



@Preview(showBackground =  true)
@Composable
fun check() {
    val totalScoreMessage: String = "My total score is"
    val mContext = LocalContext.current
    val sharedPref = mContext.getSharedPreferences("Assignment1", Context.MODE_PRIVATE)
    val mID = sharedPref.getString("id", "")
    val userData = getDataByID(mContext, "data.csv", mID.toString())
//    println("user data id is: " + userData)
//    val isFemale = userData[2] == "Female"
//    println("isFemale"+ isFemale)

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text =  "Insights: Food Score",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp)
        }


        Spacer(modifier = Modifier.height(25.dp))

        /** Sliders
         *
         */
        // 1. Vegetables
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Vegetables",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))

                mySlider(x = 2f, y = 5f)

        }
        Spacer(modifier = Modifier.height(10.dp))

        // 2. Fruits
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Fruits",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 3. Grains and Cereals
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Grains and Cereals",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 4. Whole Grains
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Whole Grains",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 5. Meat and Alternatives
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Meat and Alternatives",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 6. Dairy
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Dairy",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 7. Water
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Water",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 8. Unsaturated Fats
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Unsaturated Fats",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 9. Sodium
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Sodium",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 10. Sugar
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Sugar",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 11. Alcohol
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Alcohol",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 12. Discretionary Foods
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Discretionary Foods",
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(0.3f).padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            mySlider(x = 2f, y = 5f)
        }

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Total Food Quality Score",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.padding(start = 15.dp)
        ){
            myProgressBar(x = 2f, y = 5f)
        }

        Spacer(modifier = Modifier.height(35.dp))

        //Buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                // Intent to share text
                val shareIntent = Intent(ACTION_SEND)
                // Set the type of data to share
                shareIntent.type = "text/plain"
                // Set the data to share (the total score
                shareIntent.putExtra(Intent.EXTRA_TEXT, totalScoreMessage)
                // The
                mContext.startActivity(Intent.createChooser(shareIntent, "Share text via"))
            }) {
                Text(
                    text = "Share with Someone"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Build,
                    contentDescription = "Tool Icon",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Improve my diet!"
                )
            }

            myProgressBar(1.4f,5f)
        }
    }
}

@Composable
fun mySlider(x: Float, y: Float) {
    // Variable to store the position of the slider
    val sliderPosition = x/y

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 20.dp)
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = {},
            valueRange = 0f..1f, // Always normalize between 0 and 1
            modifier = Modifier.weight(1f).height(10.dp),
            steps = 5,
            enabled = false,
//            colors = SliderDefaults.colors(
//                thumbColor = MaterialTheme.colorScheme.secondary,
//                activeTrackColor = MaterialTheme.colorScheme.secondary,
//                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
        )
        Spacer(modifier = Modifier.width(15.dp))

        // Print value over total on the side
        Text(text = "${(sliderPosition * y).toInt()}/${y.toInt()}",
            fontSize = 10.sp)
//        println("alternate : ${(String.format("%.2f", (sliderPosition * y)))}/${y.toInt()}")
    }
}

@Composable
fun myProgressBar(x: Float, y: Float){
    Row(modifier = Modifier.fillMaxWidth()){
        LinearProgressIndicator(
            progress = { x/y },
            color = Purple40,
            trackColor = Color.LightGray,
        )
        Spacer(modifier = Modifier.width(15.dp))
        // Print value over total on the side
        Text(text = "${x.toInt()}/${y.toInt()}",
            fontSize = 10.sp)
    }
}



/**
 * if (isFemale) {
 *                 println("total score is female and score is: " + userData[4].toFloat())
 *                 mySlider(x = userData[4].toFloat(), y = 100f)
 *             } else {
 *                 println("total score is male and score is: " + userData[3].toFloat())
 *                 mySlider(x = userData[3].toFloat(), y = 100f)
 *             }
 */

@Composable
fun calculateTotalScore(): String {
    val mContext = LocalContext.current
    val sharedPref = mContext.getSharedPreferences("Assignment1", Context.MODE_PRIVATE)
    val mID = sharedPref.getString("id", "")
    val userData = getDataByID(mContext, "data.csv", mID.toString())
    val isFemale = userData[2] == "Female"

    val x = if (isFemale) userData[4].toFloat() else userData[3].toFloat()

    return "${((x / 100) * 100).toInt()}/100"
}
//
//@Composable
//fun calculateTotalScore(){
//    val mContext = LocalContext.current
//    val sharedPref = mContext.getSharedPreferences("Assignment1", Context.MODE_PRIVATE)
//    val mID = sharedPref.getString("id", "")
//    val userData = getDataByID(mContext, "data.csv", mID.toString())
//    val isFemale = userData[2] == "Female"
//    var x: Float = 0f
//
//    if (isFemale) {
//        x = userData[4].toFloat()
//    } else {
//        x = userData[3].toFloat()
//    }
//
//    return "${((x / 100) * 100).toInt()}/100"
//    Text(text = "${((x / 100) * 100).toInt()}/100",
//        color = Color.Green,
//        fontWeight = FontWeight.Bold
//    )
////
//    val sharedPref2 = mContext.getSharedPreferences("Assignment1",
//        Context.MODE_PRIVATE).edit()
//
//    sharedPref2.putString("total score", "${((x / 100) * 100).toInt()}/100")
//    sharedPref2.apply()
//}

fun getDataByID(context: Context, fileName: String, ID: String): List<String> {
    val assets = context.assets
    var data: List<String> = emptyList()

    try {
        val inputStream = assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))

        reader.useLines { lines ->
            lines.drop(1).forEach { line -> // Drop the header
                val values = line.split(",")
                if (values[1] == ID) {
                    data = values
                    return@forEach
                }
            }
        }
    } catch (e:Exception) {
        e.printStackTrace()
    }
    return data
}

/**
 * fun readIDFromCSV(context: Context, fileName: String): List<String> {
 *     val ids = mutableListOf<String>()
 *     val assets = context.assets
 *
 *     try {
 *         val inputStream = assets.open(fileName)
 *         val reader = BufferedReader(InputStreamReader(inputStream))
 *
 *         reader.useLines { lines ->
 *             lines.drop(1).forEach { line -> // Drop the header
 *                 val values = line.split(",") // Read data per line seperated by comma
 *                 if (values.size > 1) {
 *                     val id = values[1]
 *                     ids.add(id)
 *                 }
 *             }
 *         }
 *     } catch (e: Exception) {
 *         e.printStackTrace()
 *     }
 *     return ids
 * }
 */
