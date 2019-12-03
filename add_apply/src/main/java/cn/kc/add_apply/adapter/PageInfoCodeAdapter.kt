package cn.kc.trainman_apply.reported_data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.add_apply.bean.PageInfoCodeBean

/**
 * 作者： Abel .
 * 日期：2019/9/11
 * 说明：
 */
class PageInfoCodeAdapter  (private val mContext: Context) :
    RecyclerView.Adapter<PageInfoCodeAdapter.ViewHolder>() {
    var dataList: ArrayList<PageInfoCodeBean.DataBean>? = null

    fun setData(data: ArrayList<PageInfoCodeBean.DataBean>) {
        this.dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_page_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = dataList!!.get(position).infO_NAME
        holder.txt_rd_content.text = content
        holder.info_code_num.text=dataList!!.get(position).infO_CODE
        holder.info_code_level.text=dataList!!.get(position).infO_LEVEL_NAME
        holder.info_code_type.text=dataList!!.get(position).infO_SORT_NAME
        mItemClickListener.let {
            holder.rd_item_click.setOnClickListener {
                mItemClickListener!!.getItemContent(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var txt_rd_content: TextView
        internal var rd_item_click: LinearLayout
        internal var info_code_num: TextView
        internal var info_code_level: TextView
        internal var info_code_type: TextView


        init {
            txt_rd_content = itemView.findViewById(R.id.txt_rd_content)
            rd_item_click = itemView.findViewById(R.id.rd_item_click)
            info_code_num = itemView.findViewById(R.id.info_code_num)
            info_code_level = itemView.findViewById(R.id.info_code_level)
            info_code_type = itemView.findViewById(R.id.info_code_type)
        }
    }

    interface ItemClickListener {
        fun getItemContent(position: Int)
    }

    public fun getItemClickListener(clickListener: ItemClickListener) {
        this.mItemClickListener = clickListener

    }

    private var mItemClickListener: ItemClickListener? = null
}