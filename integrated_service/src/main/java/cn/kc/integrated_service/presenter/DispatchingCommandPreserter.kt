package cn.kc.trainman_apply.dispatchingcommand.presenter

import cn.kc.integrated_service.bean.CommandClassifyBean
import cn.kc.integrated_service.contract.CommandContract
import cn.kc.trainman_apply.dispatchingcommand.model.DispatchingCommandModel
import cn.kc.moduleutils.base.ResultCallback

/**
 * 作者： Abel .
 * 日期：2019/7/30
 * 说明：
 */
class DispatchingCommandPreserter(private val mView: CommandContract.View) : CommandContract.Presenter {

    private val mModel: DispatchingCommandModel

    init {
        mModel = DispatchingCommandModel()
    }

    override fun loadData() {
        mView.showProgressDialog()
        mModel.loadData(object : ResultCallback<CommandClassifyBean> {
            override fun onSuccess(result: CommandClassifyBean) {
                mView.dismissProgressDialog()
                mView.resultData(result)
            }

            override fun onFail(msg: String) {
                mView.dismissProgressDialog()
                mView.onFail(msg)
            }
        })
    }

    override fun onClear() {
        mModel.onClear()
    }

}