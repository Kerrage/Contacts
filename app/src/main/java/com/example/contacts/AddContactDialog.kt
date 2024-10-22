package com.example.contacts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        TextField(
            value = state.company,
            onValueChange = {
                onEvent(ContactEvent.SetCompany(it))
            },
            placeholder = {
                Text(text = "Company")
            }
        )
        CheckboxMinimalExample(state)
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

@Composable
fun CheckboxMinimalExample(state: ContactState) {
    var checked by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Minimal checkbox"
        )
        Checkbox(
            checked = state.hasCompany,
            onCheckedChange = { state.hasCompany = it }
        )
    }

    Text(
        if (checked) "Checkbox is checked" else "Checkbox is unchecked"
    )
}