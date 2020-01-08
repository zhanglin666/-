package cn.kc.trainman_apply.addresslist.view

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import cn.kc.mine_apply.R
import cn.kc.mine_apply.adapter.ExpandListViewAdapter
import cn.kc.mine_apply.bean.FirstBean
import cn.kc.mine_apply.contract.AddressListContract
import cn.kc.moduleutils.base.BaseApplication.Companion.preferences
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.base.LazyLoadFragment
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.util.Logs
import cn.kc.moduleutils.util.PhoneUtils
import cn.kc.moduleutils.util.ToastUtil
import cn.kc.moduleutils.view.WeiboDialogUtils
import cn.kc.trainman_apply.addresslist.presenter.AddressListPresenter
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.act_address_list.*

/**
 * 作者： Abel .
 * 日期：2019/7/29
 * 说明：
 */

@Route(path = "/moduleaddresslist/addresslist")
class AddressListFragment : BaseFragment(), View.OnClickListener, AddressListContract.View {
    /**
     * 懒加载
     */
    private val mAdapter: ExpandListViewAdapter by lazy {
        ExpandListViewAdapter(activity)
    }
    private val mPresenter: AddressListContract.Presenter by lazy {
        AddressListPresenter(this)
    }

    var mDialog: Dialog? = null
    val mData: ArrayList<FirstBean>? = ArrayList()

    override fun getLayout() = R.layout.act_address_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search_person.setOnClickListener(this)
        //设置搜索图标的宽高
        val drawable = resources.getDrawable(R.mipmap.search)
        drawable.setBounds(0, 0, 32, 32)
        address_list_search.setCompoundDrawables(drawable, null, null, null)

        mAdapter!!.setData(mData)
        address_list.setAdapter(mAdapter)

        refreshLayout_address.setOnRefreshListener {
            mPresenter!!.getAddressList(Constant.mUID)
        }

        mAdapter.setmOnItemChick(object : ExpandListViewAdapter.OnItemChick {
            override fun onItemClickListen(groupPosition: Int) {
                if (groupPosition == 1) {
                    activity?.let { PhoneUtils.callPhone(it, preferences.jobNum.toString()) }
                } else {
                    activity?.let { PhoneUtils.sendSMS(it, preferences.jobNum.toString()) }
                }
            }
        })
    }

    override fun initData() {
        refreshLayout_address.autoRefresh()
    }

    override fun resultUserInfo(result: ArrayList<FirstBean>) {
        mAdapter.setData(result)
        mAdapter.notifyDataSetChanged()
        //列表展开
//        val groupCount: Int = address_list.getCount()
//        for (i in 0 until groupCount) {
//            address_list.expandGroup(i)
//        }
    }

    override fun showProgressDialog() {
    }

    override fun dismissProgressDialog() {
        refreshLayout_address.finishRefresh()
    }

    override fun onFail(msg: String?) {
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.search_person -> {
                if (address_list_search.text.length == 0 || address_list_search.text.equals(null)) {
                    activity?.let { ToastUtil.showToast(it, "请输入姓名") }
                    return
                }
                mPresenter!!.getAddressListSelect(
                    address_list_search.text.toString(),
                    Constant.mUID
                )
            }
            else -> activity?.let { ToastUtil.showToast(it, "no click") }
        }
    }

    override fun onStop() {
        super.onStop()
        preferences.jobNum = null
        Log.e("msg", "页面被销毁")
    }
}