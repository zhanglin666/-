package cn.kc.integrated_service.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/8/6
 * 说明：
 */
public class CommandClassifyBean implements Serializable {

    /**
     * state : 1
     * data : [{"COMMAND_TYPE_ID":"14","COMMAND_TYPE_NAME":"套跑","COMMAND_NOTE":null},{"COMMAND_TYPE_ID":"2","COMMAND_TYPE_NAME":"甩挂","COMMAND_NOTE":null},{"COMMAND_TYPE_ID":"3","COMMAND_TYPE_NAME":"抄送","COMMAND_NOTE":null}]
     */

    private int state;
    private List<DataBean> data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * COMMAND_TYPE_ID : 14
         * COMMAND_TYPE_NAME : 套跑
         * COMMAND_NOTE : null
         */

        private String COMMAND_TYPE_ID;
        private String COMMAND_TYPE_NAME;
        private String COMMAND_NOTE;

        public String getCOMMAND_TYPE_ID() {
            return COMMAND_TYPE_ID;
        }

        public void setCOMMAND_TYPE_ID(String COMMAND_TYPE_ID) {
            this.COMMAND_TYPE_ID = COMMAND_TYPE_ID;
        }

        public String getCOMMAND_TYPE_NAME() {
            return COMMAND_TYPE_NAME;
        }

        public void setCOMMAND_TYPE_NAME(String COMMAND_TYPE_NAME) {
            this.COMMAND_TYPE_NAME = COMMAND_TYPE_NAME;
        }

        public String getCOMMAND_NOTE() {
            return COMMAND_NOTE;
        }

        public void setCOMMAND_NOTE(String COMMAND_NOTE) {
            this.COMMAND_NOTE = COMMAND_NOTE;
        }
    }
}
