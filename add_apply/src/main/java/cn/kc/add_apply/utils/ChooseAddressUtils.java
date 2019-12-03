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
 * 日期：2019/9/9
 * 说明：
 */
public class ChooseAddressUtils {
    private static OptionsPickerView pvOptions;//时间选择器

    public static void showAddressDialog(Context context, final ArrayList<String> address, final AddressListener addressListener) {
        //条件选择器
        pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                addressListener.getAddress(address.get(options1));
            }
        }).setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setSubCalSize(26)
                .setContentTextSize(26)
                .setOutSideCancelable(false)
//                .setLayoutRes(R.layout.item_address_pickerview, new CustomListener() {
//
//                    @Override
//                    public void customLayout(View v) {
//                        final TextView tvSubmit = v.findViewById(R.id.tv_finish);
//                        TextView ivCancel = v.findViewById(R.id.iv_cancel);
//                        tvSubmit.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                pvOptions.returnData();
//                                pvOptions.dismiss();
//                            }
//                        });
//                        ivCancel.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                pvOptions.dismiss();
//                            }
//                        });
//                    }
//                })
                .build();
        pvOptions.setPicker(address);
        pvOptions.show();
    }

    public static void hideAddressDialog() {
        if (pvOptions != null) {
            pvOptions.dismiss();
        }
    }

    public interface AddressListener {
        void getAddress(String address);
    }
}

