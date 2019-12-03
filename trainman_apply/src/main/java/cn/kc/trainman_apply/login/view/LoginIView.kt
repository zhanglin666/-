package cn.kc.trainman_apply.login.view

/**
 * 作者： Abel .
 * 日期：2019/6/6
 * 说明：
 */
open interface LoginIView {
    fun showDialog()

    fun hideDialog()

    fun showData(msg: String)

    fun goActivity()
}