package code.name.monkey.testconpose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import code.name.monkey.testconpose.ui.theme.TestConposeTheme


@Preview(showBackground = true)
@Composable
fun PreviewTestStyle() {
    TestConposeTheme {
        Column {
            val lable: String = "Hello world"
            simpleTextStyle(lable = lable)
            TextColor()
            TextBackGroundColor()
            textFontFamily()
            textFontStyle()
            TextShadow()
        }

    }
}

@Composable
fun simpleTextStyle(lable: String) {
    Text(
        text = lable,
        style = TextStyle(
            color = Color.Red,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W800,
            fontStyle = FontStyle.Italic,
            letterSpacing = 0.5.em,
            background = Color.LightGray,
            textDecoration = TextDecoration.Underline
        )
    )
}

@Composable
fun TextColor() {
    Text(
        text = "Text with Color",
        style = TextStyle(color = Color.Red)
    )
}

@Composable
fun TextBackGroundColor() {
    Text(
        text = "Text with Background Color",
        style = TextStyle(background = Color.Yellow)
    )
}

@Composable
fun TextShadow() {
    Text(
        text = "Text with Shadow",
        style = TextStyle(
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(5f, 5f),
                blurRadius = 5f
            )
        )
    )
}

@Composable
fun textFontFamily() {
    Text(
        text = "Text with custom font",
        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive)
    )
}

@Composable
fun textFontSize() {
    Text(
        text = "Text with big font size",
        style = TextStyle(fontSize = 30.sp)
    )
}

@Composable
fun textFontStyle() {
    Text(
        text = "Text with Italic text",
        style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic)
    )
}