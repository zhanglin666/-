package cn.kc.trainman_apply.reported_data.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.add_apply.bean.TimSort
import cn.kc.trainman_apply.reported_data.adapter.TimSortAdapter
import cn.kc.trainman_apply.reported_data.model.TimSortModel
import cn.kc.moduleutils.base.BaseActivity
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.act_responsibledepartment.*

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：添乘类别
 */
class TimSortActivity :BaseActivity(){
    var mModel: TimSortModel? = null
    lateinit var mAdapter: TimSortAdapter
    val dataList: ArrayList<TimSort.DataBean> = ArrayList()

    override fun getLayout() = R.layout.act_responsibledepartment

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        txt_title_rd.setText("检查类别")
        back_respon_department.setOnClickListener { onBackPressed() }
        initRecycleView()
    }

    override fun initData() {
        super.initData()
        mModel = TimSortModel()
        refreshOrLoad()
        refreshLayout_responsible_depart.autoRefresh()

        mAdapter.getItemClickListener(object : TimSortAdapter.ItemClickListener {
            override fun getItemContent(position: Int) {
                val intent = Intent()
                intent.putExtra("timSortName", dataList.get(position).name)
                setResult(6, intent)
                finish()
            }
        })
    }

    fun initRecycleView() {
        mAdapter = TimSortAdapter(this)
        mAdapter.setData(dataList)
        recycle_view_rd.adapter = mAdapter
        recycle_view_rd.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL, false
        )
    }

    fun refreshOrLoad() {
        refreshLayout_responsible_depart.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                refreshLayout_responsible_depart.finishLoadMore(1000)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                mModel!!.getTimSort(object : TimSortModel.UpdateView {
                    override fun success(data: ArrayList<TimSort.DataBean>) {
                        no_data.visibility = View.GONE
                        recycle_view_rd.visibility=View.VISIBLE
                        dataList.clear()
                        dataList.addAll(data)
                        mAdapter.setData(dataList)
                        mAdapter.notifyDataSetChanged()
                        refreshLayout_responsible_depart.finishRefresh()
                    }

                    override fun error() {
                        refreshLayout_responsible_depart.finishRefresh(1000)
                        no_data.visibility = View.VISIBLE
                        recycle_view_rd.visibility= View.GONE
                    }

                    override fun failed() {
                        refreshLayout_responsible_depart.finishRefresh(1000)
                    }
                })
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent()
        intent.putExtra("timSortName", "")
        setResult(6, intent)
        finish()
    }
    override fun onStop() {
        super.onStop()
        mModel!!.cleanHttp()
    }

}