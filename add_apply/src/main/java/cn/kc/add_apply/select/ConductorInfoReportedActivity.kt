package cn.kc.trainman_apply.reported_data.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import cn.kc.add_apply.R
import cn.kc.add_apply.bean.EmployeeByIDBean
import cn.kc.add_apply.bean.TimSort
import cn.kc.add_apply.utils.ChooseAddressUtils
import cn.kc.add_apply.utils.ChooseTimeSortUtils
import cn.kc.add_apply.utils.ChooseXiaoHaoUtils
import cn.kc.trainman_apply.reported_data.preserter.InfoReportedIPreserter
import cn.kc.trainman_apply.reported_data.preserter.InfoReportedPreserter
import cn.kc.trainman_apply.reported_data.view.InfoReportedView
import cn.kc.trainman_apply.utils.ChooseDateUtils
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.util.Logs
import cn.kc.moduleutils.util.ToastUtil
import cn.kc.moduleutils.view.WeiboDialogUtils
import kotlinx.android.synthetic.main.activity_info_reported.*
import kotlin.collections.ArrayList

/**
 * 作者： Abel .
 * 日期：2019/9/6
 * 说明：列车长信息上报
 */
class ConductorInfoReportedActivity : BaseActivity(), View.OnClickListener, InfoReportedView {

    lateinit var mXiaoHao: ArrayList<String>
    lateinit var mTrainStation: ArrayList<String>
    val INTENT_ZEREN_BUMEN = 0
    val INTENT_ZEREN_BANZU = 1
    val INTENT_CHECK_PERSON = 2
    val INTENT_CHECK_TYPE = 3
    val INTENT_CHECK_TRAIN = 4
    val INTENT_CHECK_EMPLOYEE = 5
    val INTENT_CHECK_TIM_SORT = 6
    val INTENT_CHECK_TRAIN_NUM = 7
    val INTENT_CHECK_PAGE_INFOCODE = 8
    var depT_CODE_ID: String? = null
    var teaM_GROUP_ID: String? = null
    lateinit var mPreserter: InfoReportedIPreserter
    var mDialog: Dialog? = null
    lateinit var mDeptName: String//部门名称
    lateinit var mGroupName: String//班组名称
    val mTimSortdataList: ArrayList<String> = ArrayList()//添乘类别数据


    override fun getLayout() = R.layout.activity_info_reported

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        mPreserter = InfoReportedPreserter(this)
        lifecycle.addObserver(mPreserter)
        mPreserter!!.getEmployeeByID(Constant.mEMPLOYEECODESBNO)
        mPreserter?.getTimSortType()

        edt_beizhu.setInputType(InputType.TYPE_NULL)   //禁止键盘输入
        edt_cuoshi.setInputType(InputType.TYPE_NULL)

        init()
    }

    override fun initData() {
        real_name.text = Constant.mREALNAME
        txt_check_person.text = Constant.mREALNAME
        mXiaoHao = ArrayList()
        mXiaoHao.add("已销号")
        mXiaoHao.add("未销号")
    }

    fun init() {
        back_info_reported.setOnClickListener { onBackPressed() }

        startTime.setOnClickListener(this)
        endTime.setOnClickListener(this)
        address_start.setOnClickListener(this)
        address_end.setOnClickListener(this)
        zeren_group.setOnClickListener(this)
        zeren_banzu.setOnClickListener(this)
        check_person.setOnClickListener(this)
        check_type.setOnClickListener(this)
        fasheng_time.setOnClickListener(this)
        checi.setOnClickListener(this)
        zeren_person.setOnClickListener(this)
        zhenggai_qixian.setOnClickListener(this)
        xiaohao_qingkuang.setOnClickListener(this)
        tiancheng_type.setOnClickListener(this)
        chexianghao.setOnClickListener(this)
        xinxidian.setOnClickListener(this)
        edt_beizhu.setOnClickListener(this)
    }

    override fun showDialog() {
        mDialog = WeiboDialogUtils.createLoadingDialog(this, "加载中..")
    }

    override fun hideDialog() {
        WeiboDialogUtils.closeDialog(mDialog)
    }

    override fun getData(msg: EmployeeByIDBean.DataBean) {
        mDeptName = msg.depT_CODE_NAME.toString()
        mGroupName = msg.teaM_GROUP_NAME.toString()
        ckeck_bumen.text = mDeptName
    }

    override fun getTimSortData(msg: ArrayList<TimSort.DataBean>) {
        for (i in 0 until msg.size) {
            mTimSortdataList.add(msg.get(i).name.toString())
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.startTime -> { //检查时间
                ChooseDateUtils.showTimeDialog(this, object : ChooseDateUtils.DateListener {
                    override fun getDate(date: String) {
                        startTime.text = date
                    }
                })
            }
            R.id.endTime -> { //检查时间
                ChooseDateUtils.showTimeDialog(this, object : ChooseDateUtils.DateListener {
                    override fun getDate(date: String) {
                        endTime.text = date
                    }
                })
            }
            R.id.address_start -> {//发生区段
                if (txt_train_name.text.length != 0) {
                    ChooseAddressUtils.showAddressDialog(
                        this,
                        mTrainStation,
                        object : ChooseAddressUtils.AddressListener {
                            override fun getAddress(address: String?) {
                                address_start.text = address
                            }
                        })
                } else {
                    ToastUtil.showToast(this, "请选择车次")
                }
            }
            R.id.address_end -> {//发生区段
                if (txt_train_name.text.length != 0) {
                    ChooseAddressUtils.showAddressDialog(
                        this,
                        mTrainStation,
                        object : ChooseAddressUtils.AddressListener {
                            override fun getAddress(address: String?) {
                                address_end.text = address
                            }
                        })
                } else {
                    ToastUtil.showToast(this, "请选择车次")
                }
            }
            R.id.zeren_group -> {//责任部门
                val intentBuMen = Intent(this, ResponsibleDepartmentActivity::class.java)
                startActivityForResult(intentBuMen, INTENT_ZEREN_BUMEN)
            }
            R.id.zeren_banzu -> {//责任班组
                if (txt_zerenbumen.text.toString().length != 0) {
                    val intentBanZu = Intent(this, ResponsibleGroupActivity::class.java)
                    intentBanZu.putExtra("depT_CODE_ID", depT_CODE_ID)
                    startActivityForResult(intentBanZu, INTENT_ZEREN_BANZU)
                } else {
                    ToastUtil.showToast(this, "请选择责任部门")
                }
            }
            R.id.check_person -> {//检查人
                if (txt_zerenbumen.text.length == 0) {
                    ToastUtil.showToast(this, "请选择责任部门")
                    return
                }
                if (txt_banzu.text.length == 0) {
                    ToastUtil.showToast(this, "请选择责任班组")
                    return
                }
                val intentCheckPerson = Intent(this, CheckPersonActivity::class.java)
                startActivityForResult(intentCheckPerson, INTENT_CHECK_PERSON)
            }
            R.id.check_type -> { //检查类别
                val intentCheckType = Intent(this, CheckTypeActivity::class.java)
                startActivityForResult(intentCheckType, INTENT_CHECK_TYPE)
            }
            R.id.fasheng_time -> {//发生时间
                ChooseDateUtils.showTimeDialog(this, object : ChooseDateUtils.DateListener {
                    override fun getDate(date: String) {
                        txt_fasheng_time.text = date
                    }
                })
            }
            R.id.checi -> { //车次
                val intentTrain = Intent(this, TrainAllActivity::class.java)
                intentTrain.putExtra("deptName", mDeptName)
                intentTrain.putExtra("groupName", mGroupName)
                startActivityForResult(intentTrain, INTENT_CHECK_TRAIN)
            }
            R.id.zeren_person -> {//责任人
                if (txt_zerenbumen.text.length == 0) {
                    ToastUtil.showToast(this, "请选择责任部门")
                    return
                }
                if (txt_banzu.text.length == 0) {
                    ToastUtil.showToast(this, "请选择责任班组")
                    return
                }
                val intentEmp = Intent(this, EmployeeActivity::class.java)
                intentEmp.putExtra("deptName", depT_CODE_ID)
                intentEmp.putExtra("groupName", teaM_GROUP_ID)
                startActivityForResult(intentEmp, INTENT_CHECK_EMPLOYEE)
            }
            R.id.zhenggai_qixian -> { //整改期限
                ChooseDateUtils.showTimeDialog(this, object : ChooseDateUtils.DateListener {
                    override fun getDate(date: String) {
                        txt_zhenggai_qixian.text = date
                    }
                })
            }
            R.id.xiaohao_qingkuang -> { //销号情况
                ChooseXiaoHaoUtils.showXiaoHaoDialog(this, mXiaoHao, object : ChooseXiaoHaoUtils.XiaHaoListener {
                    override fun getMsg(msg: String?) {
                        txt_xiaohao.text = msg
                    }
                })
            }
            R.id.tiancheng_type -> {  //添乘类别mTimSortdataList
                ChooseTimeSortUtils.showTimSortDialog(
                    this,
                    mTimSortdataList,
                    object : ChooseTimeSortUtils.TimSortListener {
                        override fun getType(msg: String?) {
                            tim_sort_name.text = msg
                        }
                    })
            }
            R.id.chexianghao -> { //车厢号
                val intentEmp = Intent(this, TrainBoxNumActivity::class.java)
                startActivityForResult(intentEmp, INTENT_CHECK_TRAIN_NUM)
            }
            R.id.xinxidian -> { //信息点
                val intentEmp = Intent(this, PageInfoCodeActivity::class.java)
                startActivityForResult(intentEmp, INTENT_CHECK_PAGE_INFOCODE)
            }
            R.id.edt_beizhu -> {
                edt_beizhu.setInputType(InputType.TYPE_CLASS_TEXT)// 允许键盘输入
//                ll_one.isFocusable = true
//                ll_one.isFocusableInTouchMode = true
            }
            else -> {
                Logs.e("else..")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 0) {
            if (requestCode == INTENT_ZEREN_BUMEN) {
                val depT_CODE_NAME = data?.getStringExtra("depT_CODE_NAME")
                depT_CODE_ID = data?.getStringExtra("depT_CODE_ID")
                if (!txt_zerenbumen.text.equals(depT_CODE_NAME)) {
                    txt_banzu.text = ""
                }
                txt_zerenbumen.text = depT_CODE_NAME
            }
        }
        if (resultCode == 1) {
            if (requestCode == INTENT_ZEREN_BANZU) {
                val teaM_GROUP_NAME = data?.getStringExtra("teaM_GROUP_NAME")
                teaM_GROUP_ID = data?.getStringExtra("GroupId")
                txt_banzu.text = teaM_GROUP_NAME
            }
        }
        if (resultCode == 2) {
            if (requestCode == INTENT_CHECK_PERSON) {
                var mCheckPerson = ""
                val teaM_GROUP_NAME = data?.getStringArrayListExtra("employeE_CODE_NAME")
                for (i in 0 until teaM_GROUP_NAME!!.size) {
                    mCheckPerson += teaM_GROUP_NAME.get(i)
                    if (i != teaM_GROUP_NAME.size - 1) {
                        mCheckPerson += "-"
                    }
                }
                txt_select_check_person.text = mCheckPerson
            }
        }
        if (resultCode == 3) {
            if (requestCode == INTENT_CHECK_TYPE) {
                val checkName = data?.getStringExtra("checkName")
                txt_check_type.text = checkName
            }
        }
        if (resultCode == 4) {
            if (requestCode == INTENT_CHECK_TRAIN) {
                val trainName = data?.getStringExtra("trainName")
                mTrainStation = data?.getStringArrayListExtra("trainList") as ArrayList<String>
                txt_train_name.text = trainName
            }
        }
        if (resultCode == 5) {
            if (requestCode == INTENT_CHECK_EMPLOYEE) {
                val trainName = data?.getStringExtra("employeE_CODE_NAME")
                txt_zeren_person.text = trainName
            }
        }

//        if (resultCode == 6) {
//            if (requestCode == INTENT_CHECK_TIM_SORT) {
//                val timName = data?.getStringExtra("timSortName")
//                tim_sort_name.text = timName
//            }
//        }

        if (resultCode == 7) {
            if (requestCode == INTENT_CHECK_TRAIN_NUM) {
                val trainNum = data?.getStringExtra("trainNum")
                train_num.text = trainNum
            }
        }
        if (resultCode == 8) {
            if (requestCode == INTENT_CHECK_PAGE_INFOCODE) {
                val infoName = data?.getStringExtra("infoName")
                txt_info_name.text = infoName
            }
        }
    }

    override fun onStop() {
        super.onStop()
        ChooseDateUtils.hideTimeDialog()
        ChooseAddressUtils.hideAddressDialog()
        ChooseXiaoHaoUtils.hideXiaoHaoDialog()
    }
}