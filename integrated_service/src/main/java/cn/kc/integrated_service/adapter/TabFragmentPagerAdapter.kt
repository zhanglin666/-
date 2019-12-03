package cn.kc.trainman_apply.dispatchingcommand.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.view.ViewGroup

/**
 * 作者： Abel .
 * 日期：2019/7/30
 * 说明：
 */
class TabFragmentPagerAdapter(fm: FragmentManager, private val mlist: ArrayList<Fragment>) : androidx.fragment.app.FragmentPagerAdapter(fm) {

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
    }

    override fun getItem(arg0: Int): androidx.fragment.app.Fragment {
        return mlist[arg0]//显示第几个页面
    }

    override fun getCount(): Int {
        return mlist.size//有几个页面
    }
}