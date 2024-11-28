package com.example.parkinghelper.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme

@Composable
fun SecondaryButton(
    text: String,
    enabled: Boolean,
    buttonColor: Color = MaterialTheme.colorScheme.secondary,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 13.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = buttonColor,
            disabledContentColor = buttonColor.copy(alpha = 0.5f)
        ),
        border = BorderStroke(width = 1.dp, color = buttonColor)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun SecondaryButtonPreviewLight() {
    ParkingHelperTheme(dynamicColor = false) {
        SecondaryButton(
            text = "Hello",
            enabled = true,
            onClick = {},
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SecondaryButtonPreviewDark() {
    ParkingHelperTheme(dynamicColor = false) {
        SecondaryButton(
            text = "Hello",
            enabled = true,
            onClick = {},
        )
    }
}
