package cn.kc.mine_apply.bean;


import java.io.Serializable;
import java.util.List;

/**
 * author:Created by LiangSJ
 * date: 2017/9/7.
 * description:？
 */

public class FirstBean implements Serializable {
    private static final long serialVersionUID = -3926718888847279140L;
    private boolean isCheck;
    private String title;
    private List<SecondBean> listSecondModel;

    public FirstBean() {
    }

    public boolean isCheck() {

        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public List<SecondBean> getListSecondModel() {
        return listSecondModel;
    }

    public void setListSecondModel(List<SecondBean> listSecondModel) {
        this.listSecondModel = listSecondModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FirstBean(boolean isCheck, String title, List<SecondBean> listSecondModel) {
        this.isCheck = isCheck;
        this.title = title;
        this.listSecondModel = listSecondModel;
    }
}
