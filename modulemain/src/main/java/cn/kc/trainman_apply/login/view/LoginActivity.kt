package cn.kc.trainman_apply.login.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.CompoundButton
import cn.kc.trainman_apply.R
import cn.kc.trainman_apply.login.contract.LoginContract
import cn.kc.trainman_apply.login.presenter.Presenter
import cn.kc.trainman_apply.main.MainActivity
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.base.BaseApplication.Companion.preferences
import cn.kc.moduleutils.util.Logs
import cn.kc.moduleutils.util.ToastUtil
import cn.kc.moduleutils.view.WeiboDialogUtils
import kotlinx.android.synthetic.main.act_login.*

class LoginActivity : BaseActivity(), View.OnClickListener, LoginIView, CompoundButton.OnCheckedChangeListener {

    lateinit var mPresenter: LoginContract.Presenter
    var mDialog: Dialog? = null

    override fun getLayout() = R.layout.act_login

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mPresenter = Presenter(this)
        getLifecycle().addObserver(mPresenter)
        btn_login.setOnClickListener(this)
        login_txt_server.setOnClickListener(this)
        address.setInputType(InputType.TYPE_NULL)   //禁止键盘输入
        address.setTransformationMethod(PasswordTransformationMethod.getInstance())  //输入框内容不可见
        cb_address.setOnCheckedChangeListener(this)
    }

    override fun showDialog() {
        mDialog = WeiboDialogUtils.createLoadingDialog(this, resources.getString(R.string.loging))
    }

    override fun hideDialog() {
        WeiboDialogUtils.closeDialog(mDialog)
    }

    override fun showData(msg: String) {
    }

    override fun goActivity() {
        val intent = Intent()
        intent.setClass(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (isChecked) {
            address.setInputType(InputType.TYPE_CLASS_TEXT)// 允许键盘输入
            address.setTransformationMethod(HideReturnsTransformationMethod.getInstance())//密码可见
            cb_address.setBackgroundResource(R.mipmap.mark)
        } else {
            address.setInputType(InputType.TYPE_NULL)//禁止键盘输入
            address.setTransformationMethod(PasswordTransformationMethod.getInstance())//密码不可见
            cb_address.setBackgroundResource(R.mipmap.ic_save)
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_login -> {
//                if (user_name.text.length == 0 || user_name.text.equals(null)) {
//                    ToastUtil.showToast(this, resources.getString(R.string.edit_user))
//                    return
//                }
//                if (pass_word.text.length == 0 || user_name.text.equals(null)) {
//                    ToastUtil.showToast(this, resources.getString(R.string.edit_password))
//                    return
//                }
                if (!address.text.toString().equals(null) || address.text.toString().length != 0) {
                    preferences?.server_address = address.text.toString()
                } else {
                    ToastUtil.showToast(this, resources.getString(R.string.server_address))
                    return
                }
                mPresenter!!.loadData("245400", "245400")
//                mPresenter!!.loadData(user_name.text.toString(), pass_word.text.toString())
            }
            R.id.login_txt_server->{
                ll_service.visibility=View.VISIBLE
            }
            else -> {
                Logs.e("onclick error")
            }
        }
    }
}