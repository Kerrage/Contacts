package com.example.contacts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlertContent(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = state.firstName,
            onValueChange = {
                onEvent(ContactEvent.SetFirstName(it))
            },
            placeholder = {
                Text(text = "First Name")
            }
        )
        TextField(
            value = state.lastName,
            onValueChange = {
                onEvent(ContactEvent.SetLastName(it))
            },
            placeholder = {
                Text(text = "Last Name")
            }
        )
        TextField(
            value = state.phoneNumber,
            onValueChange = {
                onEvent(ContactEvent.SetPhoneNumber(it))
            },
            placeholder = {
                Text(text = "Phone Number")
            }
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(onClick = {
                onEvent(ContactEvent.SaveContact)
            }) {
                Text(text = "Save contact")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BasicAlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        },
        content = @Composable {
            AlertContent(state, onEvent)
        }
    )
}
