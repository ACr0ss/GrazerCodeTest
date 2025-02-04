package com.cross.grazercodetest.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.*

fun Long.toFormattedDate(): String {
    val date = Date(this * 1000L) // Convert seconds to milliseconds
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return format.format(date)
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

@Composable
fun getApplicationContext(): Context {
    return LocalContext.current.applicationContext
}