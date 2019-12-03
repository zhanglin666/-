package cn.kc.add_apply.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;

import java.util.ArrayList;

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
public class ChooseXiaoHaoUtils {
    private static OptionsPickerView pvOptions;//时间选择器

    public static void showXiaoHaoDialog(Context context, final ArrayList<String> msg, final XiaHaoListener addressListener) {
        //条件选择器
        pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                addressListener.getMsg(msg.get(options1));
            }
        }).setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setSubCalSize(26)
                .setContentTextSize(26)
                .setOutSideCancelable(false)
                .build();
        pvOptions.setPicker(msg);
        pvOptions.show();
    }

    public static void hideXiaoHaoDialog() {
        if (pvOptions != null) {
            pvOptions.dismiss();
        }
    }

    public interface XiaHaoListener {
        void getMsg(String msg);
    }
}
