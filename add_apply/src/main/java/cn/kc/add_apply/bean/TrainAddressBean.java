package cn.kc.add_apply.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/9/11
 * 说明：
 */
public class TrainAddressBean {

    /**
     * state : 1
     * message : 获取列车区间站信息成功！
     * data : [{"STATION_NO":1,"STATION_NAME":"银川","ARRIVE_TIME":null,"LEAVE_TIME":"16:05"},{"STATION_NO":2,"STATION_NAME":"石嘴山","ARRIVE_TIME":"16:41","LEAVE_TIME":"16:46"},{"STATION_NO":3,"STATION_NAME":"惠农","ARRIVE_TIME":"17:24","LEAVE_TIME":"17:30"},{"STATION_NO":4,"STATION_NAME":"乌海","ARRIVE_TIME":"18:05","LEAVE_TIME":"18:12"},{"STATION_NO":5,"STATION_NAME":"临河","ARRIVE_TIME":"19:46","LEAVE_TIME":"19:52"},{"STATION_NO":6,"STATION_NAME":"包头","ARRIVE_TIME":"22:04","LEAVE_TIME":"22:27"},{"STATION_NO":7,"STATION_NAME":"呼和浩特东","ARRIVE_TIME":"00:31","LEAVE_TIME":"00:53"},{"STATION_NO":8,"STATION_NAME":"集宁南","ARRIVE_TIME":"02:17","LEAVE_TIME":"02:23"},{"STATION_NO":9,"STATION_NAME":"大同","ARRIVE_TIME":"04:20","LEAVE_TIME":"04:34"},{"STATION_NO":10,"STATION_NAME":"柴沟堡","ARRIVE_TIME":"06:22","LEAVE_TIME":"06:25"},{"STATION_NO":11,"STATION_NAME":"张家口南","ARRIVE_TIME":"07:09","LEAVE_TIME":"07:15"},{"STATION_NO":12,"STATION_NAME":"宣化","ARRIVE_TIME":"07:35","LEAVE_TIME":"07:38"},{"STATION_NO":13,"STATION_NAME":"下花园","ARRIVE_TIME":"08:03","LEAVE_TIME":"08:06"},{"STATION_NO":14,"STATION_NAME":"沙城","ARRIVE_TIME":"08:35","LEAVE_TIME":"08:39"},{"STATION_NO":15,"STATION_NAME":"三家店","ARRIVE_TIME":"10:56","LEAVE_TIME":"11:21"},{"STATION_NO":16,"STATION_NAME":"北京","ARRIVE_TIME":"12:15","LEAVE_TIME":null}]
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
         * STATION_NO : 1
         * STATION_NAME : 银川
         * ARRIVE_TIME : null
         * LEAVE_TIME : 16:05
         */

        private int STATION_NO;
        private String STATION_NAME;
        private String ARRIVE_TIME;
        private String LEAVE_TIME;

        public int getSTATION_NO() {
            return STATION_NO;
        }

        public void setSTATION_NO(int STATION_NO) {
            this.STATION_NO = STATION_NO;
        }

        public String getSTATION_NAME() {
            return STATION_NAME;
        }

        public void setSTATION_NAME(String STATION_NAME) {
            this.STATION_NAME = STATION_NAME;
        }

        public String getARRIVE_TIME() {
            return ARRIVE_TIME;
        }

        public void setARRIVE_TIME(String ARRIVE_TIME) {
            this.ARRIVE_TIME = ARRIVE_TIME;
        }

        public String getLEAVE_TIME() {
            return LEAVE_TIME;
        }

        public void setLEAVE_TIME(String LEAVE_TIME) {
            this.LEAVE_TIME = LEAVE_TIME;
        }
    }
}
