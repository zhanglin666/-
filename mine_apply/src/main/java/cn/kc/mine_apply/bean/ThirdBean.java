package cn.kc.mine_apply.bean;

/**
 * author:Created by LiangSJ
 * date: 2017/9/8.
 * description:？
 */

public class ThirdBean {
    private boolean isCheck;
    private String name;
    private String job;
    private String phone;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThirdBean() {

    }

    public ThirdBean(boolean isCheck, String name) {

        this.isCheck = isCheck;
        this.name = name;
    }
}
