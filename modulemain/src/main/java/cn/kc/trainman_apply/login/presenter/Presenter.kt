package cn.kc.trainman_apply.login.presenter

import cn.kc.trainman_apply.ResultEnum
import cn.kc.trainman_apply.login.contract.LoginContract
import cn.kc.trainman_apply.login.model.LoginModel
import cn.kc.trainman_apply.login.view.LoginIView
import cn.kc.moduleutils.base.BaseApplication
import cn.kc.moduleutils.util.ToastUtil

/**
 * 作者： Abel .
 * 日期：2019/6/6
 * 说明：
 */
class Presenter(private val mView: LoginIView) : LoginContract.Presenter, LoginModel.UpdateView {

    override fun onCreate() {
    }

    override fun onDestroy() {
//        ToastUtil.hideToast()
    }

    private val mModel: LoginModel

    init {
        mModel = LoginModel()
    }

    override fun loadData(username: String, password: String) {
        mView.showDialog()
        mModel.login(username, password, this)
    }

    override fun updateView(resultEnum: ResultEnum) {
        when (resultEnum) {
            ResultEnum.SUCCESS -> {
                mView.hideDialog()
                mView.goActivity()
                ToastUtil.showToast(BaseApplication.mContext!!, "登录成功")
            }
            ResultEnum.FAILED -> {
                mView.hideDialog()
            }
            else -> {
                mView.hideDialog()
                ToastUtil.showToast(BaseApplication.mContext!!, "连接服务器失败")
            }
        }
    }

    override fun onClear() {
        mModel.onClear()
    }
}
