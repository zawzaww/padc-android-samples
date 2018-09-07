package com.zawzaww.padc.mmnewskotlin.views.pods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.zawzaww.padc.mmnewskotlin.data.models.LoginUserModel
import com.zawzaww.padc.mmnewskotlin.data.vos.LoginUserVO
import com.zawzaww.padc.mmnewskotlin.events.UserSessionEvent
import kotlinx.android.synthetic.main.view_pod_login_user.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by zawzaw on 22/07/2018.
 */

class LoginUserViewPod : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()

        val loginUser = LoginUserModel.getObjInstance().getLoginUser()
        if (loginUser != null) {
            displayLoginUser(loginUser)
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().isRegistered(this)
        }
    }

    private fun displayLoginUser(loginUser: LoginUserVO) {
        // User Name
        tvUserName.text = loginUser.name
        // User Phone No
        tvUserPhone.text = loginUser.phoneNo
        // Cover Photo
        Glide.with(context)
                .load(loginUser.coverUrl)
                .into(ivLoginUserBg)
        // User Profile Picture
        Glide.with(context)
                .load(loginUser.profileUrl)
                .into(ivLoginUserProfilePic)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessLoginUser(event: UserSessionEvent.LoginUserSuccessEvent) {
        displayLoginUser(event.loginUser)
    }

}
