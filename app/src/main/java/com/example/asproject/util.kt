package com.example.asproject

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.asproject.database.Goods
import java.text.SimpleDateFormat
import java.util.*

fun formatGoods(list: List<Goods>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("Data:")

        list.forEach {
            append("<br>")
            append(it.code + " | " + it.name + " - " + it.count.toString() + " - " + getDateTime(it.date_of_changed))
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

fun getDateTime(s: Long): String? {
    try {
        val sdf = SimpleDateFormat("HH:mm dd/MM/yyyy ")
        val netDate = Date(s)
        return sdf.format(netDate)
    } catch (e: Exception) {
        return e.toString()
    }
}