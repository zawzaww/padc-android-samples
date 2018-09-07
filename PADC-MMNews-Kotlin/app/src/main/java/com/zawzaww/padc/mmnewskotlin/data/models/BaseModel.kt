package com.zawzaww.padc.mmnewskotlin.data.models

import org.greenrobot.eventbus.EventBus

/**
 * Created by zawzaw on 05/08/2018.
 */

open class BaseModel {

    fun onEvent(event: Any?) {

    }

    init {
        EventBus.getDefault().register(this)
    }

}