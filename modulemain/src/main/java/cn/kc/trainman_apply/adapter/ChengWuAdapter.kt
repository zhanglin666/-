package cn.kc.trainman_apply.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.kc.trainman_apply.R

/**
 * 作者： Abel .
 * 日期：2020/1/6
 * 说明：
 */
class ChengWuAdapter(private val mContext: Context?) :
    RecyclerView.Adapter<ChengWuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChengWuAdapter.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_chengwu, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ChengWuAdapter.ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}