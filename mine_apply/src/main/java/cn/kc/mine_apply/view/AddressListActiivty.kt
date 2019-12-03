package cn.kc.trainman_apply.addresslist.view

import android.os.Bundle
import android.view.View
import cn.kc.mine_apply.R
import cn.kc.mine_apply.adapter.ExpandListViewAdapter
import cn.kc.mine_apply.bean.FirstBean
import cn.kc.mine_apply.contract.AddressListContract
import cn.kc.trainman_apply.addresslist.presenter.AddressListPresenter
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.base.BaseApplication.Companion.preferences
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.util.PhoneUtils
import cn.kc.moduleutils.util.ToastUtil
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.act_address_list.*

/**
 * 作者： Abel .
 * 日期：2019/7/29
 * 说明：
 */

@Route(path = "/moduleaddresslist/addresslist")
class AddressListActiivty : BaseActivity(), View.OnClickListener,AddressListContract.View {

    /**
     * 懒加载
     */
    private val mAdapter: ExpandListViewAdapter by lazy {
        ExpandListViewAdapter(this)
    }
    private val mPresenter: AddressListContract.Presenter by lazy {
        AddressListPresenter(this)
    }

    val mData: ArrayList<FirstBean>? = ArrayList()

    override fun getLayout() = R.layout.act_address_list

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        back.setOnClickListener(this)
        search_person.setOnClickListener(this)

        //设置搜索图标的宽高
        val drawable = resources.getDrawable(R.mipmap.search)
        drawable.setBounds(0, 0, 32, 32)
        address_list_search.setCompoundDrawables(drawable, null, null, null)

        mAdapter!!.setData(mData)
        address_list.setAdapter(mAdapter)
    }

    override fun initData() {
        super.initData()

        refreshLayout_address.autoRefresh()

        refreshLayout_address.setOnRefreshListener {
            mPresenter!!.getAddressList(Constant.mUID)
        }

        mAdapter.setmOnItemChick(object : ExpandListViewAdapter.OnItemChick {
            override fun onItemClickListen(groupPosition: Int) {
                if (groupPosition == 1) {
                    PhoneUtils.callPhone(this@AddressListActiivty, preferences.jobNum.toString())
                } else {
                    PhoneUtils.sendSMS(this@AddressListActiivty, preferences.jobNum.toString())
                }
            }
        })
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
            R.id.back -> {
                finish()
            }
            R.id.search_person -> {
                if (address_list_search.text.length == 0 || address_list_search.text.equals(null)) {
                    ToastUtil.showToast(this@AddressListActiivty, "请输入姓名")
                    return
                }
                mPresenter!!.getAddressListSelect(address_list_search.text.toString(), Constant.mUID)
            }
            else -> ToastUtil.showToast(this, "no click")
        }
    }

    override fun onStop() {
        super.onStop()
        preferences.jobNum = null
    }
}