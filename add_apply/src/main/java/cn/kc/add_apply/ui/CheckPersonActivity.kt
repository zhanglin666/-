package cn.kc.trainman_apply.reported_data.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.add_apply.adapter.CheckPersonAdapter
import cn.kc.add_apply.bean.CheckPersonBean
import cn.kc.add_apply.view.ItemClickListener
import cn.kc.trainman_apply.reported_data.model.CheckPersonModel
import cn.kc.moduleutils.base.BaseActivity
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.act_check_person.*


/**
 * 作者： Abel .
 * 日期：2019/9/9
 * 说明：检查人
 */
class CheckPersonActivity : BaseActivity() {

    var mModel: CheckPersonModel? = null
    lateinit var mAdapter: CheckPersonAdapter
    val dataList: ArrayList<CheckPersonBean.DataBean> = ArrayList()
    val selectDatas: ArrayList<String> = ArrayList()

    override fun getLayout() = R.layout.act_check_person

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        txt_title_rd.setText("检查人")
        back_respon_department.setOnClickListener {onBackPressed()}
        initRecycleView()
    }

    override fun initData() {
        super.initData()
        mModel = CheckPersonModel()
        refreshOrLoad()
        refreshLayout_responsible_depart.autoRefresh()

        mAdapter.getItemClickListener(object : ItemClickListener {
            override fun getItemContent(position: Int) {
                if (!mAdapter.isSelected.get(position)!!) {
                    mAdapter.isSelected.put(position, true) // 修改map的值保存状态
                    mAdapter.notifyItemChanged(position)
                    selectDatas.add(dataList.get(position).employeE_CODE_NAME.toString())
                } else {
                    mAdapter.isSelected.put(position, false); // 修改map的值保存状态
                    mAdapter.notifyItemChanged(position);
                    selectDatas.remove(dataList.get(position).employeE_CODE_NAME);
                }
            }
        })

        check_person_success.setOnClickListener {
            val intent = Intent()
            intent.putExtra("employeE_CODE_NAME", selectDatas)
            setResult(2, intent)
            finish()
        }
    }

    fun initRecycleView() {
        mAdapter = CheckPersonAdapter(this)
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
                mModel!!.getEmployee("", "", "列车长",
                    object : CheckPersonModel.UpdateView {
                        override fun success(data: ArrayList<CheckPersonBean.DataBean>) {
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
                            recycle_view_rd.visibility=View.GONE
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

    }

    override fun onStop() {
        super.onStop()
        mModel!!.cleanHttp()
    }

}