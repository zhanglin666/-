package cn.kc.add_apply.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
public class TrainAllBean {

    /**
     * state : 1
     * message : 获取车次信息成功！
     * data : [{"TRAIN_NAMES":"K1178","ID":83},{"TRAIN_NAMES":"K1177","ID":61}]
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
         * TRAIN_NAMES : K1178
         * ID : 83
         */

        private String TRAIN_NAMES;
        private int ID;

        public String getTRAIN_NAMES() {
            return TRAIN_NAMES;
        }

        public void setTRAIN_NAMES(String TRAIN_NAMES) {
            this.TRAIN_NAMES = TRAIN_NAMES;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    }
}
