package cn.kc.mine_apply.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/8/6
 * 说明：
 */
public class AddressListSearchBean {

    /**
     * state : 1
     * data : [{"TEAM":[{"TEAM_CODE_ID":"AAAA39B03099466686D5AA015B5A2D185","TEAM_GROUP_NAMEG":"未分配","USER":[{"EMPLOYEE_CODE_ID":"86171DEABACFF897E050D70A09E072FC","EMPLOYEE_CODE_NAME":"高金梅","EMPLOYEE_CODE_PHONE":"17795081348","POSITION_NAME":""}]}],"DEPT_CODE_ID":"F84A39B03099466686D5AA015B5A2D83","DEPT_CODE_NAME":"未分配"}]
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
         * TEAM : [{"TEAM_CODE_ID":"AAAA39B03099466686D5AA015B5A2D185","TEAM_GROUP_NAMEG":"未分配","USER":[{"EMPLOYEE_CODE_ID":"86171DEABACFF897E050D70A09E072FC","EMPLOYEE_CODE_NAME":"高金梅","EMPLOYEE_CODE_PHONE":"17795081348","POSITION_NAME":""}]}]
         * DEPT_CODE_ID : F84A39B03099466686D5AA015B5A2D83
         * DEPT_CODE_NAME : 未分配
         */

        private String DEPT_CODE_ID;
        private String DEPT_CODE_NAME;
        private List<TEAMBean> TEAM;

        public String getDEPT_CODE_ID() {
            return DEPT_CODE_ID;
        }

        public void setDEPT_CODE_ID(String DEPT_CODE_ID) {
            this.DEPT_CODE_ID = DEPT_CODE_ID;
        }

        public String getDEPT_CODE_NAME() {
            return DEPT_CODE_NAME;
        }

        public void setDEPT_CODE_NAME(String DEPT_CODE_NAME) {
            this.DEPT_CODE_NAME = DEPT_CODE_NAME;
        }

        public List<TEAMBean> getTEAM() {
            return TEAM;
        }

        public void setTEAM(List<TEAMBean> TEAM) {
            this.TEAM = TEAM;
        }

        public static class TEAMBean {
            /**
             * TEAM_CODE_ID : AAAA39B03099466686D5AA015B5A2D185
             * TEAM_GROUP_NAMEG : 未分配
             * USER : [{"EMPLOYEE_CODE_ID":"86171DEABACFF897E050D70A09E072FC","EMPLOYEE_CODE_NAME":"高金梅","EMPLOYEE_CODE_PHONE":"17795081348","POSITION_NAME":""}]
             */

            private String TEAM_CODE_ID;
            private String TEAM_GROUP_NAMEG;
            private List<USERBean> USER;

            public String getTEAM_CODE_ID() {
                return TEAM_CODE_ID;
            }

            public void setTEAM_CODE_ID(String TEAM_CODE_ID) {
                this.TEAM_CODE_ID = TEAM_CODE_ID;
            }

            public String getTEAM_GROUP_NAMEG() {
                return TEAM_GROUP_NAMEG;
            }

            public void setTEAM_GROUP_NAMEG(String TEAM_GROUP_NAMEG) {
                this.TEAM_GROUP_NAMEG = TEAM_GROUP_NAMEG;
            }

            public List<USERBean> getUSER() {
                return USER;
            }

            public void setUSER(List<USERBean> USER) {
                this.USER = USER;
            }

            public static class USERBean {
                /**
                 * EMPLOYEE_CODE_ID : 86171DEABACFF897E050D70A09E072FC
                 * EMPLOYEE_CODE_NAME : 高金梅
                 * EMPLOYEE_CODE_PHONE : 17795081348
                 * POSITION_NAME :
                 */

                private String EMPLOYEE_CODE_ID;
                private String EMPLOYEE_CODE_NAME;
                private String EMPLOYEE_CODE_PHONE;
                private String POSITION_NAME;

                public String getEMPLOYEE_CODE_ID() {
                    return EMPLOYEE_CODE_ID;
                }

                public void setEMPLOYEE_CODE_ID(String EMPLOYEE_CODE_ID) {
                    this.EMPLOYEE_CODE_ID = EMPLOYEE_CODE_ID;
                }

                public String getEMPLOYEE_CODE_NAME() {
                    return EMPLOYEE_CODE_NAME;
                }

                public void setEMPLOYEE_CODE_NAME(String EMPLOYEE_CODE_NAME) {
                    this.EMPLOYEE_CODE_NAME = EMPLOYEE_CODE_NAME;
                }

                public String getEMPLOYEE_CODE_PHONE() {
                    return EMPLOYEE_CODE_PHONE;
                }

                public void setEMPLOYEE_CODE_PHONE(String EMPLOYEE_CODE_PHONE) {
                    this.EMPLOYEE_CODE_PHONE = EMPLOYEE_CODE_PHONE;
                }

                public String getPOSITION_NAME() {
                    return POSITION_NAME;
                }

                public void setPOSITION_NAME(String POSITION_NAME) {
                    this.POSITION_NAME = POSITION_NAME;
                }
            }
        }
    }
}
