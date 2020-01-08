package cn.kc.moduleutils.base

import android.os.Bundle

/**
 * 作者： Abel .
 * 日期：2020/1/3
 * 说明：
 */
abstract class LazyLoadFragment : BaseFragment() {
    /**
     * 是否初始化过布局
     */
    protected var isViewInitiated = false
    /**
     * 当前界面是否可见
     */
    protected var isVisibleToUser = false
    /**
     * 是否加载过数据
     */
    protected var isDataInitiated = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isViewInitiated = true
        prepareFetchData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        if (isVisibleToUser) {
            prepareFetchData()
        }
    }

    /**
     * 懒加载
     */
    abstract fun fetchData()

    fun prepareFetchData() {
        prepareFetchData(false)
    }

    /**
     * 判断懒加载条件
     *
     * @param forceUpdate 强制更新，好像没什么用？
     */
    fun prepareFetchData(forceUpdate: Boolean) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData()
            isDataInitiated = true
        }
    }

}