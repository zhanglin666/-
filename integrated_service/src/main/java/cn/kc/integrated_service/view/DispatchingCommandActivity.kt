package cn.kc.trainman_apply.dispatchingcommand.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import cn.kc.integrated_service.R
import cn.kc.integrated_service.bean.CommandClassifyBean
import cn.kc.integrated_service.contract.CommandContract
import cn.kc.trainman_apply.dispatchingcommand.adapter.TabFragmentPagerAdapter
import cn.kc.trainman_apply.dispatchingcommand.fragment.HadDoneFragment
import cn.kc.trainman_apply.dispatchingcommand.fragment.InExecutionFragment
import cn.kc.trainman_apply.dispatchingcommand.fragment.NoReceiveFragment
import cn.kc.trainman_apply.dispatchingcommand.presenter.DispatchingCommandPreserter
import cn.kc.moduleutils.base.BaseMvpActivity
import cn.kc.moduleutils.util.ToastUtil
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.act_dispatching_command.*

/**
 * 作者： Abel .
 * 日期：2019/7/30
 * 说明：
 */

@Route(path = "/module_dispatching_command/dispatchingcommand")
class DispatchingCommandActivity : BaseMvpActivity<DispatchingCommandPreserter>(), CommandContract.View,
    View.OnClickListener {

    private var tempFragmentTag: String? = null
    var list: ArrayList<Fragment>? = null
    var adapter: TabFragmentPagerAdapter? = null

    override fun getLayout() = R.layout.act_dispatching_command

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        back.setOnClickListener(this)
        no_receive.setOnClickListener(this)
        in_execution.setOnClickListener(this)
        had_done.setOnClickListener(this)
        view_pager.setOnPageChangeListener(MyPagerChangeListener())
    }

    override fun initData() {
        super.initData()
        list = ArrayList()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadData()
    }

    override fun createPresenter(): DispatchingCommandPreserter {
        return DispatchingCommandPreserter(this)
    }

    override fun resultData(result: CommandClassifyBean) {
        list!!.add(NoReceiveFragment.newInstance(result))
        list!!.add(InExecutionFragment.newInstance(result))
        list!!.add(HadDoneFragment.newInstance(result))
        adapter = TabFragmentPagerAdapter(supportFragmentManager, list!!)
        view_pager.offscreenPageLimit = 3
        view_pager.adapter = adapter
        view_pager.currentItem = 0
    }

    override fun onFail(msg: String?) {
        ToastUtil.showToast(this, msg.toString())
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.back -> {
                finish()
            }
            R.id.no_receive -> {
                view_pager.currentItem = 0
            }
            R.id.in_execution -> {
                view_pager.currentItem = 1
            }
            R.id.had_done -> {
                view_pager.currentItem = 3
            }
            else -> false
        }
    }


    inner class MyPagerChangeListener : androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {
        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        }

        override fun onPageSelected(p0: Int) {
            when (p0) {
                0 -> {
                    no_receive.setTextColor(Color.WHITE)
                    no_receive.setBackgroundColor(resources.getColor(R.color.btn_login))
                    in_execution.setTextColor(Color.BLACK)
                    in_execution.setBackgroundColor(Color.WHITE)
                    had_done.setTextColor(Color.BLACK)
                    had_done.setBackgroundColor(Color.WHITE)
                }
                1 -> {
                    no_receive.setTextColor(Color.BLACK)
                    no_receive.setBackgroundColor(Color.WHITE)
                    in_execution.setTextColor(Color.WHITE)
                    in_execution.setBackgroundColor(resources.getColor(R.color.btn_login))
                    had_done.setTextColor(Color.BLACK)
                    had_done.setBackgroundColor(Color.WHITE)
                }
                2 -> {
                    no_receive.setTextColor(Color.BLACK)
                    no_receive.setBackgroundColor(Color.WHITE)
                    in_execution.setTextColor(Color.BLACK)
                    in_execution.setBackgroundColor(Color.WHITE)
                    had_done.setTextColor(Color.WHITE)
                    had_done.setBackgroundColor(resources.getColor(R.color.btn_login))
                }
                else -> {
                    ToastUtil.showToast(this@DispatchingCommandActivity, "no more page")
                }
            }
        }
    }
}
