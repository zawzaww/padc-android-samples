package com.zawzaww.padc.mmnewskotlin.views.pods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.zawzaww.padc.mmnewskotlin.data.models.LoginUserModel
import com.zawzaww.padc.mmnewskotlin.delegates.BeforeLoginDelegate
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
            vpLoginUser.visibility = View.VISIBLE
            vpBeforeLogin.visibility = View.GONE
        } else {
            vpBeforeLogin.visibility = View.VISIBLE
            vpLoginUser.visibility = View.GONE
        }
    }

    fun setDelegate(delegate: BeforeLoginDelegate) {
        (vpBeforeLogin as BeforeLoginViewPod).setDelegate(delegate)
    }

}