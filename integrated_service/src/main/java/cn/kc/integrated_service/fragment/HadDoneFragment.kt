package cn.kc.trainman_apply.dispatchingcommand.fragment

import android.os.Build
import android.os.Bundle
import android.util.ArrayMap
import android.view.View
import android.widget.AdapterView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kc.integrated_service.R
import cn.kc.integrated_service.adapter.SpinnerAdapter
import cn.kc.integrated_service.bean.CommandClassifyBean
import cn.kc.integrated_service.bean.HadDoneBean
import cn.kc.trainman_apply.dispatchingcommand.adapter.HadDoneAdapter
import cn.kc.trainman_apply.dispatchingcommand.fragment.presenter.HadDoneIPresenter
import cn.kc.trainman_apply.dispatchingcommand.fragment.presenter.HadDonePresenter
import cn.kc.trainman_apply.dispatchingcommand.fragment.view.HadDoneView
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.http.Constant
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.fragment_had_done.*

/**
 * 作者： Abel .
 * 日期：2019/7/31
 * 说明：
 */
class HadDoneFragment : BaseFragment(), HadDoneView {

    var data: CommandClassifyBean? = null
    val type: ArrayMap<String, String>? = ArrayMap()
    var mRcyAdapter: HadDoneAdapter? = null
    val mListData: ArrayList<HadDoneBean.DataBean>? = ArrayList()
    var mPresenter: HadDoneIPresenter? = null
    private lateinit var mSpinnerAdapter: SpinnerAdapter

    companion object {
        fun newInstance(msg: CommandClassifyBean): HadDoneFragment {
            val hadDoneFragment = HadDoneFragment()
            val bundle = Bundle()
            bundle.putSerializable("DATA", msg)
            hadDoneFragment.arguments = bundle
            return hadDoneFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle = this!!.getArguments()!!
        data = bundle.getSerializable("DATA") as CommandClassifyBean
        type!!.put("0", "请选择")
        for (i in 0 until data!!.data.size) {
            type!!.put(data!!.data.get(i).commanD_TYPE_ID, data!!.data.get(i).commanD_TYPE_NAME)
        }

        mRcyAdapter = activity?.let { HadDoneAdapter(it) }
        mListData?.let { mRcyAdapter!!.setData(it) }
        recycle_view_done.adapter = mRcyAdapter
        recycle_view_done.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL, false
            )
        )
    }

    override fun getLayout() = R.layout.fragment_had_done

    override fun initData() {
        mPresenter = HadDonePresenter(this)
        lifecycle.addObserver(mPresenter as HadDonePresenter)
        setSpinner()

        onRefreshLoadMore()
        refreshLayout_done.autoRefresh()
    }

    fun setSpinner() {
        mSpinnerAdapter = SpinnerAdapter(activity, type)
        spinner_code_done.adapter = mSpinnerAdapter
        spinner_code_done.setDropDownVerticalOffset(144)   //下垂偏移度
        spinner_code_done.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            @RequiresApi(Build.VERSION_CODES.KITKAT)
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0) {
                    mPresenter!!.loadData(
                        "4", type!!.keyAt(position) as String,
                        edt_content_done.text.toString(), Constant.mUID
                    )
                }
            }
        }
    }

    fun onRefreshLoadMore() {
        refreshLayout_done.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                refreshLayout_done.finishLoadMore(1000)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                spinner_code_done.setSelection(0)
                mSpinnerAdapter.notifyDataSetChanged()
                mPresenter!!.loadData(
                    "4", "0",
                    edt_content_done.text.toString(), Constant.mUID
                )
            }
        })
    }

    override fun showDialog() {
    }

    override fun hideDialog() {
        refreshLayout_done.finishRefresh()
    }

    override fun showData(msg: ArrayList<HadDoneBean.DataBean>) {
        mListData!!.clear()
        mListData.addAll(msg)
        mListData?.let { mRcyAdapter!!.setData(it) }
        mRcyAdapter!!.notifyDataSetChanged()
    }
}