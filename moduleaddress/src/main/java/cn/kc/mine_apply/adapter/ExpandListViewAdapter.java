package cn.kc.mine_apply.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import cn.kc.mine_apply.R;
import cn.kc.mine_apply.bean.FirstBean;
import cn.kc.mine_apply.bean.SecondBean;
import cn.kc.moduleutils.base.BaseApplication;
import cn.kc.moduleutils.util.Dialogchoosephone;

import java.util.List;


/**
 *
 */

public class ExpandListViewAdapter extends BaseExpandableListAdapter {
    private List<FirstBean> mListData;
    private LayoutInflater mInflate;
    private Context context;

    public ExpandListViewAdapter( Context context) {
        this.context = context;
        this.mInflate = LayoutInflater.from(context);
    }

    public void setData(List<FirstBean> mListData) {
        this.mListData = mListData;
    }

    @Override
    public int getGroupCount() {
        return mListData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListData.get(groupPosition).getListSecondModel().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        FirstHolder holder = null;
        if (convertView == null) {
            holder = new FirstHolder();
            convertView = mInflate.inflate(R.layout.item_expand_lv_first, parent, false);
            holder.tv = (convertView.findViewById(R.id.tv));
            holder.first_rl = convertView.findViewById(R.id.first_rl);
            holder.img_icon = convertView.findViewById(R.id.img_icon);
            convertView.setTag(holder);
        } else {
            holder = (FirstHolder) convertView.getTag();
        }
        if (isExpanded) {
            holder.img_icon.setBackgroundResource(R.mipmap.ic_save);
        } else {
            holder.img_icon.setBackgroundResource(R.mipmap.mark);
        }
        holder.tv.setText(mListData.get(groupPosition).getTitle());
        final FirstHolder finalHolder = holder;
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CustomExpandableListView lv = ((CustomExpandableListView) convertView);
        if (convertView == null) {
            lv = new CustomExpandableListView(context);
        }
        lv.setChoiceMode(ExpandableListView.CHOICE_MODE_SINGLE);

        final SecondAdapter secondAdapter = new SecondAdapter(context, mListData.get(groupPosition).getListSecondModel());
        lv.setAdapter(secondAdapter);

        return lv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    /*
     *   第二层的适配器
     * */
    public class SecondAdapter extends BaseExpandableListAdapter {
        Context context;
        LayoutInflater inflater;
        List<SecondBean> listSecondModel;

        public SecondAdapter(Context context, List<SecondBean> listSecondModel) {
            this.context = context;
            this.listSecondModel = listSecondModel;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getGroupCount() {
            int size = listSecondModel.size();
            return size;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return listSecondModel.get(groupPosition).getListThirdModel().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return listSecondModel.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return listSecondModel.get(groupPosition).getListThirdModel().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            SecondHolder holder = null;
            if (convertView == null) {
                holder = new SecondHolder();
                convertView = mInflate.inflate(R.layout.item_expand_lv_second, parent, false);
                holder.tv = (convertView.findViewById(R.id.tv));
                holder.img_icon = convertView.findViewById(R.id.img_icon);
                convertView.setTag(holder);
            } else {
                holder = (SecondHolder) convertView.getTag();
            }
            if (isExpanded) {
                holder.img_icon.setBackgroundResource(R.mipmap.ic_save);
            } else {
                holder.img_icon.setBackgroundResource(R.mipmap.mark);
            }
            holder.tv.setText(listSecondModel.get(groupPosition).getTitle());
            final SecondHolder secondHolder = holder;
            return convertView;
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ThirdHolder holder = null;

            if (convertView == null) {
                holder = new ThirdHolder();
                convertView = mInflate.inflate(R.layout.item_expand_lv_third, parent, false);
                holder.tv = (convertView.findViewById(R.id.tv));
                holder.job_title = convertView.findViewById(R.id.job_title);
                holder.rl_third = convertView.findViewById(R.id.rl_third);
                holder.phone_num = convertView.findViewById(R.id.phone_num);
                holder.cb = convertView.findViewById(R.id.cb);
                convertView.setTag(holder);
            } else {
                holder = (ThirdHolder) convertView.getTag();
            }
            holder.tv.setText(listSecondModel.get(groupPosition).getListThirdModel().get(childPosition).getName());
            holder.job_title.setText(listSecondModel.get(groupPosition).getListThirdModel().get(childPosition).getJob());
            holder.phone_num.setText(listSecondModel.get(groupPosition).getListThirdModel().get(childPosition).getPhone());
            final ThirdHolder thirdHolder = holder;
            thirdHolder.rl_third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseApplication.Companion.getPreferences()
                            .setJobNum(listSecondModel.get(groupPosition).getListThirdModel()
                                    .get(childPosition).getPhone());
                    new Dialogchoosephone((Activity) context) {
                        @Override
                        public void btnPickBySelect() {
                            if (mOnItemChick != null) {
                                mOnItemChick.onItemClickListen(1);
                            }
                        }

                        @Override
                        public void btnPickByTake() {
                            if (null != mOnItemChick) {
                                mOnItemChick.onItemClickListen(2);
                            }
                        }
                    }.show();
                }
            });
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }


    class FirstHolder {
        TextView tv;
        RelativeLayout first_rl;
        ImageView img_icon;
    }

    class SecondHolder {
        TextView tv;
        ImageView img_icon;
    }

    class ThirdHolder {
        TextView tv;
        TextView job_title;
        TextView phone_num;
        RelativeLayout rl_third;
        CheckBox cb;
    }

    public interface OnItemChick {
        void onItemClickListen(int groupPosition);
    }

    private OnItemChick mOnItemChick;

    public void setmOnItemChick(OnItemChick onItemChick) {
        this.mOnItemChick = onItemChick;
    }
}
