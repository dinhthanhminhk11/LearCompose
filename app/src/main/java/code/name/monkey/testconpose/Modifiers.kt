package code.name.monkey.testconpose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import code.name.monkey.testconpose.ui.theme.TestConposeTheme


@Preview(showBackground = true)
@Composable
fun PreViewModifiers() {
    TestConposeTheme {
        Column {
            TextWidthPadding()
            WidthAndHeightModifier()
            SizeModifier()
            FillWidthModifier()
            FillHeightModifier()
            WeightModifier()
        }
    }
}


@Composable
fun TextWidthPadding() {
    // ddijt mej compose vcl thiet ke nhu con cu pading dau tien la margin pading thu 2 la pading dm
    Text(
        "Padding and margin!",
        Modifier
            .padding(32.dp) // Outer padding (margin)
            .background(color = Color.Green) //background color
            .padding(16.dp) // Inner padding
    )
}

@Composable
fun WidthAndHeightModifier() {
    Text(
        text = "Width and Height",
        color = Color.White,
        modifier = Modifier
            .background(Color.Blue)
            .width(200.dp)
            .height(300.dp)
    )
}

@Composable
fun SizeModifier() {
    Text(
        text = "Text with Size",
        color = Color.White,
        modifier = Modifier
            .background(Color.Cyan)
            .size(width = 250.dp, height = 100.dp)
    )
}

@Composable
fun FillWidthModifier() {
    Text(
        text = "Text Width Match Parent",
        color = Color.White,
        modifier = Modifier
            .background(Color.Gray)
            .padding(Dp(10f))
            .fillMaxWidth(1f)
    )
}

@Composable
fun FillHeightModifier() {
    Text(
        text = " Text with 75% Height ",
        color = Color.White,
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.75f) //75% area fill
    )
}

@Composable
fun WeightModifier() {
    Row() {
        Column(
            Modifier
                .weight(1f)
                .background(Color.Red)
        ) {
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            Modifier
                .weight(1f)
                .background(Color.Blue)
        ) {
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            Modifier
                .weight(2f)
                .background(Color.Green)
        ) {
            Text(text = "Weight = 2")
        }
    }
}