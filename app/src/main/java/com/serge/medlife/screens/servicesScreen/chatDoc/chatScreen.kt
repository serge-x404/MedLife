package com.serge.medlife.screens.servicesScreen.chatDoc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

data class ChatMessage(
    val message: String,
    val isUser: Boolean
)

@Composable
fun ChatScreen() {
    var userInput by remember { mutableStateOf("") }
    var chatList by remember { mutableStateOf<List<ChatMessage>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(chatList) {chat ->
                ChatBubble(chat)
            }
        }

        if (isLoading) {
            Text(
                "Typing...",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = userInput,
                onValueChange = {userInput = it},
                placeholder = {Text("Ask me anything..")},
                modifier = Modifier.weight(1f),
                maxLines = 3,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(
                    onSend = {
                        if (userInput.isBlank()) return@KeyboardActions
                        val message = userInput
                        userInput = ""
                        chatList = chatList + ChatMessage(message, isUser = true)
                        isLoading = true
                        scope.launch {
                            val response = GeminiClient.sendMessage(message)
                            chatList = chatList + ChatMessage(response, isUser = false)
                            isLoading = false
                            listState.animateScrollToItem(chatList.size-1)
                        }
                    }
                )
            )
            Spacer(Modifier.width(8.dp))
            IconButton(
                onClick = {
                    if (userInput.isBlank()) return@IconButton
                    val message = userInput
                    userInput = ""
                    chatList = chatList + ChatMessage(message, isUser = true)
                    isLoading = true
                    scope.launch {
                        val response = GeminiClient.sendMessage(message)
                        chatList = chatList + ChatMessage(response, isUser = false)
                        isLoading = false
                        listState.animateScrollToItem(chatList.size-1)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}


@Composable
fun ChatBubble(chat: ChatMessage) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = if (chat.isUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = if (chat.isUser) 16.dp else 0.dp,
                        bottomEnd = if (chat.isUser) 0.dp else 16.dp
                    )
                )
                .background(
                    if (chat.isUser) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.surfaceContainerHighest
                )
                .padding(20.dp)
                .widthIn(max = 280.dp)
        ) {
            Text(
                chat.message,
                color = if (chat.isUser) MaterialTheme.colorScheme.onPrimary
                        else MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}