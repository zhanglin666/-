package cn.kc.add_apply.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/9/19
 * 说明：
 */
public class TimSort {

    /**
     * state : 1
     * message : 获取添乘类别成功！
     * data : [{"ID":3,"NAME":"本部门自查"},{"ID":4,"NAME":"本班组自查"},{"ID":1,"NAME":"段检查组"},{"ID":2,"NAME":"干部包保"}]
     */

    private String state;
    private String message;
    private List<DataBean> data;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ID : 3.0
         * NAME : 本部门自查
         */

        private double ID;
        private String NAME;

        public double getID() {
            return ID;
        }

        public void setID(double ID) {
            this.ID = ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }
}
