package com.bogdanovshumila.grade_clicker_bogdanov_shumila

import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bogdanovshumila.grade_clicker_bogdanov_shumila.model.Grade
import com.bogdanovshumila.grade_clicker_bogdanov_shumila.ui.theme.GradeClickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GradeClickerTheme {
            }
        }
    }
}

@Composable
fun GradeClickerApp(grade: List<Grade>){
    var points by remember { mutableStateOf(0) }
    var clicks by remember { mutableStateOf(0) }
    var currentGrade = determineGradeToShow(grade,points)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Заголовок
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        //Изображение(кликабельное)
        Image(
            painter = painterResource(currentGrade.imageId),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
                .clickable{
                    points += currentGrade.pointsPerClick
                    clicks++
                },
            contentScale = ContentScale.Fit
        )

        // Информация
        TransactionInfo(
            points = points,
            clicks = clicks)

    }
}

@Composable
fun TransactionInfo(x0: Any) {
    TODO("Not yet implemented")
}

fun determineGradeToShow(grades: List<Grade>,
                         points: Int): Grade {
    var gradeToShow = grades.first()
    for (grade in grades) {
        if (points >= grade.threshold) {
            gradeToShow = grade
        } else {
            break
        }
    }
    return gradeToShow
}
