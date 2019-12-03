package cn.kc.integrated_service.adapter;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.kc.integrated_service.R;

/**
 * 作者： Abel .
 * 日期：2019/8/12
 * 说明：
 */
public class SpinnerAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayMap<String, String> mDataList;

    public SpinnerAdapter(Context mContext, ArrayMap<String, String> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null) {
            mHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_spinner, null, true);
            mHolder.txt = convertView.findViewById(R.id.txt_view);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }

        mHolder.txt.setText(mDataList.valueAt(position));
        return convertView;
    }

    class ViewHolder {
         TextView txt;
    }
}
