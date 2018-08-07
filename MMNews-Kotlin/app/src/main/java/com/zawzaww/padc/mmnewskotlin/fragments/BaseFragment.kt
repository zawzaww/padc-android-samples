package com.zawzaww.padc.mmnewskotlin.fragments

import android.app.AlertDialog
import android.support.v4.app.Fragment
import com.zawzaww.padc.mmnewskotlin.events.ErrorEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by zawzaw on 22/07/2018.
 */

open class BaseFragment : Fragment() {

    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun onStop() {
        super.onStop()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onApiErrorEvnet(event: ErrorEvent.ApiErrorEvent) {

    }

    private fun showErrorMessage(errorMessage: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error in Network Call")
                .setMessage(errorMessage)
                .setCancelable(false)
        val dialog = builder.create()
        dialog.show()

    }

}