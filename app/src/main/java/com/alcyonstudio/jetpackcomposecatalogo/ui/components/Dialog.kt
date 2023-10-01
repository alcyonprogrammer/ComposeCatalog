package com.alcyonstudio.jetpackcomposecatalogo.ui.components

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.alcyonstudio.jetpackcomposecatalogo.MyRadioButtonList
import com.alcyonstudio.jetpackcomposecatalogo.R


@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            )
            {
                var selected by remember {
                    mutableStateOf("")
                }
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(12.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                MyRadioButtonList(selected) { selected = it }
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(Modifier.align(End)) {
                    TextButton(onClick = { }) {
                        Text(text = "Cancel")

                    }
                    TextButton(onClick = { }) {
                        Text(text = "Ok")

                    }
                }
            }
        }
    }

}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            )
            {
                MyTitleDialog(text = "Titulo del listado")
                AccountItem(email = "Ejemplo1@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Ejemplo2@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Ejemplo3@gmail.com", drawable = R.drawable.add)
            }
        }
    }

}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            )
            {
                Text(text = "Un jemplo")
                Text(text = "Un jemplo")
                Text(text = "Un jemplo")
            }
        }
    }

}

@Composable
fun MyTitleDialog(
    text: String,
    modifier:Modifier = Modifier.padding(bottom = 12.dp)
) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(
    email: String,
    @DrawableRes drawable: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}


@Composable
fun MyDialog(
    show: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { /*TODO*/ },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola, son una descripcion sffddfsfdf ") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "confirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            }
        )
    }

}
