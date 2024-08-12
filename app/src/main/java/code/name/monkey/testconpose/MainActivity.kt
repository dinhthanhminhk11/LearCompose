package code.name.monkey.testconpose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import code.name.monkey.testconpose.ui.theme.TestConposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestConposeTheme {
                Surface(modifier = Modifier.fillMaxWidth()) { //  mở rộng hết cơ theo view cha vi du nhu đang view cha là row thì nó sẽ mở ộng thì chiều ngang
                    val listMessage = listOf<Message>(
                        Message(author = "Alice", body = "Hello, how are you?"),
                        Message(author = "Bob", body = "I'm good, thanks! How about you?"),
                        Message(author = "Charlie", body = "Hey everyone! What's up?"),
                        Message(
                            author = "Dave",
                            body = "Just finished a project, feeling great!Just finished a project, feeling great!Just finished a project, feeling great!Just finished a project, feeling great!Just finished a project, feeling great!Just finished a project, feeling great!Just finished a project, feeling great!"
                        ),
                        Message(author = "Eve", body = "Anyone up for a coffee break?"),
                        Message(author = "Frank", body = "Count me in!"),
                        Message(
                            author = "Grace",
                            body = "I'm working on a new app, pretty exciting!"
                        ),
                        Message(author = "Heidi", body = "What kind of app are you building?"),
                        Message(
                            author = "Ivan",
                            body = "It's a chat application with Kotlin and Compose."
                        ),
                        Message(
                            author = "Judy",
                            body = "Sounds cool! Let me know if you need any help."
                        )
                    )
                    Conversation(messages = listMessage)
                }
            }
        }
    }
}


@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(40.dp) // size
                .clip(CircleShape) // kieuer hinh tron
                .border(1.5.dp, MaterialTheme.colorScheme.primary)
        )

        var isExpanded by remember {// dunfg remember dder lu tru state
            mutableStateOf(false)
        }
        val surfaceColor by animateColorAsState(
            targetValue = if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = ""
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                modifier = Modifier
                    .animateContentSize()
                    .padding(all = 5.dp),
                color = surfaceColor, shadowElevation = 1.dp,
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(all = 4.dp)
                )
            }


        }
    }
}

@Preview(showBackground = true, name = "light mode")
@Composable
fun PreviewMessageCard() {
    TestConposeTheme {
        Surface(modifier = Modifier.fillMaxWidth()) { //"Surface" là một thành phần được sử dụng để bao bọc các thành phần khác và cung cấp một số tính năng tiện lợi như màu nền, góc bo tròn, độ cao (elevation), và nhiều hơn nữa. Nó giúp dễ dàng xác định các khối xây dựng cơ bản cho giao diện người dùng, đồng thời quản lý các yếu tố như đổ bóng và viền.
            val message = Message("minh", "holy shit")
            MessageCard(message)
        }
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCardDarkMode() {
    TestConposeTheme {
        Surface(modifier = Modifier.fillMaxWidth()) { //"Surface" là một thành phần được sử dụng để bao bọc các thành phần khác và cung cấp một số tính năng tiện lợi như màu nền, góc bo tròn, độ cao (elevation), và nhiều hơn nữa. Nó giúp dễ dàng xác định các khối xây dựng cơ bản cho giao diện người dùng, đồng thời quản lý các yếu tố như đổ bóng và viền.
            val message = Message("minh", "holy shit")
            MessageCard(message)
        }
    }
}


@Preview(name = "pre view list message", showBackground = true)
@Composable
fun PreviewListMessage() {
    TestConposeTheme {
        val listMessage = listOf<Message>(
            Message("minh", "body 1"),
            Message("minh", "body 1"),
            Message("minh", "body 1"),
            Message("minh", "body 1"),
            Message("minh", "body 1")
        )
        Conversation(messages = listMessage)
    }
}


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}


