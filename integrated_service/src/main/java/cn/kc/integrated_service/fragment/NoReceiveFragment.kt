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
import cn.kc.integrated_service.bean.NoReceiveBean
import cn.kc.trainman_apply.dispatchingcommand.adapter.NoReceiveRecycleView
import cn.kc.trainman_apply.dispatchingcommand.fragment.presenter.NoReceiveIPresenter
import cn.kc.trainman_apply.dispatchingcommand.fragment.presenter.NoReceivePresenter
import cn.kc.trainman_apply.dispatchingcommand.fragment.view.NoReceiveIView
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.bean.MessageEvent
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.util.DefindedDialog
import cn.kc.moduleutils.util.DialogUtils
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.fragment_noreceive.*
import org.greenrobot.eventbus.EventBus
import android.widget.AdapterView.OnItemSelectedListener as AdapterViewOnItemSelectedListener

/**
 * 作者： Abel .
 * 日期：2019/7/31
 * 说明：未接收页面
 */
class NoReceiveFragment : BaseFragment(), NoReceiveIView, DefindedDialog.OnDedindedClickedListener {

    var data: CommandClassifyBean? = null
    var mPresenter: NoReceiveIPresenter? = null
    val mListData: ArrayList<NoReceiveBean.DataBean>? = ArrayList()
    var mRcyAdapter: NoReceiveRecycleView? = null
    private lateinit var mSpinnerAdapter: SpinnerAdapter

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    val type: ArrayMap<String, String>? = ArrayMap()

    companion object {
        internal fun newInstance(msg: CommandClassifyBean): NoReceiveFragment {
            val myFragment = NoReceiveFragment()
            val bundle = Bundle()
            bundle.putSerializable("DATA", msg)
            myFragment.arguments = bundle
            return myFragment
        }
    }

    //初始化页面
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle = this!!.getArguments()!!
        data = bundle.getSerializable("DATA") as CommandClassifyBean
        type!!.put("0", "请选择")
        for (i in 0 until data!!.data.size) {
            type!!.put(data!!.data.get(i).commanD_TYPE_ID, data!!.data.get(i).commanD_TYPE_NAME)
        }

        mRcyAdapter = activity?.let { NoReceiveRecycleView(it) }
        mListData?.let { mRcyAdapter!!.setData(it) }
        recycle_view.adapter = mRcyAdapter
        recycle_view.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL, false
            )
        )
    }

    override fun getLayout() = R.layout.fragment_noreceive

    override fun initData() {
        mPresenter = NoReceivePresenter(this)
        getLifecycle().addObserver(mPresenter as NoReceivePresenter)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getSpinnerData()
        }
        onRefreshLoadMore()
        refreshLayout.autoRefresh()
        onItemClick()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getSpinnerData() {
        mSpinnerAdapter = SpinnerAdapter(activity, type)
        spinner_code.adapter = mSpinnerAdapter
        spinner_code.setDropDownVerticalOffset(144)   //下垂偏移度
        spinner_code.onItemSelectedListener = object : AdapterViewOnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            @RequiresApi(Build.VERSION_CODES.KITKAT)
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0) {
                    mPresenter!!.loadData(
                        "1", type!!.keyAt(position) as String,
                        edt_content.text.toString(), Constant.mUID
                    )
                }
            }
        }
    }

    /**
     *接受命令点击事件
     */
    fun onItemClick() {
        mRcyAdapter!!.setOnItemClick(object : NoReceiveRecycleView.OnItemClick {
            override fun onItemClick(position: Int) {
                DialogUtils.commonDialogTwoBtn(
                    activity, "确认是否接令?",
                    "确定", "取消", position,
                    this@NoReceiveFragment
                )
            }
        })
    }

    //确定接令按钮
    override fun onPositiveButtonClieked(dialog: DefindedDialog?, position: Int) {

        EventBus.getDefault().post(MessageEvent("stopVideo"))//关闭提示声音

        mPresenter!!.commandReceive(
            mListData!!.get(position).commanD_ISSUEID.toString(),
            "2", Constant.mUID,
            mListData!!.get(position).resolvE_ID.toString()
        )
    }

    //取消接令按钮
    override fun onNegativeButtonClieked(dialog: DefindedDialog?) {

    }

    /**
     * 上拉加载下拉刷新
     */
    fun onRefreshLoadMore() {
        refreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                refreshLayout.finishLoadMore(1000)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                spinner_code.setSelection(0)
                mSpinnerAdapter.notifyDataSetChanged()
                mPresenter!!.loadData(
                    "1", "0",
                    edt_content.text.toString(), Constant.mUID
                )
            }
        })
    }

    override fun showDialog() {
        refreshLayout.autoRefresh()
    }

    override fun hideDialog() {
        refreshLayout.finishRefresh()
    }

    override fun showData(msg: ArrayList<NoReceiveBean.DataBean>) {
        mListData!!.clear()
        mListData.addAll(msg)
        mListData?.let { mRcyAdapter!!.setData(it) }
        mRcyAdapter!!.notifyDataSetChanged()
    }

    override fun commandSuccess() {
        refreshLayout.autoRefresh()
    }
}