package cn.kc.add_apply.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/9/19
 * 说明：
 */
public class EmployeeByIDBean {

    /**
     * state : 1
     * message : 获取人员信息成功！
     * data : [{"EMPLOYEE_CODE_SBNO":"245400","EMPLOYEE_CODE_NAME":"白月皓","DEPT_CODE_NAME":"北京车队","TEAM_GROUP_NAME":"京五组"}]
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
         * EMPLOYEE_CODE_SBNO : 245400
         * EMPLOYEE_CODE_NAME : 白月皓
         * DEPT_CODE_NAME : 北京车队
         * TEAM_GROUP_NAME : 京五组
         */

        private String EMPLOYEE_CODE_SBNO;
        private String EMPLOYEE_CODE_NAME;
        private String DEPT_CODE_NAME;
        private String TEAM_GROUP_NAME;

        public String getEMPLOYEE_CODE_SBNO() {
            return EMPLOYEE_CODE_SBNO;
        }

        public void setEMPLOYEE_CODE_SBNO(String EMPLOYEE_CODE_SBNO) {
            this.EMPLOYEE_CODE_SBNO = EMPLOYEE_CODE_SBNO;
        }

        public String getEMPLOYEE_CODE_NAME() {
            return EMPLOYEE_CODE_NAME;
        }

        public void setEMPLOYEE_CODE_NAME(String EMPLOYEE_CODE_NAME) {
            this.EMPLOYEE_CODE_NAME = EMPLOYEE_CODE_NAME;
        }

        public String getDEPT_CODE_NAME() {
            return DEPT_CODE_NAME;
        }

        public void setDEPT_CODE_NAME(String DEPT_CODE_NAME) {
            this.DEPT_CODE_NAME = DEPT_CODE_NAME;
        }

        public String getTEAM_GROUP_NAME() {
            return TEAM_GROUP_NAME;
        }

        public void setTEAM_GROUP_NAME(String TEAM_GROUP_NAME) {
            this.TEAM_GROUP_NAME = TEAM_GROUP_NAME;
        }
    }
}
