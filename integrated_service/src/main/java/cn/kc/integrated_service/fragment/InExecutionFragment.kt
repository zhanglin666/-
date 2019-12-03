package cn.kc.trainman_apply.dispatchingcommand.fragment

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import android.util.ArrayMap
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kc.integrated_service.R
import cn.kc.integrated_service.adapter.SpinnerAdapter
import cn.kc.integrated_service.bean.CommandClassifyBean
import cn.kc.integrated_service.bean.InExecutionBeanIng
import cn.kc.trainman_apply.dispatchingcommand.adapter.InExecutionAdapter
import cn.kc.trainman_apply.dispatchingcommand.fragment.presenter.InExecutionIPresenter
import cn.kc.trainman_apply.dispatchingcommand.fragment.presenter.InExecutionPresenter
import cn.kc.trainman_apply.dispatchingcommand.fragment.view.InExecutionIView
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.util.DefindedDialog
import cn.kc.moduleutils.util.DialogUtils
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.fragment_in_execution.*

/**
 * 作者： Abel .
 * 日期：2019/7/31
 * 说明：
 */
class InExecutionFragment : BaseFragment(), InExecutionIView, DefindedDialog.OnDedindedClickedListener {

    var data: CommandClassifyBean? = null
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    val type: ArrayMap<String, String>? = ArrayMap()
    var mPresenter: InExecutionIPresenter? = null
    var mRcyAdapter: InExecutionAdapter? = null
    val mListData: ArrayList<InExecutionBeanIng.DataBean>? = ArrayList()
    private lateinit var mSpinnerAdapter: SpinnerAdapter

    companion object {
        internal fun newInstance(msg: CommandClassifyBean): InExecutionFragment {
            val myFragment = InExecutionFragment()
            val bundle = Bundle()
            bundle.putSerializable("DATA", msg)
            myFragment.arguments = bundle
            return myFragment
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

        mRcyAdapter = activity?.let { InExecutionAdapter(it) }
        mListData?.let { mRcyAdapter!!.setData(it) }
        recycle_view_in.adapter = mRcyAdapter
        recycle_view_in.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL, false
            )
        )
    }

    override fun getLayout() = R.layout.fragment_in_execution

    override fun initData() {
        mPresenter = InExecutionPresenter(this)
        getLifecycle().addObserver(mPresenter as InExecutionPresenter)

        setSpinner()
        onRefreshLoadMore()
        refreshLayout_in.autoRefresh()
        onItemClick()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun setSpinner() {
        mSpinnerAdapter = SpinnerAdapter(activity, type)
        spinner_code_in.adapter = mSpinnerAdapter
        spinner_code_in.setDropDownVerticalOffset(144)   //下垂偏移度
        spinner_code_in.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            @RequiresApi(Build.VERSION_CODES.KITKAT)
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0) {
                    mPresenter!!.loadData(
                        "2", type!!.keyAt(position) as String,
                        edt_content_in.text.toString(), Constant.mUID
                    )
                }
            }
        }
    }

    /**
     *接受命令点击事件
     */
    fun onItemClick() {
        mRcyAdapter!!.setOnItemClickListener { position ->
            DialogUtils.commonDialogTwoBtn(
                activity, "确认是否完成?",
                "确定", "取消", position,
                this@InExecutionFragment
            )
        }
    }

    override fun onPositiveButtonClieked(dialog: DefindedDialog?, position: Int) {
        mPresenter!!.commandReceive(
            mListData!!.get(position).commanD_ISSUEID.toString(),
            "4", Constant.mUID,
            mListData!!.get(position).resolvE_ID.toString()
        )
    }

    override fun onNegativeButtonClieked(dialog: DefindedDialog?) {
    }

    fun onRefreshLoadMore() {
        refreshLayout_in.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                spinner_code_in.setSelection(0)
                mSpinnerAdapter.notifyDataSetChanged()
                mPresenter!!.loadData(
                    "2", "0",
                    edt_content_in.text.toString(),Constant.mUID
                )
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                refreshLayout_in.finishLoadMore(1000)
            }

        })
    }

    override fun showDialog() {
        refreshLayout_in.autoRefresh()
    }

    override fun hideDialog() {
        refreshLayout_in.finishRefresh()
    }

    override fun showData(msg: ArrayList<InExecutionBeanIng.DataBean>) {
        mListData!!.clear()
        mListData.addAll(msg)
        mListData?.let { mRcyAdapter!!.setData(it) }
        mRcyAdapter!!.notifyDataSetChanged()
    }
}