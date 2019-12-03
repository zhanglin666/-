package cn.kc.trainman_apply.dispatchingcommand.fragment.view

import cn.kc.integrated_service.bean.InExecutionBeanIng


/**
 * 作者： Abel .
 * 日期：2019/8/14
 * 说明：
 */
open interface InExecutionIView {

    fun showDialog()

    fun hideDialog()

    fun showData(msg: ArrayList<InExecutionBeanIng.DataBean>)


}