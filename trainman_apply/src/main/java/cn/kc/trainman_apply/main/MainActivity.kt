package cn.kc.trainman_apply.main

import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import cn.kc.trainman_apply.R
import cn.kc.trainman_apply.fragment.FlightAttendantApplyFragment
import cn.kc.moduleutils.base.BaseActivity
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.act_main.*

/**
 * 作者： Abel .
 * 日期：2019/7/29
 * 说明：首页
 */
class MainActivity : BaseActivity() {
    lateinit var mPresenter: MainIPresenter
    private val mFragment: ArrayList<Fragment> by lazy {
        ArrayList<Fragment>()
    }

    private val imgs: ArrayList<ImageView> by lazy {
        ArrayList<ImageView>()
    }

    override fun getLayout() = R.layout.act_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mPresenter = MainPresenter(this)
        lifecycle.addObserver(mPresenter)

        imgs.add(point_one)
        imgs.add(point_two)
        imgs.add(point_three)
        imgs.add(point_four)
        getFragment()
        getView()
    }

    fun getFragment() {
        mFragment.add(FlightAttendantApplyFragment())
        mFragment.add(
            ARouter.getInstance().build("/addapply/addapplyfragment")
                .navigation() as Fragment
        )
        mFragment.add(
            ARouter.getInstance().build("/integratedservice/integratedserviceapplyfragment")
                .navigation() as Fragment
        )
        mFragment.add(
            ARouter.getInstance().build("/modulemine/mineapplyfragment")
                .navigation() as Fragment
        )
    }

    fun getView() {
        main_vp.adapter = MainAdapter(supportFragmentManager, mFragment)
        main_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                getPoint(position)
            }

        })
    }

    fun getPoint(index: Int) {
        for (i in 0 until imgs.size) {
            if (i == index) {
                imgs.get(i).setImageResource(R.mipmap.point_selected)
            } else {
                imgs.get(i).setImageResource(R.mipmap.point_mormal)
            }
        }
    }

}