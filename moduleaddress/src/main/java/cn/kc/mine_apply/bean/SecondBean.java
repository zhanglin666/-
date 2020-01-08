package cn.kc.mine_apply.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author:Created by LiangSJ
 * date: 2017/9/7.
 * description:？
 */

public class SecondBean implements Serializable {
    private static final long serialVersionUID = -911265166304650233L;
    private boolean isCheck;
    private String title;
    private List<ThirdBean> listThirdModel;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ThirdBean> getListThirdModel() {
        return listThirdModel;
    }

    public void setListThirdModel(List<ThirdBean> listThirdModel) {
        this.listThirdModel = listThirdModel;
    }

    public SecondBean(boolean isCheck, String title, List<ThirdBean> listThirdModel) {

        this.isCheck = isCheck;
        this.title = title;
        this.listThirdModel = listThirdModel;
    }

    public SecondBean() {
    }
}
