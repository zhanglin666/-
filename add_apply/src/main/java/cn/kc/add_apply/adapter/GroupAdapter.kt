package cn.kc.trainman_apply.reported_data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R
import cn.kc.add_apply.bean.GroupBean

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class GroupAdapter (private val mContext: Context) :
    RecyclerView.Adapter<GroupAdapter.ViewHolder>() {
    var dataList: ArrayList<GroupBean.DataBean>? = null

    fun setData(data: ArrayList<GroupBean.DataBean>) {
        this.dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_data_rd, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = dataList!!.get(position).teaM_GROUP_NAME
        holder.txt_rd_content.text = content
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

        init {
            txt_rd_content = itemView.findViewById(R.id.txt_rd_content)
            rd_item_click = itemView.findViewById(R.id.rd_item_click)
        }
    }

    interface ItemClickListener {
        fun getItemContent(position: Int)
    }

     fun getItemClickListener(clickListener: ItemClickListener) {
        this.mItemClickListener = clickListener

    }

    private var mItemClickListener: ItemClickListener? = null
}