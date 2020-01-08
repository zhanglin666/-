package cn.kc.add_apply

import android.view.View
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.util.Logs
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * 作者： Abel .
 * 日期：2019/10/12
 * 说明：添乘页面
 */
@Route(path = "/addapply/addapplyfragment")
class AddAApplyFragment : BaseFragment() {

    override fun getLayout() = R.layout.fragment_adda_apply

    override fun initData() {
        Logs.e("测试添乘页面")
    }

}