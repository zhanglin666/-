package cn.kc.mine_apply

import android.content.Intent
import android.view.View
import cn.kc.mine_apply.text.FragmentActivity
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.util.Logs
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.fragment_mine_apply.*

/**
 * 作者： Abel .
 * 日期：2019/10/25
 * 说明：我的应用
 */

@Route(path = "/modulemine/mineapplyfragment")
class MineApplyFragment : BaseFragment(){

    override fun getLayout()= R.layout.fragment_mine_apply

    override fun initData() {
        btn_click.setOnClickListener {
            var intent=Intent()
            intent.setClass(activity,FragmentActivity::class.java)
            startActivity(intent)
        }
    }

}