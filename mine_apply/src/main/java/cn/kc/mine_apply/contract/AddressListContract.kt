package cn.kc.mine_apply.contract

import cn.kc.mine_apply.bean.FirstBean
import cn.kc.moduleutils.base.BaseContract
import cn.kc.moduleutils.base.ResultCallback

/**
 * 作者： Abel .
 * 日期：2019/9/20
 * 说明：
 */
interface AddressListContract {
    interface Model : BaseContract.Model {
        /**
         * 获取联系人列表数据
         */
        fun getAddressList(uid: String, callback: ResultCallback<ArrayList<FirstBean>>)

        /**
         * 搜索联系人
         */
        fun getAddressListSelect(likeName: String, uid: String, callback:ResultCallback<ArrayList<FirstBean>>)

    }

    interface Presenter : BaseContract.Presenter {
        fun getAddressListSelect(likeName: String, uid: String)
        fun getAddressList(uid: String)
    }

    interface View : BaseContract.View {
        fun resultUserInfo(result: ArrayList<FirstBean>)
    }
}