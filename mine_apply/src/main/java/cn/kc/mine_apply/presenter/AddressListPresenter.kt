package cn.kc.trainman_apply.addresslist.presenter

import cn.kc.mine_apply.bean.FirstBean
import cn.kc.mine_apply.contract.AddressListContract
import cn.kc.trainman_apply.addresslist.model.AddressListModel
import cn.kc.moduleutils.base.ResultCallback

/**
 * 作者： Abel .
 * 日期：2019/8/2
 * 说明：
 */
class AddressListPresenter(private val mView: AddressListContract.View) : AddressListContract.Presenter {
    private val mModel: AddressListContract.Model

    init {
        mModel = AddressListModel()
    }

    override fun getAddressListSelect(likeName: String, uid: String) {
        mView.showProgressDialog()
        mModel.getAddressListSelect(likeName, uid,object : ResultCallback<ArrayList<FirstBean>>{
            override fun onSuccess(result: ArrayList<FirstBean>) {
                mView.dismissProgressDialog()
                mView.resultUserInfo(result)
            }

            override fun onFail(msg: String) {
                mView.dismissProgressDialog()
                mView.onFail(msg)
            }
        } )
    }

    override fun getAddressList(uid: String) {
        mView.showProgressDialog()
        mModel.getAddressList(uid, object : ResultCallback<ArrayList<FirstBean>> {
            override fun onSuccess(result: ArrayList<FirstBean>) {
                mView.dismissProgressDialog()
                mView.resultUserInfo(result)
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

