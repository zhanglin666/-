package cn.kc.trainman_apply.reported_data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.kc.add_apply.R

/**
 * 作者： Abel .
 * 日期：2019/9/5
 * 说明：
 */
class QueryInfoAdapter(private val mContext: Context) : RecyclerView.Adapter<QueryInfoAdapter.ViewHolder>() {

    private var list: List<String>? = null

    fun setData(list: List<String>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueryInfoAdapter.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_query_info_rcy, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = 1
//    override fun getItemCount() = list!!.size

    override fun onBindViewHolder(holder: QueryInfoAdapter.ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}