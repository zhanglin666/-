package cn.kc.integrated_service.contract

import cn.kc.integrated_service.bean.CommandClassifyBean
import cn.kc.moduleutils.base.BaseContract
import cn.kc.moduleutils.base.ResultCallback

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
interface CommandContract{
    interface Model:BaseContract.Model{
        fun loadData(callback: ResultCallback<CommandClassifyBean>)
    }

    interface View:BaseContract.View{
        fun resultData(result: CommandClassifyBean)
    }

    interface Presenter:BaseContract.Presenter{
        fun loadData()
    }
}