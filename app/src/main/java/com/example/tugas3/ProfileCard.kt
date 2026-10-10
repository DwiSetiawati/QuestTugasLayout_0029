package com.example.tugas3

import androidx.annotation.DimenRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun dimenSp(@DimenRes id: Int): TextUnit = dimensionResource(id).value.sp

@Composable
private fun CardLogo() {
    Image(
        painter = painterResource(id = R.drawable.logo_umy),
        contentDescription = stringResource(R.string.logo_description),
        modifier = Modifier.size(dimensionResource(R.dimen.logo_size))
    )
}

@Composable
fun ProfileCard(
    data: ProfileData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(data.backgroundColor)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.card_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CardLogo()

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = dimensionResource(R.dimen.text_horizontal_padding))
            ) {
                Text(
                    text = stringResource(data.name),
                    color = colorResource(data.nameColor),
                    fontSize = dimenSp(R.dimen.size_name),
                    fontWeight = FontWeight.Bold,
                    fontFamily = data.nameFont
                )

                // Safe call: nomor HP hanya tampil jika tidak null
                data.phone?.let { phoneRes ->
                    Spacer(Modifier.height(dimensionResource(R.dimen.text_gap)))
                    Text(
                        text = stringResource(phoneRes),
                        color = colorResource(data.phoneColor),
                        fontSize = dimenSp(R.dimen.size_detail)
                    )
                }

                Spacer(Modifier.height(dimensionResource(R.dimen.text_gap)))
                Text(
                    text = stringResource(data.address),
                    color = colorResource(data.addressColor),
                    fontSize = dimenSp(R.dimen.size_detail)
                )
            }

            CardLogo()
        }
    }
}