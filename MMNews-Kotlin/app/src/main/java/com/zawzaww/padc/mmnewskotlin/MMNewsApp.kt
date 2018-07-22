package com.zawzaww.padc.mmnewskotlin

import android.app.Application
import com.zawzaww.padc.mmnewskotlin.data.models.NewsAppModel

class MMNewsApp : Application() {

    companion object {
        const val TAG = "MMNewsApp"
    }

    override fun onCreate() {
        super.onCreate()
    }
}