package cn.kc.integrated_service

import android.view.View
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.util.Logs
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * 作者： Abel .
 * 日期：2019/10/12
 * 说明：综合业务应用
 */
@Route(path = "/integratedservice/integratedserviceapplyfragment")
class IntegratedServiceApplyFragment : BaseFragment() {

    override fun getLayout() = R.layout.fragment_integratedservice_apply
    override fun initData() {
        Logs.e("测试综合业务应用")
    }
}