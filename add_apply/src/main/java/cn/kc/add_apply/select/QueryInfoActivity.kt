package cn.kc.trainman_apply.reported_data.select

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kc.add_apply.R
import cn.kc.trainman_apply.reported_data.adapter.QueryInfoAdapter
import cn.kc.trainman_apply.reported_data.ui.ConductorInfoReportedActivity
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.util.Logs
import kotlinx.android.synthetic.main.activity_query_info.*

/**
 * 作者： Abel .
 * 日期：2019/9/5
 * 说明：信息查询显示列表
 */
class QueryInfoActivity : BaseActivity(), View.OnClickListener {

    lateinit var mRcyAdapter: QueryInfoAdapter
    private val mListData: ArrayList<String> = ArrayList()
    var mSelect: String? = null

    override fun getLayout() = R.layout.activity_query_info

    @SuppressLint("WrongConstant")
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mSelect = intent.getStringExtra("select")
        back_query_info.setOnClickListener { onBackPressed() }
        info_reported.setOnClickListener(this)
        mRcyAdapter = QueryInfoAdapter(this)
        mListData?.let { mRcyAdapter!!.setData(it) }
        rcy_query_info.adapter = mRcyAdapter
        rcy_query_info.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, false
            )
        )
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.info_reported -> {
                if (mSelect.equals("1")) {
                    goActivity(this, ConductorInfoReportedActivity().javaClass)
                }
                if (mSelect.equals("2")) {
                    goActivity(this, MotorcadeInfoReportedActivity().javaClass)
                }
                if (mSelect.equals("3")) {
                    goActivity(this, OfficeInfoReportedActivity().javaClass)
                }
                if (mSelect.equals("4")) {
                    goActivity(this, GroundServiceInfoReportedActivity().javaClass)
                }
            }
            else -> {
                Logs.e("else..")
            }
        }
    }
}