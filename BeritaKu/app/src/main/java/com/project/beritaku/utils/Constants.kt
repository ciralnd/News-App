package com.project.beritaku.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

object Constants {
    @SuppressLint("SimpleDateFormat")
    fun dateTimeConverter(publishedAt: String?): String {
        val formatted: String

        if (publishedAt == null) {
            formatted = "[Date can't be formatted]"
        } else {
            val inputDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val outputDate = SimpleDateFormat("h:mm a, d MMM")
            val d = inputDate.parse(publishedAt)
            formatted = outputDate.format(d)
        }

        return formatted
    }
}