package cn.kc.add_apply.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.kc.add_apply.R;
import cn.kc.add_apply.bean.CheckPersonBean;
import cn.kc.add_apply.view.ItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 作者： Abel .
 * 日期：2019/9/11
 * 说明：
 */
public class CheckPersonAdapter extends RecyclerView.Adapter<CheckPersonAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<CheckPersonBean.DataBean> dataList;
    public HashMap<Integer, Boolean> isSelected;

    public CheckPersonAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<CheckPersonBean.DataBean> data) {
        this.dataList = data;
        init();
    }

    // 初始化 设置所有item都为未选择
    public void init() {
        isSelected = new HashMap<Integer, Boolean>();
        for (int i = 0; i < dataList.size(); i++) {
            isSelected.put(i, false);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_check_oerson, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String content = dataList.get(position).getEMPLOYEE_CODE_NAME();
        holder.txt_rd_content.setText(content);
        holder.ck_box_choose_person.setChecked(isSelected.get(position));
        if (holder.ck_box_choose_person.isChecked()) {
            holder.ck_box_choose_person.setBackgroundResource(R.mipmap.ic_save);
        } else {
            holder.ck_box_choose_person.setBackgroundResource(R.mipmap.mark);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.getItemContent(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_rd_content;
        CheckBox ck_box_choose_person;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_rd_content = itemView.findViewById(R.id.txt_rd_content);
            ck_box_choose_person = itemView.findViewById(R.id.ck_box_choose_person);
        }
    }

    public void getItemClickListener(ItemClickListener clickListener) {
        this.mItemClickListener = clickListener;

    }

    private ItemClickListener mItemClickListener;
}
