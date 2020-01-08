package cn.kc.trainman_apply.addresslist.model

import cn.kc.mine_apply.AddressApi
import cn.kc.mine_apply.bean.FirstBean
import cn.kc.mine_apply.bean.SecondBean
import cn.kc.mine_apply.bean.ThirdBean
import cn.kc.mine_apply.contract.AddressListContract
import cn.kc.moduleutils.base.ResultCallback
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/8/2
 * 说明：
 */
class AddressListModel : AddressListContract.Model {

    val mDisposables = CompositeDisposable()
    /**
     * 懒加载，当使用到的时候才会执行{ }中代码
     */
    private val loginService: AddressApi by lazy {
        RetrofitUtils.instance.getApiServier(AddressApi::class.java)
    }

    override fun getAddressList(uid: String, callback: ResultCallback<ArrayList<FirstBean>>) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDisposables.add(
            RetrofitUtils.instance!!.getApiServier(AddressApi::class.java)
                .getAddressList("", uid)
                .subscribeOn(Schedulers.io())
                .map {
                    if (it.state == 1) {
                        return@map it
                    } else {
                        throw Throwable("")
                    }
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribe({info->
                    val mListData: ArrayList<FirstBean> = ArrayList()
                    for (i in 0 until info.data!!.size) {
                        val firstModel = FirstBean()
                        val listSecondModel: ArrayList<SecondBean> = ArrayList()
                        firstModel.setCheck(false)
                        firstModel.setTitle(info.data!!.get(i).depT_CODE_NAME)
                        firstModel.setListSecondModel(listSecondModel)
                        mListData!!.add(firstModel)
                        for (j in 0 until info.data!!.get(i).team!!.size) {
                            val secondModel = SecondBean()
                            val thirdModelList: ArrayList<ThirdBean> = ArrayList()
                            secondModel.setCheck(false)
                            secondModel.setTitle(info.data!!.get(i).team!!.get(j).teaM_GROUP_NAMEG)
                            secondModel.setListThirdModel(thirdModelList)
                            listSecondModel.add(secondModel)
                            for (k in 0 until info.data!!.get(i).team!!.get(j).user!!.size) {
                                val thirdModel = ThirdBean()
                                thirdModel.setCheck(false)
                                thirdModel.name =
                                    info.data!!.get(i).team!!.get(j).user!!.get(k).employeE_CODE_NAME
                                thirdModel.phone =
                                    info.data!!.get(i).team!!.get(j).user!!.get(k).employeE_CODE_PHONE
                                thirdModel.job = info.data!!.get(i).team!!.get(j).user!!.get(k).positioN_NAME
                                thirdModelList.add(thirdModel)
                            }
                        }
                    }
                    callback.onSuccess(mListData)

                }, {
                    callback.onFail("请求失败")
                })
        )

    }

    override fun getAddressListSelect(likeName: String, uid: String, callback: ResultCallback<ArrayList<FirstBean>>) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        val disposable =loginService.getAddressBook(likeName, uid)
            .subscribeOn(Schedulers.io())
            .map {
                if (it.state == 1) {
                    return@map it
                } else {
                    throw Throwable("")
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ info ->
                val mListData: ArrayList<FirstBean> = ArrayList()
                for (i in 0 until info.data!!.size) {
                    val firstModel = FirstBean()
                    val listSecondModel: ArrayList<SecondBean> = ArrayList()
                    firstModel.setCheck(false)
                    firstModel.setTitle(info.data!!.get(i).depT_CODE_NAME)
                    firstModel.setListSecondModel(listSecondModel)
                    mListData!!.add(firstModel)
                    for (j in 0 until info.data!!.get(i).team!!.size) {
                        val secondModel = SecondBean()
                        val thirdModelList: ArrayList<ThirdBean> = ArrayList()
                        secondModel.setCheck(false)
                        secondModel.setTitle(info.data!!.get(i).team!!.get(j).teaM_GROUP_NAMEG)
                        secondModel.setListThirdModel(thirdModelList)
                        listSecondModel.add(secondModel)
                        for (k in 0 until info.data!!.get(i).team!!.get(j).user!!.size) {
                            val thirdModel = ThirdBean()
                            thirdModel.setCheck(false)
                            thirdModel.name =
                                info.data!!.get(i).team!!.get(j).user!!.get(k).employeE_CODE_NAME
                            thirdModel.phone =
                                info.data!!.get(i).team!!.get(j).user!!.get(k).employeE_CODE_PHONE
                            thirdModel.job = info.data!!.get(i).team!!.get(j).user!!.get(k).positioN_NAME
                            thirdModelList.add(thirdModel)
                        }
                    }
                }
                callback.onSuccess(mListData)
            }, {
                callback.onFail("请求失败")
            })
        mDisposables.add(disposable)
    }

    override fun onClear() {
        mDisposables.clear()
    }
}