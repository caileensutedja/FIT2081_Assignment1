package com.fit2081.fit2081_a1_caileen_34375783

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.fit2081.fit2081_a1_caileen_34375783.ui.theme.FIT2081_A1_Caileen_34375783Theme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FIT2081_A1_Caileen_34375783Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePage()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePage() {
    val mContext = LocalContext.current

    Column {
        Button (onClick = {
//            val sharedPref = mContext.getSharedPreferences("Assignment1", Context.MODE_PRIVATE)
//
//            val loadedFruit = sharedPref.getBoolean("fruits", false)
//            val loadedVegetables = sharedPref.getBoolean("vegetables", false)
//            val loadedGrains = sharedPref.getBoolean("grains", false)
//            val loadedRedMeat = sharedPref.getBoolean("redMeat", false)
//            val loadedSeafood = sharedPref.getBoolean("seafood", false)
//            val loadedPoultry = sharedPref.getBoolean("poultry", false)
//            val loadedFish = sharedPref.getBoolean("fish", false)
//            val loadedEggs = sharedPref.getBoolean("eggs", false)
//            val loadedNutsSeeds = sharedPref.getBoolean("nutsSeeds", false)
//
//            val loadedPersona = sharedPref.getString("persona", "")
//
//            val loadedTimeMeal = sharedPref.getString("timeMeal", "12:00")
//            val loadedTimeSleep = sharedPref.getString("timeSleep", "12:00")
//            val loadedTimeWakeUp = sharedPref.getString("timeWakeUp", "12:00")
//
//            mCheckBoxFruits.value = loadedFruit
//            mCheckBoxVegetables.value = loadedVegetables
//            mCheckBoxGrains.value = loadedGrains
//            mCheckBoxRedMeat.value = loadedRedMeat
//            mCheckBoxSeafood.value = loadedSeafood
//            mCheckBoxPoultry.value = loadedPoultry
//            mCheckBoxFish.value = loadedFish
//            mCheckBoxEggs.value = loadedEggs
//            mCheckBoxNutsSeeds.value = loadedNutsSeeds
            mContext.startActivity(Intent(mContext, QuestionnairePage::class.java))

        }){
            Text(text = "Edit")
        }
    }
}