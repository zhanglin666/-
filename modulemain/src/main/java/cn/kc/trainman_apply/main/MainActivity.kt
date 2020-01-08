package cn.kc.trainman_apply.main

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.util.AppManager
import cn.kc.moduleutils.util.ToastUtil
import cn.kc.trainman_apply.R
import cn.kc.trainman_apply.fragment.MenuFragment
import cn.kc.trainman_apply.fragment.MineFragment
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.act_main.*

/**
 * 作者： Abel .
 * 日期：2019/7/29
 * 说明：首页
 */
class MainActivity : BaseActivity() {
    lateinit var mPresenter: MainIPresenter
    private var mDiaolingFragment: Fragment? = null
    private var mMenuFragment: Fragment? = null
    private var mJiaoluFragment: Fragment? = null
    private var mAddressFragment: Fragment? = null
    private var mMineFragment: Fragment? = null

    override fun getLayout() = R.layout.act_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mPresenter = MainPresenter(this)
        lifecycle.addObserver(mPresenter)

        showMenuFragment()
        ll_main_diaoling.setOnClickListener {
            showDiaolingFragment()
            hideImg(0)
        }
        ll_main_jiaolu.setOnClickListener {
            showJiaoluFragment()
            hideImg(1)
        }
        ll_main_menu.setOnClickListener {
            showMenuFragment()
            hideImg(2)
        }
        ll_main_address.setOnClickListener {
            showAddressFragment()
            hideImg(3)
        }
        ll_main_mine.setOnClickListener {
            showMineFragment()
            hideImg(4)
        }
    }

    fun hideImg(position: Int) {
        img_diaoling.setBackgroundResource(R.mipmap.icon_ml2)
        img_jiaolu.setBackgroundResource(R.mipmap.icon_jl2)
        img_menu.setBackgroundResource(R.mipmap.icon_zy2)
        img_address.setBackgroundResource(R.mipmap.icon_txl2)
        img_mine.setBackgroundResource(R.mipmap.js)
        when (position) {
            0 -> {
                img_diaoling.setBackgroundResource(R.mipmap.icon_ml1)
            }
            1 -> {
                img_jiaolu.setBackgroundResource(R.mipmap.icon_jl1)
            }
            2 -> {
                img_menu.setBackgroundResource(R.mipmap.icon_zy1)
            }
            3 -> {
                img_address.setBackgroundResource(R.mipmap.icon_txl1)
            }
            4 -> {
                img_mine.setBackgroundResource(R.mipmap.wjs)
            }
            else -> {
                ToastUtil.showToast(this, "else..")
            }
        }
    }

    private fun showDiaolingFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (mDiaolingFragment == null) {
            mDiaolingFragment = ARouter.getInstance().build("/addapply/addapplyfragment")
                .navigation() as Fragment
            transaction.add(R.id.container, mDiaolingFragment!!)
        }
        hideAllFragment()
        transaction.show(mDiaolingFragment!!).commit()
    }

    private fun showMenuFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (mMenuFragment == null) {
            mMenuFragment = MenuFragment()
            transaction.add(R.id.container, mMenuFragment!!)
        }
        hideAllFragment()
        transaction.show(mMenuFragment!!).commit()
    }

    private fun showJiaoluFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (mJiaoluFragment == null) {
            mJiaoluFragment =
                ARouter.getInstance().build("/integratedservice/integratedserviceapplyfragment")
                    .navigation() as Fragment
            transaction.add(R.id.container, mJiaoluFragment!!)
        }
        hideAllFragment()
        transaction.show(mJiaoluFragment!!).commit()
    }

    private fun showAddressFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (mAddressFragment == null) {
            mAddressFragment = ARouter.getInstance().build("/moduleaddresslist/addresslist")
                .navigation() as Fragment
            transaction.add(R.id.container, mAddressFragment!!)
        }
        hideAllFragment()
        transaction.show(mAddressFragment!!).commit()
    }

    private fun showMineFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (mMineFragment == null) {
            mMineFragment = MineFragment()
            transaction.add(R.id.container, mMineFragment!!)
        }
        hideAllFragment()
        transaction.show(mMineFragment!!).commit()
    }

    private fun hideAllFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (mDiaolingFragment != null) {
            transaction.hide(mDiaolingFragment!!)
        }
        if (mMenuFragment != null) {
            transaction.hide(mMenuFragment!!)
        }
        if (mJiaoluFragment != null) {
            transaction.hide(mJiaoluFragment!!)
        }
        if (mAddressFragment != null) {
            transaction.hide(mAddressFragment!!)
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment!!)
        }
        transaction.commit()
    }

    private var firstTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event!!.action == KeyEvent.ACTION_DOWN) {
            var secondTime = System.currentTimeMillis()
            if (secondTime - firstTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show()
                firstTime = secondTime
                return true
            } else {
                AppManager.getAppManager().AppExit(this)
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}