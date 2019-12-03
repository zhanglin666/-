package cn.kc.trainman_apply.dispatchingcommand.view

import cn.kc.integrated_service.bean.CommandClassifyBean


/**
 * 作者： Abel .
 * 日期：2019/7/30
 * 说明：
 */
open interface DispatchingCommandIView {
    fun showDialog()

    fun hideDialog()

    fun showData(msg: CommandClassifyBean)
}