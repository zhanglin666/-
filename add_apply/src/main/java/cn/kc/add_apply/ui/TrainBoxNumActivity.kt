package cn.kc.trainman_apply.reported_data.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.trainman_apply.reported_data.adapter.TrainBoxNumAdapter
import cn.kc.moduleutils.base.BaseActivity
import kotlinx.android.synthetic.main.act_responsibledepartment.*

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class TrainBoxNumActivity : BaseActivity() {
    lateinit var mAdapter: TrainBoxNumAdapter
    val dataList: ArrayList<String> = ArrayList()

    override fun getLayout() = R.layout.act_responsibledepartment

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        txt_title_rd.setText("选择车厢号")
        back_respon_department.setOnClickListener { onBackPressed() }
        initRecycleView()
    }

    override fun initData() {
        super.initData()
        for (i in 1 until 20) {
            dataList.add("" + i + "号车厢")
        }
        dataList.add("加1号车厢")
        dataList.add("加2号车厢")

        mAdapter.getItemClickListener(object : TrainBoxNumAdapter.ItemClickListener {
            override fun getItemContent(position: Int) {
                val intent = Intent()
                intent.putExtra("trainNum", dataList.get(position))
                setResult(7, intent)
                finish()
            }
        })
    }

    fun initRecycleView() {
        mAdapter = TrainBoxNumAdapter(this)
        mAdapter.setData(dataList)
        recycle_view_rd.adapter = mAdapter
        recycle_view_rd.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL, false
        )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent()
        intent.putExtra("trainNum", "")
        setResult(7, intent)
        finish()
    }

}