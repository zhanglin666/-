package cn.kc.trainman_apply.login.model

import cn.kc.trainman_apply.Api
import cn.kc.trainman_apply.ResultEnum
import cn.kc.trainman_apply.login.contract.LoginContract
import cn.kc.moduleutils.base.BaseApplication
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import cn.kc.moduleutils.util.ToastUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginModel : LoginContract.Model {

    private var mDis: CompositeDisposable = CompositeDisposable()

    override fun login(username: String, password: String, callback: UpdateView) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(Api::class.java)
                .login(username, password)
                .subscribeOn(Schedulers.io())
                .map {
                    if (it.state.equals("1")) {
                        return@map it
                    } else {
                        val resultEnum = ResultEnum.ERROR
                        callback.updateView(resultEnum)
                        throw Throwable("")
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    BaseApplication.preferences.UID = username
                    BaseApplication.preferences.real_name = it.data.get(0).reaL_NAME
                    BaseApplication.preferences.employee_code_sbno = it.data.get(0).employeE_CODE_SBNO
                    val resultEnum = ResultEnum.SUCCESS
                    callback.updateView(resultEnum)
                }, {
                    BaseApplication.mContext?.let { it1 -> ToastUtil.showToast(it1, it.message.toString()) }
                    val resultEnum = ResultEnum.FAILED
                    callback.updateView(resultEnum)
                })
        )
    }

    override fun onClear() {
        mDis.clear()
    }

    interface UpdateView {
        fun updateView(resultEnum: ResultEnum)
    }
}
