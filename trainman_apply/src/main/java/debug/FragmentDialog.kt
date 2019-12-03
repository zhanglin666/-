package debug

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import cn.kc.trainman_apply.R
import cn.kc.moduleutils.util.Logs
import kotlinx.android.synthetic.main.dialog_item.*

/**
 * 作者： Abel .
 * 日期：2019/8/23
 * 说明：
 */
open class FragmentDialog(private val mCallBack: DialogDataCallback) : androidx.fragment.app.DialogFragment(),
    View.OnClickListener {

    private lateinit var mContentView: View

    //设置宽高全屏不带标题
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth)
    }

    //设置宽高全屏带标题
//    override fun onStart() {
//        super.onStart()
//        val dm = DisplayMetrics()
//        activity?.windowManager?.defaultDisplay?.getMetrics(dm)
//        dialog.window?.setLayout(((dm.widthPixels * 0.9).toInt()), ViewGroup.LayoutParams.WRAP_CONTENT)
//    }

//    //移除标题
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        super.onCreateView(inflater, container, savedInstanceState)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        return inflater.inflate(R.layout.dialog_forward, container, false)
//    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val builder: AlertDialog.Builder =
//            AlertDialog.Builder(this!!.activity!!)
//        builder.setTitle("标题")
//            .setMessage("消息")
//            .setPositiveButton("确定", this)
//            .setNegativeButton("取消", this)
//            .setCancelable(false);
//        return builder.create()
//    }

//    override fun onClick(dialog: DialogInterface?, which: Int) {
//        val callBack: DataCallback = activity as DataCallback
//        when (which) {
//            DialogInterface.BUTTON_NEGATIVE -> {
//                callBack.getData("取消")
//            }
//            DialogInterface.BUTTON_POSITIVE -> {
//                callBack.getData("确定")
//            }
//            else -> {
//                Logs.e("else..")
//            }
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE) //去标题
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)  //背景透明
        mContentView = inflater.inflate(R.layout.dialog_item, container, false)
        Logs.e("执行oncreateview")
        return mContentView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirmButton.setOnClickListener(this)
        cancleButton.setOnClickListener(this)
        Logs.e("执行Onviewcreate")
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.confirmButton -> {
                mCallBack.confirmDialog()
            }
            R.id.cancleButton -> {
                mCallBack.cancleDialog()
            }
            else -> {
                Logs.e("else..")
            }
        }
    }

    companion object {
        lateinit var dialog: FragmentDialog
        fun showDialog(context: FragmentActivity, tag: String) {
            dialog = FragmentDialog(object :DialogDataCallback{
                override fun confirmDialog() {
                }
                override fun cancleDialog() {
                }

            })
            dialog.show(context.supportFragmentManager, tag)
        }

        fun hideDialog() {
            dialog.dismiss()
        }
    }
}

open interface DialogDataCallback {
    fun confirmDialog()
    fun cancleDialog()
}