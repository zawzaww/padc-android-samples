package com.zawzaww.padc.mmnewskotlin.views.pods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.zawzaww.padc.mmnewskotlin.data.models.LoginUserModel
import kotlinx.android.synthetic.main.view_pod_login_user.view.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by zawzaw on 22/07/2018.
 */

class LoginUserViewPod : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()

        val loginUser = LoginUserModel.getObjInstance().loginUser()

        if (EventBus.getDefault().isRegistered(this)) {

        }

    }

}
