package cn.kc.trainman_apply.dispatchingcommand.fragment.view

import cn.kc.integrated_service.bean.NoReceiveBean


/**
 * 作者： Abel .
 * 日期：2019/8/13
 * 说明：
 */
open interface NoReceiveIView {

    fun showDialog()

    fun hideDialog()

    fun showData(msg: ArrayList<NoReceiveBean.DataBean>)

    fun commandSuccess()
}