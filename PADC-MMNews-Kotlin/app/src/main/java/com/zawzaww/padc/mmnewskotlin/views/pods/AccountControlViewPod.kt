package com.zawzaww.padc.mmnewskotlin.views.pods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import com.zawzaww.padc.mmnewskotlin.data.models.LoginUserModel
import com.zawzaww.padc.mmnewskotlin.delegates.BeforeLoginDelegate
import com.zawzaww.padc.mmnewskotlin.events.UserSessionEvent
import kotlinx.android.synthetic.main.view_pod_account_control.view.*

/**
 * Created by zawzaw on 07/08/2018.
 */

class AccountControlViewPod : FrameLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()

        if (LoginUserModel.getObjInstance().isUserLogin()) {
            displayLoginUser()

        } else {
            displayBeforeLogin()
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().isRegistered(this)
        }
    }

    fun setDelegate(delegate: BeforeLoginDelegate) {
        (vpBeforeLogin as BeforeLoginViewPod).setDelegate(delegate)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessLoginUser(event: UserSessionEvent.LoginUserSuccessEvent) {
        displayLoginUser()
    }

    private fun displayLoginUser() {
        vpLoginUser.visibility = View.VISIBLE
        vpBeforeLogin.visibility = View.GONE
    }

    private fun displayBeforeLogin() {
        vpBeforeLogin.visibility = View.VISIBLE
        vpLoginUser.visibility = View.GONE
    }
}