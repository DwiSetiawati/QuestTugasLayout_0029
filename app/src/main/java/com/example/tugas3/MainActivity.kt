package com.example.tugas3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugas3.ui.theme.Tugas3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

private val profiles = listOf(
    ProfileData(
        name = R.string.name_Dwi,
        phone = R.string.phone_Dwi,
        address = R.string.address_Dwi,
        backgroundColor = R.color.card_gray,
        nameColor = R.color.text_white,
        phoneColor = R.color.text_phone_lightblue,
        addressColor = R.color.text_yellow,
        nameFont = FontFamily.Cursive
    ),
    ProfileData(
        name = R.string.name_Miranti,
        phone = R.string.phone_Miranti,
        address = R.string.address_Miranti,
        backgroundColor = R.color.card_purple,
        nameColor = R.color.text_white,
        phoneColor = R.color.text_phone_lightblue,
        addressColor = R.color.text_yellow
    ),
    ProfileData(
        name = R.string.name_Isna,
        phone = R.string.phone_Isna,
        address = R.string.address_Isna,
        backgroundColor = R.color.card_blue,
        nameColor = R.color.text_white,
        phoneColor = R.color.text_phone_sky,
        addressColor = R.color.text_white
    ),
    ProfileData(
        name = R.string.name_Riswanda,
        phone = R.string.phone_Riswanda,
        address = R.string.address_Riswanda,
        backgroundColor = R.color.card_green,
        nameColor = R.color.text_white,
        phoneColor = R.color.text_phone_aqua,
        addressColor = R.color.text_white
    )
)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.screen_padding)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(dimensionResource(R.dimen.title_top_space)))

        Text(
            text = stringResource(R.string.title),
            color = colorResource(R.color.text_title),
            fontSize = dimenSp(R.dimen.size_title),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.subtitle),
            color = colorResource(R.color.text_title),
            fontSize = dimenSp(R.dimen.size_subtitle),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(dimensionResource(R.dimen.section_space)))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.card_spacing))
        ) {
            profiles.forEach { ProfileCard(data = it) }
        }

        Text(
            text = stringResource(R.string.copyright),
            color = colorResource(R.color.text_title),
            fontSize = dimenSp(R.dimen.size_copyright)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Tugas3Theme { MainScreen() }
}