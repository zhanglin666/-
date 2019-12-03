package cn.kc.trainman_apply.reported_data.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.add_apply.bean.PageInfoCodeBean
import cn.kc.trainman_apply.reported_data.adapter.PageInfoCodeAdapter
import cn.kc.trainman_apply.reported_data.model.PageInfoCodeModel
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.util.ToastUtil
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.act_page_info_code.*
import kotlinx.android.synthetic.main.act_responsibledepartment.back_respon_department
import kotlinx.android.synthetic.main.act_responsibledepartment.recycle_view_rd
import kotlinx.android.synthetic.main.act_responsibledepartment.refreshLayout_responsible_depart
import kotlinx.android.synthetic.main.act_responsibledepartment.txt_title_rd

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class PageInfoCodeActivity : BaseActivity() {
    var mModel: PageInfoCodeModel? = null
    lateinit var mAdapter: PageInfoCodeAdapter
    val dataList: ArrayList<PageInfoCodeBean.DataBean> = ArrayList()
    var mCurrPage = 1
    var mPageSize = "20"

    override fun getLayout() = R.layout.act_page_info_code

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        txt_title_rd.setText("获取信息点")
        back_respon_department.setOnClickListener { onBackPressed() }
        initRecycleView()
    }

    override fun initData() {
        super.initData()
        mModel = PageInfoCodeModel()
        refreshOrLoad()
        refreshLayout_responsible_depart.autoRefresh()

        mAdapter.getItemClickListener(object : PageInfoCodeAdapter.ItemClickListener {
            override fun getItemContent(position: Int) {
                val intent = Intent()
                intent.putExtra("infoName", dataList.get(position).infO_NAME)
                setResult(8, intent)
                finish()
            }
        })

        search_page_info.setOnClickListener {
            if (page_info_code_search.text.trim().length != 0) {
                refreshLayout_responsible_depart.autoRefresh()
            } else {
                ToastUtil.showToast(this, "请输入关键字")
            }
        }
    }

    fun initRecycleView() {
        mAdapter = PageInfoCodeAdapter(this)
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
                if (dataList.size != 20) {
                    refreshLayout_responsible_depart.finishLoadMore()
                    return
                }
                mCurrPage++
                mModel!!.getPageInfoCode(mCurrPage.toString(), mPageSize,
                    page_info_code_search.text.toString(), object : PageInfoCodeModel.UpdateView {
                        override fun success(data: ArrayList<PageInfoCodeBean.DataBean>) {
                            dataList.addAll(data)
                            mAdapter.setData(dataList)
                            mAdapter.notifyDataSetChanged()
                            refreshLayout_responsible_depart.finishLoadMore()
                        }

                        override fun error() {
                            refreshLayout_responsible_depart.finishLoadMore(1000)
                        }

                        override fun failed() {
                            refreshLayout_responsible_depart.finishLoadMore(1000)
                        }
                    })
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                mCurrPage = 1
                mModel!!.getPageInfoCode(mCurrPage.toString(), mPageSize,
                    page_info_code_search.text.toString(), object : PageInfoCodeModel.UpdateView {
                        override fun success(data: ArrayList<PageInfoCodeBean.DataBean>) {
                            dataList.clear()
                            dataList.addAll(data)
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
        intent.putExtra("infoName", "")
        setResult(8, intent)
        finish()
    }

    override fun onStop() {
        super.onStop()
        mModel!!.cleanHttp()
    }


}