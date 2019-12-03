package cn.kc.trainman_apply.reported_data

import android.content.Intent
import android.os.Bundle
import android.view.View
import cn.kc.add_apply.R
import cn.kc.trainman_apply.reported_data.select.QueryInfoActivity
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.util.Logs
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.act_selectuser_reported.*

/**
 * 作者： Abel .
 * 日期：2019/9/9
 * 说明：选择上报人
 */

@Route(path = "/module_reported_data/select_user_reported")
class SelectUserReportedActivity : BaseActivity(), View.OnClickListener {

    override fun getLayout() = R.layout.act_selectuser_reported

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        liechezhang_shangbao.setOnClickListener(this)
        chedui_shangbao.setOnClickListener(this)
        jiguan_shangbao.setOnClickListener(this)
        diqin_shangbao.setOnClickListener(this)
        back_info_select_reported.setOnClickListener { finish() }
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, QueryInfoActivity::class.java)
        when (v!!.id) {
            R.id.liechezhang_shangbao -> {
                intent.putExtra("select", "1")
            }
            R.id.chedui_shangbao -> {
                intent.putExtra("select", "2")
            }
            R.id.jiguan_shangbao -> {
                intent.putExtra("select", "3")
            }
            R.id.diqin_shangbao -> {
                intent.putExtra("select", "4")
            }
            else -> {
                Logs.e("else..")
            }
        }
        startActivity(intent)
    }
}