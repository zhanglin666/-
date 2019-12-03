package cn.kc.trainman_apply.main

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * 作者： Abel .
 * 日期：2019/10/12
 * 说明：
 */
class MainAdapter(fm: FragmentManager, private val mlist: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
    }
    override fun getItem(position: Int): Fragment {
        return mlist.get(position)
    }

    override fun getCount(): Int {
        return mlist.size
    }

}