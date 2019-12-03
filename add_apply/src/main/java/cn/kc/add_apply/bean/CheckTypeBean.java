package cn.kc.add_apply.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/9/19
 * 说明：
 */
public class CheckTypeBean {

    /**
     * state : 1
     * message : 获取检查类别成功！
     * data : [{"ID":7,"NAME":"静态"},{"ID":8,"NAME":"折返站"},{"ID":1,"NAME":"终到"},{"ID":0,"NAME":"始发"},{"ID":3,"NAME":"出乘"},{"ID":2,"NAME":"学习"},{"ID":4,"NAME":"夜查"},{"ID":5,"NAME":"库停"},{"ID":9,"NAME":"库停（折返站）"},{"ID":6,"NAME":"途中"}]
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
         * ID : 7
         * NAME : 静态
         */

        private int ID;
        private String NAME;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
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
