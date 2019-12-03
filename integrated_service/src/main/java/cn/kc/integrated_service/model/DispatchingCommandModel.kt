package cn.kc.trainman_apply.dispatchingcommand.model

import cn.kc.integrated_service.CommandApi
import cn.kc.integrated_service.bean.CommandClassifyBean
import cn.kc.integrated_service.contract.CommandContract
import cn.kc.moduleutils.base.ResultCallback
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/7/30
 * 说明：
 */
class DispatchingCommandModel : CommandContract.Model {
    val mDisposables = CompositeDisposable()
    override fun loadData(callback: ResultCallback<CommandClassifyBean>) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDisposables.add(
            RetrofitUtils.instance.getApiServier(CommandApi::class.java)
                .getCommand()
                .subscribeOn(Schedulers.io())
                .map {
                    if (it.state==1){
                        return@map it
                    }else{
                        throw Throwable("")
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        callback.onSuccess(it)
                    },
                    {
                        callback.onFail("请求失败")
                    }
                )
        )
    }

    override fun onClear() {
        mDisposables.clear()
    }

}