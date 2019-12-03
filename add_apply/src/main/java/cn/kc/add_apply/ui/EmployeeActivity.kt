package cn.kc.trainman_apply.reported_data.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.add_apply.bean.EmployeeBean
import cn.kc.trainman_apply.reported_data.adapter.EmployeeAdapter
import cn.kc.trainman_apply.reported_data.model.EmployeeModel
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.util.ToastUtil
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.act_employee.*
import kotlinx.android.synthetic.main.act_responsibledepartment.back_respon_department
import kotlinx.android.synthetic.main.act_responsibledepartment.no_data
import kotlinx.android.synthetic.main.act_responsibledepartment.recycle_view_rd
import kotlinx.android.synthetic.main.act_responsibledepartment.refreshLayout_responsible_depart
import kotlinx.android.synthetic.main.act_responsibledepartment.txt_title_rd

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：责任人
 */
class EmployeeActivity : BaseActivity() {
    var mModel: EmployeeModel? = null
    lateinit var mAdapter: EmployeeAdapter
    val dataList: ArrayList<EmployeeBean.DataBean> = ArrayList()
    var mDeptName: String? = null
    var mGroupName: String? = null

    override fun getLayout() = R.layout.act_employee

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        txt_title_rd.setText("选择责任人")
        mDeptName = intent.getStringExtra("deptName")
        mGroupName = intent.getStringExtra("groupName")
        back_respon_department.setOnClickListener { onBackPressed() }
        search_employee.setOnClickListener { searchInfo() }
        initRecycleView()
    }

    override fun initData() {
        super.initData()
        mModel = EmployeeModel()
        refreshOrLoad()
        refreshLayout_responsible_depart.autoRefresh()

        mAdapter.getItemClickListener(object : EmployeeAdapter.ItemClickListener {
            override fun getItemContent(position: Int) {
                val intent = Intent()
                intent.putExtra("employeE_CODE_NAME", dataList.get(position).employeE_CODE_NAME)
                setResult(5, intent)
                finish()
            }
        })
    }

    fun initRecycleView() {
        mAdapter = EmployeeAdapter(this)
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
                mModel!!.getEmployee(mDeptName.toString(), mGroupName.toString(), object : EmployeeModel.UpdateView {
                    override fun success(data: ArrayList<EmployeeBean.DataBean>) {
                        no_data.visibility = View.GONE
                        recycle_view_rd.visibility = View.VISIBLE
                        dataList.clear()
                        dataList.addAll(data)
                        mAdapter.setData(dataList)
                        mAdapter.notifyDataSetChanged()
                        refreshLayout_responsible_depart.finishRefresh()
                    }

                    override fun error() {
                        refreshLayout_responsible_depart.finishRefresh(1000)
                        no_data.visibility = View.VISIBLE
                        recycle_view_rd.visibility = View.GONE
                    }

                    override fun failed() {
                        refreshLayout_responsible_depart.finishRefresh(1000)
                    }
                })
            }
        })
    }

    /**
     * 查询
     */
    fun searchInfo() {
        if (employee_search.text == null) {
            ToastUtil.showToast(this, "请输入关键字搜索")
            return
        }
        val searchData: ArrayList<EmployeeBean.DataBean> = ArrayList()
        for (i in 0 until dataList.size) {
            if (dataList.get(i).employeE_CODE_NAME!!.contains(employee_search.text)) {
                searchData.add(dataList.get(i))
            }
        }
        dataList.clear()
        dataList.addAll(searchData)
        mAdapter.setData(dataList)
        mAdapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent()
        intent.putExtra("employeE_CODE_NAME", "")
        setResult(5, intent)
        finish()
    }

    override fun onStop() {
        super.onStop()
        mModel!!.cleanHttp()
    }
}