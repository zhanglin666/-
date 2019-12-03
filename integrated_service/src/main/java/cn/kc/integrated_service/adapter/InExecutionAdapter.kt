package cn.kc.trainman_apply.dispatchingcommand.adapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.kc.integrated_service.R
import cn.kc.integrated_service.bean.InExecutionBeanIng
import cn.kc.moduleutils.http.Constant
import com.bumptech.glide.Glide

/**
 * 作者： Abel .
 * 日期：2019/9/3
 * 说明：
 */
class InExecutionAdapter (private val mContext: Context) :
    RecyclerView.Adapter<InExecutionAdapter.ViewHolder>() {
    private var list: List<InExecutionBeanIng.DataBean>? = null

    private var mListener : ((Int) -> Unit)? = null

    fun setData(list: List<InExecutionBeanIng.DataBean>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_noreceive_rcy,
            parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list!![position]
        var imgUrl = data.commanD_IMG_PATH.split(",")
        holder.add_img.removeAllViews()
        for (i in 0 until imgUrl.size){
            val img = ImageView(mContext)
            img.scaleType = ImageView.ScaleType.FIT_XY
            img.setLayoutParams(LinearLayout.LayoutParams(90, 90))
            holder.add_img.addView(img)
            Glide.with(mContext)
                .load(Constant.mSERVERADDRESS + imgUrl[i])
                .into(img)
        }
        holder.command_num.text = data.commadN_CODE
        holder.command_type.text = data.commadN_CLASSIFY
        holder.command_time.text = data.creatE_TIME
        holder.command_times.text = data.commanD_VALIDTIMEE
        holder.command_content.text = Html.fromHtml(data.commadN_CONTENT)
        holder.command_word.text = data.commanD_FILE_PATH
        holder.command_ap.text = data.resolvE_CONTENT
        if (data.commanD_ACCEPTSTATE.equals("1")) {
            holder.command_stats.text = "未接收"
        } else if (data.commanD_ACCEPTSTATE.equals("2")) {
            holder.command_stats.text = "执行中"
        } else if (data.commanD_ACCEPTSTATE.equals("3")) {
            holder.command_stats.text = "超时未完成"
        } else if (data.commanD_ACCEPTSTATE.equals("4")) {
            holder.command_stats.text = "已完成"
        }
        holder.btn_command.text="完成"
        holder?.btn_command?.setOnClickListener {
            mListener?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var command_num: TextView
        internal var command_type: TextView
        internal var command_time: TextView
        internal var command_times: TextView
        internal var command_content: TextView
        internal var command_ap: TextView
        internal var command_stats: TextView
        internal var command_word: TextView
        internal var btn_command: Button
        internal var add_img: LinearLayout

        init {
            command_num = itemView.findViewById(R.id.command_num)
            command_type = itemView.findViewById(R.id.command_type)
            command_time = itemView.findViewById(R.id.command_time)
            command_times = itemView.findViewById(R.id.command_times)
            command_content = itemView.findViewById(R.id.command_content)
            command_ap = itemView.findViewById(R.id.command_ap)
            command_stats = itemView.findViewById(R.id.command_stats)
            command_word = itemView.findViewById(R.id.command_word)
            btn_command = itemView.findViewById(R.id.btn_command)
            add_img = itemView.findViewById(R.id.add_img)
        }
    }

    fun setOnItemClickListener(mListener : (position : Int) -> Unit){
        this.mListener = mListener
    }
}