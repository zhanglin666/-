package cn.kc.integrated_service.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/8/14
 * 说明：
 */
public class NoReceiveBean {

    /**
     * state : 1
     * data : [{"COMMAND_ISSUEID":"601","COMMADN_CODE":"4484486","COMMADN_CLASSIFY":"48","COMMADN_VALIDTIMES":"0001-01-01T00:00:00","COMMAND_VALIDTIMEE":"2019-08-15T10:03:00","ISSUE_VALIDTIME":"2019-08-14T12:03:00","COMMADN_CONTENT":"<p>484654156112512356<\/p><p><br><\/p>","COMMAND_ACCEPTSTATE":"2","ISSUE_ROLE":"F84A39B03099466686D5AA015B5A2D50","CREATE_TIME":"2019-08-14T10:02:37","MANAGE_TIME":"0001-01-01T00:00:00","CC_ROLE":null,"ISBRANCH":1,"COMMAND_BRANCH":"456456465165","ISSUE_USER":"266965","ACCPET_DATE":"2019-08-14T10:03:05","ACCPET_USER":"139779","MANAGE_USER":null,"COMMAND_IMG_PATH":null,"COMMAND_FILE_PATH":null,"COMMAND_FILE_NAME":null,"COMMAND_TYPE_ID":"48","COMMAND_TYPE_NAME":"停运","COMMAND_NOTE":null,"RESOLVE_ID":"361","ISSUE_ID":"601","XF_DATE":"2019-08-14T10:02:37","EFFECTIVE_DATEE":"2019-08-15T10:03:00","RESOLVE_CONTENT":"456456465165","EFFECTIVE_TEAM":"AAAA39B03099466686D5AA015B5A2D58","COMMAND_RESOLVE_STATE":1,"COMMANDXF_ACCPET_DATE":"0001-01-01T00:00:00","COMMANDXF_COMPLETE_DATE":"0001-01-01T00:00:00","RESOLVE_USER":"139779","RACCPET_USER":null,"RMANAGE_USER":null,"TEAM_GROUP_NAME":"京五组","COMMAND_ACCEPTSTATES":"执行中","COMMAND_RESOLVE_STATES":"未接收"},{"COMMAND_ISSUEID":"581","COMMADN_CODE":"测试201908131634","COMMADN_CLASSIFY":"48","COMMADN_VALIDTIMES":"0001-01-01T00:00:00","COMMAND_VALIDTIMEE":"2019-08-13T16:55:00","ISSUE_VALIDTIME":"2019-08-13T16:35:00","COMMADN_CONTENT":"<p>1、测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634<\/p><p>2、测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634<\/p><p>3、测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634测试201908131634<\/p>","COMMAND_ACCEPTSTATE":"2","ISSUE_ROLE":"F84A39B03099466686D5AA015B5A2D50","CREATE_TIME":"2019-08-13T16:36:03","MANAGE_TIME":"0001-01-01T00:00:00","CC_ROLE":null,"ISBRANCH":1,"COMMAND_BRANCH":"命令安排给京五组处置","ISSUE_USER":"266965","ACCPET_DATE":"2019-08-13T16:38:46","ACCPET_USER":"139779","MANAGE_USER":null,"COMMAND_IMG_PATH":"/upload/Images/20190813163446.jpg","COMMAND_FILE_PATH":"/upload/Files/20190813163510.docx","COMMAND_FILE_NAME":"上线计划.docx","COMMAND_TYPE_ID":"48","COMMAND_TYPE_NAME":"停运","COMMAND_NOTE":null,"RESOLVE_ID":"341","ISSUE_ID":"581","XF_DATE":"2019-08-13T16:36:03","EFFECTIVE_DATEE":"2019-08-13T16:55:00","RESOLVE_CONTENT":"命令安排给京五组处置","EFFECTIVE_TEAM":"AAAA39B03099466686D5AA015B5A2D58","COMMAND_RESOLVE_STATE":1,"COMMANDXF_ACCPET_DATE":"0001-01-01T00:00:00","COMMANDXF_COMPLETE_DATE":"0001-01-01T00:00:00","RESOLVE_USER":"139779","RACCPET_USER":null,"RMANAGE_USER":null,"TEAM_GROUP_NAME":"京五组","COMMAND_ACCEPTSTATES":"执行中","COMMAND_RESOLVE_STATES":"未接收"}]
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
         * COMMAND_ISSUEID : 601
         * COMMADN_CODE : 4484486
         * COMMADN_CLASSIFY : 48
         * COMMADN_VALIDTIMES : 0001-01-01T00:00:00
         * COMMAND_VALIDTIMEE : 2019-08-15T10:03:00
         * ISSUE_VALIDTIME : 2019-08-14T12:03:00
         * COMMADN_CONTENT : <p>484654156112512356</p><p><br></p>
         * COMMAND_ACCEPTSTATE : 2
         * ISSUE_ROLE : F84A39B03099466686D5AA015B5A2D50
         * CREATE_TIME : 2019-08-14T10:02:37
         * MANAGE_TIME : 0001-01-01T00:00:00
         * CC_ROLE : null
         * ISBRANCH : 1
         * COMMAND_BRANCH : 456456465165
         * ISSUE_USER : 266965
         * ACCPET_DATE : 2019-08-14T10:03:05
         * ACCPET_USER : 139779
         * MANAGE_USER : null
         * COMMAND_IMG_PATH : null
         * COMMAND_FILE_PATH : null
         * COMMAND_FILE_NAME : null
         * COMMAND_TYPE_ID : 48
         * COMMAND_TYPE_NAME : 停运
         * COMMAND_NOTE : null
         * RESOLVE_ID : 361
         * ISSUE_ID : 601
         * XF_DATE : 2019-08-14T10:02:37
         * EFFECTIVE_DATEE : 2019-08-15T10:03:00
         * RESOLVE_CONTENT : 456456465165
         * EFFECTIVE_TEAM : AAAA39B03099466686D5AA015B5A2D58
         * COMMAND_RESOLVE_STATE : 1
         * COMMANDXF_ACCPET_DATE : 0001-01-01T00:00:00
         * COMMANDXF_COMPLETE_DATE : 0001-01-01T00:00:00
         * RESOLVE_USER : 139779
         * RACCPET_USER : null
         * RMANAGE_USER : null
         * TEAM_GROUP_NAME : 京五组
         * COMMAND_ACCEPTSTATES : 执行中
         * COMMAND_RESOLVE_STATES : 未接收
         */

        private String COMMAND_ISSUEID;
        private String COMMADN_CODE;
        private String COMMADN_CLASSIFY;
        private String COMMADN_VALIDTIMES;
        private String COMMAND_VALIDTIMEE;
        private String ISSUE_VALIDTIME;
        private String COMMADN_CONTENT;
        private String COMMAND_ACCEPTSTATE;
        private String ISSUE_ROLE;
        private String CREATE_TIME;
        private String MANAGE_TIME;
        private Object CC_ROLE;
        private int ISBRANCH;
        private String COMMAND_BRANCH;
        private String ISSUE_USER;
        private String ACCPET_DATE;
        private String ACCPET_USER;
        private Object MANAGE_USER;
        private String COMMAND_IMG_PATH;
        private String COMMAND_FILE_PATH;
        private Object COMMAND_FILE_NAME;
        private String COMMAND_TYPE_ID;
        private String COMMAND_TYPE_NAME;
        private Object COMMAND_NOTE;
        private String RESOLVE_ID;
        private String ISSUE_ID;
        private String XF_DATE;
        private String EFFECTIVE_DATEE;
        private String RESOLVE_CONTENT;
        private String EFFECTIVE_TEAM;
        private int COMMAND_RESOLVE_STATE;
        private String COMMANDXF_ACCPET_DATE;
        private String COMMANDXF_COMPLETE_DATE;
        private String RESOLVE_USER;
        private Object RACCPET_USER;
        private Object RMANAGE_USER;
        private String TEAM_GROUP_NAME;
        private String COMMAND_ACCEPTSTATES;
        private String COMMAND_RESOLVE_STATES;

        public String getCOMMAND_ISSUEID() {
            return COMMAND_ISSUEID;
        }

        public void setCOMMAND_ISSUEID(String COMMAND_ISSUEID) {
            this.COMMAND_ISSUEID = COMMAND_ISSUEID;
        }

        public String getCOMMADN_CODE() {
            return COMMADN_CODE;
        }

        public void setCOMMADN_CODE(String COMMADN_CODE) {
            this.COMMADN_CODE = COMMADN_CODE;
        }

        public String getCOMMADN_CLASSIFY() {
            return COMMADN_CLASSIFY;
        }

        public void setCOMMADN_CLASSIFY(String COMMADN_CLASSIFY) {
            this.COMMADN_CLASSIFY = COMMADN_CLASSIFY;
        }

        public String getCOMMADN_VALIDTIMES() {
            return COMMADN_VALIDTIMES;
        }

        public void setCOMMADN_VALIDTIMES(String COMMADN_VALIDTIMES) {
            this.COMMADN_VALIDTIMES = COMMADN_VALIDTIMES;
        }

        public String getCOMMAND_VALIDTIMEE() {
            return COMMAND_VALIDTIMEE;
        }

        public void setCOMMAND_VALIDTIMEE(String COMMAND_VALIDTIMEE) {
            this.COMMAND_VALIDTIMEE = COMMAND_VALIDTIMEE;
        }

        public String getISSUE_VALIDTIME() {
            return ISSUE_VALIDTIME;
        }

        public void setISSUE_VALIDTIME(String ISSUE_VALIDTIME) {
            this.ISSUE_VALIDTIME = ISSUE_VALIDTIME;
        }

        public String getCOMMADN_CONTENT() {
            return COMMADN_CONTENT;
        }

        public void setCOMMADN_CONTENT(String COMMADN_CONTENT) {
            this.COMMADN_CONTENT = COMMADN_CONTENT;
        }

        public String getCOMMAND_ACCEPTSTATE() {
            return COMMAND_ACCEPTSTATE;
        }

        public void setCOMMAND_ACCEPTSTATE(String COMMAND_ACCEPTSTATE) {
            this.COMMAND_ACCEPTSTATE = COMMAND_ACCEPTSTATE;
        }

        public String getISSUE_ROLE() {
            return ISSUE_ROLE;
        }

        public void setISSUE_ROLE(String ISSUE_ROLE) {
            this.ISSUE_ROLE = ISSUE_ROLE;
        }

        public String getCREATE_TIME() {
            return CREATE_TIME;
        }

        public void setCREATE_TIME(String CREATE_TIME) {
            this.CREATE_TIME = CREATE_TIME;
        }

        public String getMANAGE_TIME() {
            return MANAGE_TIME;
        }

        public void setMANAGE_TIME(String MANAGE_TIME) {
            this.MANAGE_TIME = MANAGE_TIME;
        }

        public Object getCC_ROLE() {
            return CC_ROLE;
        }

        public void setCC_ROLE(Object CC_ROLE) {
            this.CC_ROLE = CC_ROLE;
        }

        public int getISBRANCH() {
            return ISBRANCH;
        }

        public void setISBRANCH(int ISBRANCH) {
            this.ISBRANCH = ISBRANCH;
        }

        public String getCOMMAND_BRANCH() {
            return COMMAND_BRANCH;
        }

        public void setCOMMAND_BRANCH(String COMMAND_BRANCH) {
            this.COMMAND_BRANCH = COMMAND_BRANCH;
        }

        public String getISSUE_USER() {
            return ISSUE_USER;
        }

        public void setISSUE_USER(String ISSUE_USER) {
            this.ISSUE_USER = ISSUE_USER;
        }

        public String getACCPET_DATE() {
            return ACCPET_DATE;
        }

        public void setACCPET_DATE(String ACCPET_DATE) {
            this.ACCPET_DATE = ACCPET_DATE;
        }

        public String getACCPET_USER() {
            return ACCPET_USER;
        }

        public void setACCPET_USER(String ACCPET_USER) {
            this.ACCPET_USER = ACCPET_USER;
        }

        public Object getMANAGE_USER() {
            return MANAGE_USER;
        }

        public void setMANAGE_USER(Object MANAGE_USER) {
            this.MANAGE_USER = MANAGE_USER;
        }

        public String getCOMMAND_IMG_PATH() {
            return COMMAND_IMG_PATH;
        }

        public void setCOMMAND_IMG_PATH(String COMMAND_IMG_PATH) {
            this.COMMAND_IMG_PATH = COMMAND_IMG_PATH;
        }

        public String getCOMMAND_FILE_PATH() {
            return COMMAND_FILE_PATH;
        }

        public void setCOMMAND_FILE_PATH(String COMMAND_FILE_PATH) {
            this.COMMAND_FILE_PATH = COMMAND_FILE_PATH;
        }

        public Object getCOMMAND_FILE_NAME() {
            return COMMAND_FILE_NAME;
        }

        public void setCOMMAND_FILE_NAME(Object COMMAND_FILE_NAME) {
            this.COMMAND_FILE_NAME = COMMAND_FILE_NAME;
        }

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

        public Object getCOMMAND_NOTE() {
            return COMMAND_NOTE;
        }

        public void setCOMMAND_NOTE(Object COMMAND_NOTE) {
            this.COMMAND_NOTE = COMMAND_NOTE;
        }

        public String getRESOLVE_ID() {
            return RESOLVE_ID;
        }

        public void setRESOLVE_ID(String RESOLVE_ID) {
            this.RESOLVE_ID = RESOLVE_ID;
        }

        public String getISSUE_ID() {
            return ISSUE_ID;
        }

        public void setISSUE_ID(String ISSUE_ID) {
            this.ISSUE_ID = ISSUE_ID;
        }

        public String getXF_DATE() {
            return XF_DATE;
        }

        public void setXF_DATE(String XF_DATE) {
            this.XF_DATE = XF_DATE;
        }

        public String getEFFECTIVE_DATEE() {
            return EFFECTIVE_DATEE;
        }

        public void setEFFECTIVE_DATEE(String EFFECTIVE_DATEE) {
            this.EFFECTIVE_DATEE = EFFECTIVE_DATEE;
        }

        public String getRESOLVE_CONTENT() {
            return RESOLVE_CONTENT;
        }

        public void setRESOLVE_CONTENT(String RESOLVE_CONTENT) {
            this.RESOLVE_CONTENT = RESOLVE_CONTENT;
        }

        public String getEFFECTIVE_TEAM() {
            return EFFECTIVE_TEAM;
        }

        public void setEFFECTIVE_TEAM(String EFFECTIVE_TEAM) {
            this.EFFECTIVE_TEAM = EFFECTIVE_TEAM;
        }

        public int getCOMMAND_RESOLVE_STATE() {
            return COMMAND_RESOLVE_STATE;
        }

        public void setCOMMAND_RESOLVE_STATE(int COMMAND_RESOLVE_STATE) {
            this.COMMAND_RESOLVE_STATE = COMMAND_RESOLVE_STATE;
        }

        public String getCOMMANDXF_ACCPET_DATE() {
            return COMMANDXF_ACCPET_DATE;
        }

        public void setCOMMANDXF_ACCPET_DATE(String COMMANDXF_ACCPET_DATE) {
            this.COMMANDXF_ACCPET_DATE = COMMANDXF_ACCPET_DATE;
        }

        public String getCOMMANDXF_COMPLETE_DATE() {
            return COMMANDXF_COMPLETE_DATE;
        }

        public void setCOMMANDXF_COMPLETE_DATE(String COMMANDXF_COMPLETE_DATE) {
            this.COMMANDXF_COMPLETE_DATE = COMMANDXF_COMPLETE_DATE;
        }

        public String getRESOLVE_USER() {
            return RESOLVE_USER;
        }

        public void setRESOLVE_USER(String RESOLVE_USER) {
            this.RESOLVE_USER = RESOLVE_USER;
        }

        public Object getRACCPET_USER() {
            return RACCPET_USER;
        }

        public void setRACCPET_USER(Object RACCPET_USER) {
            this.RACCPET_USER = RACCPET_USER;
        }

        public Object getRMANAGE_USER() {
            return RMANAGE_USER;
        }

        public void setRMANAGE_USER(Object RMANAGE_USER) {
            this.RMANAGE_USER = RMANAGE_USER;
        }

        public String getTEAM_GROUP_NAME() {
            return TEAM_GROUP_NAME;
        }

        public void setTEAM_GROUP_NAME(String TEAM_GROUP_NAME) {
            this.TEAM_GROUP_NAME = TEAM_GROUP_NAME;
        }

        public String getCOMMAND_ACCEPTSTATES() {
            return COMMAND_ACCEPTSTATES;
        }

        public void setCOMMAND_ACCEPTSTATES(String COMMAND_ACCEPTSTATES) {
            this.COMMAND_ACCEPTSTATES = COMMAND_ACCEPTSTATES;
        }

        public String getCOMMAND_RESOLVE_STATES() {
            return COMMAND_RESOLVE_STATES;
        }

        public void setCOMMAND_RESOLVE_STATES(String COMMAND_RESOLVE_STATES) {
            this.COMMAND_RESOLVE_STATES = COMMAND_RESOLVE_STATES;
        }
    }
}
