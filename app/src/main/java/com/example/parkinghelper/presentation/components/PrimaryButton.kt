package com.example.parkinghelper.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme

@Composable
fun PrimaryButton(
    text: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 13.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.background,
            disabledContentColor = MaterialTheme.colorScheme.background
        )
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun PrimaryButtonPreviewLight() {
    ParkingHelperTheme(dynamicColor = false) {
        PrimaryButton(
            text = "Hello",
            enabled = true,
            onClick = {},
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PrimaryButtonPreviewDark() {
    ParkingHelperTheme(dynamicColor = false) {
        PrimaryButton(
            text = "Hello",
            enabled = true,
            onClick = {},
        )
    }
}
