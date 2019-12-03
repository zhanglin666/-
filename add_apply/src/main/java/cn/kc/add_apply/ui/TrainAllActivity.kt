package cn.kc.trainman_apply.reported_data.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.add_apply.bean.TrainAllBean
import cn.kc.trainman_apply.reported_data.adapter.TrainAllAdapter
import cn.kc.trainman_apply.reported_data.model.TrainAllModel
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.view.WeiboDialogUtils
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.act_responsibledepartment.*

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class TrainAllActivity : BaseActivity() {
    var mModel: TrainAllModel? = null
    lateinit var mAdapter: TrainAllAdapter
    val dataList: ArrayList<TrainAllBean.DataBean> = ArrayList()
    var mDeptName: String? = null
    var mGroupName: String? = null
    var mDialog: Dialog? = null

    override fun getLayout() = R.layout.act_responsibledepartment

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        txt_title_rd.setText("车次选择")
        mDeptName = intent.getStringExtra("deptName")
        mGroupName = intent.getStringExtra("groupName")
        back_respon_department.setOnClickListener { onBackPressed() }
        initRecycleView()
    }

    override fun initData() {
        super.initData()
        mModel = TrainAllModel()
        refreshOrLoad()
        refreshLayout_responsible_depart.autoRefresh()

        mAdapter.getItemClickListener(object : TrainAllAdapter.ItemClickListener {
            override fun getItemContent(position: Int) {
                mDialog = WeiboDialogUtils.createLoadingDialog(this@TrainAllActivity, "加载中")
                mModel!!.getStation(dataList.get(position).id.toString(), object : TrainAllModel.UpdateView {
                    override fun success(data: Any) {
                        WeiboDialogUtils.closeDialog(mDialog)
                        val intent = Intent()
                        intent.putExtra("trainName", dataList.get(position).traiN_NAMES)
                        intent.putStringArrayListExtra("trainList", data as  ArrayList<String>)
                        setResult(4, intent)
                        finish()
                    }

                    override fun error() {
                        WeiboDialogUtils.closeDialog(mDialog)
                    }

                    override fun failed() {
                        WeiboDialogUtils.closeDialog(mDialog)
                    }
                })
            }
        })
    }

    fun initRecycleView() {
        mAdapter = TrainAllAdapter(this)
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
                mModel!!.getTrainAll(mDeptName.toString(), mGroupName.toString(), object : TrainAllModel.UpdateView {
                    override fun success(data: Any) {
                        dataList.clear()
                        dataList.addAll(data as  ArrayList<TrainAllBean.DataBean>)
                        mAdapter.setData(dataList)
                        mAdapter.notifyDataSetChanged()
                        refreshLayout_responsible_depart.finishRefresh()
                    }

                    override fun error() {
                        refreshLayout_responsible_depart.finishRefresh(1000)
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
        intent.putExtra("trainName", "")
        intent.putExtra("trainID", "")
        setResult(4, intent)
        finish()
    }

    override fun onStop() {
        super.onStop()
        mModel!!.cleanHttp()
    }
}