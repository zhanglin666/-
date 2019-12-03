package cn.kc.trainman_apply.utils

import android.content.Context
import android.view.View
import cn.kc.moduleutils.util.Logs
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.bigkoo.pickerview.view.TimePickerView
import java.text.SimpleDateFormat
import java.util.*

/**
 * 作者： Abel .
 * 日期：2019/9/9
 * 说明：
 */
class ChooseDateUtils {
    companion object {
        var pvTime: TimePickerView? = null
        fun showTimeDialog(context: Context, dateListener: DateListener) {
            val selectedDate = Calendar.getInstance()
            val startDate = Calendar.getInstance()
            val endDate = Calendar.getInstance()
            startDate.set(2019, 0, 1)
//            endDate.set(2020, 11, 31)
            val month = endDate.get(Calendar.MONTH)//获取当前月
            endDate.set(endDate.get(Calendar.YEAR), month, 31)
            pvTime = TimePickerBuilder(context, object : OnTimeSelectListener {
                override fun onTimeSelect(date: Date?, v: View?) {
                    getTime(date)?.let { dateListener.getDate(it) }
                    Logs.e("date=${getTime(date)}")
                }
            }).setContentTextSize(26)
                .setType(booleanArrayOf(true, true, true, true, true, true))// 默认全部显示
//                .setLayoutRes(R.layout.item_time_pickerview, object : CustomListener{
//                    override fun customLayout(v: View?) {
//
//                    }
//                })
                .setSubCalSize(26)
                .setOutSideCancelable(false)
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .build()
            pvTime!!.show()

        }

        fun hideTimeDialog() {
            if (pvTime != null) {
                pvTime!!.dismiss()
            }
        }

        fun getTime(date: Date?): String? {
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return format.format(date)
        }
    }

    interface DateListener {
        fun getDate(date: String)
    }
}