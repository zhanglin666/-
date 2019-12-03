package cn.kc.trainman_apply.dispatchingcommand.fragment.view

import cn.kc.integrated_service.bean.HadDoneBean


/**
 * 作者： Abel .
 * 日期：2019/9/4
 * 说明：
 */
open interface HadDoneView {
    fun showDialog()

    fun hideDialog()

    fun showData(msg: ArrayList<HadDoneBean.DataBean>)

}