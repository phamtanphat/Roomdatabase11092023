package com.example.roomdatabase11092023.util

import android.content.Context
import android.graphics.drawable.Drawable
import com.example.roomdatabase11092023.R
import com.example.roomdatabase11092023.common.AppCommon
import com.example.roomdatabase11092023.data.database.enity.StatusEnum

object StatusUtil {

    fun getNameStatus(ordinal: Int): String {
        return when (ordinal - 1) {
            StatusEnum.START.ordinal -> StatusEnum.START.name
            StatusEnum.PROGRESS.ordinal -> StatusEnum.PROGRESS.name
            else -> StatusEnum.DONE.name
        }
    }
}