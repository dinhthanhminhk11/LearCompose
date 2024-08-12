package code.name.monkey.testconpose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import code.name.monkey.testconpose.ui.theme.TestConposeTheme


@Preview(showBackground = true)
@Composable
fun PreviewText() {
    TestConposeTheme {
        Column {
            val label = "Hello world"
            TextWithSize(label = label, size = 40.sp)
            ColorText()
            OverflowedText()
            SelectableText()
        }
    }
}


@Composable
fun TextWithSize(label: String, size: TextUnit) {
    Text(label, fontSize = size)
}

@Composable
fun ColorText() {
    Text("Color text", color = Color.Blue)
}

@Composable
fun BoldText() {
    Text("Bold text", fontWeight = FontWeight.Bold)
}

@Composable
fun ItalicText() {
    Text("Italic Text", fontStyle = FontStyle.Italic)
}

@Composable
fun MaxLines() {
    Text("hello ".repeat(50), maxLines = 2)
}

@Composable
fun OverflowedText() {
    Text(
        "Hello Compose ".repeat(50),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    ) // text quá dàiặt là ...
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}