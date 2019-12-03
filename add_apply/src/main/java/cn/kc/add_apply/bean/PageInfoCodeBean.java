package cn.kc.add_apply.bean;

import java.util.List;

/**
 * 作者： Abel .
 * 日期：2019/9/19
 * 说明：
 */
public class PageInfoCodeBean {

    /**
     * state : 1
     * message : 获取信息点成功！
     * total : 687
     * data : [{"ID":1,"INFO_CODE":"KYGLA001","INFO_NAME":"值岗、添乘干部对值岗、添乘过程中发生的问题处置不及时、不当。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":1,"REMARK":null,"INFO_QUESTION_SUB_ID":1,"INFO_SAFT_ID":1,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":1},{"ID":2,"INFO_CODE":"KYGLA002","INFO_NAME":"旅客列车未明确安检查危重点区段或重点区段安检措施未有效落实。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":3,"REMARK":null,"INFO_QUESTION_SUB_ID":4,"INFO_SAFT_ID":12,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":2},{"ID":3,"INFO_CODE":"KYGLA003","INFO_NAME":"消防安全通道堵塞、疏散标志不齐全、应急照明设备作用不良。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":2,"REMARK":null,"INFO_QUESTION_SUB_ID":null,"INFO_SAFT_ID":null,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":3},{"ID":4,"INFO_CODE":"KYGLA005","INFO_NAME":"禁烟场所工作人员吸烟或有自制烟灰缸或有烟灰、烟头。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":3,"REMARK":null,"INFO_QUESTION_SUB_ID":3,"INFO_SAFT_ID":5,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":4},{"ID":5,"INFO_CODE":"KYGLA006","INFO_NAME":"站车未严格落实\u201c五道防线\u201d规定。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":2,"REMARK":null,"INFO_QUESTION_SUB_ID":null,"INFO_SAFT_ID":null,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":5},{"ID":6,"INFO_CODE":"KYGLA007","INFO_NAME":"未向押运人员宣传安全及防火注意事项，未发放安全警示卡，未按规定收缴押运人员香烟、火种。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":8,"REMARK":null,"INFO_QUESTION_SUB_ID":3,"INFO_SAFT_ID":21,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":6},{"ID":7,"INFO_CODE":"KYGLA008","INFO_NAME":"站车加工、销售食品人员未经健康体检，无《健康证》上岗作业。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":9,"REMARK":null,"INFO_QUESTION_SUB_ID":23,"INFO_SAFT_ID":37,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":7},{"ID":8,"INFO_CODE":"KYGLA010","INFO_NAME":"旅客列车餐车防火毯未按规定配备或定位摆放，影响取用。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":3,"REMARK":null,"INFO_QUESTION_SUB_ID":8,"INFO_SAFT_ID":13,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":8},{"ID":9,"INFO_CODE":"KYGLA011","INFO_NAME":"旅客列车前、后部车厢端门无安全防护栏。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":6,"REMARK":null,"INFO_QUESTION_SUB_ID":5,"INFO_SAFT_ID":18,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":9},{"ID":10,"INFO_CODE":"KYGLA014","INFO_NAME":"客运岗位工作人员未经培训合格持证上岗。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":10,"REMARK":null,"INFO_QUESTION_SUB_ID":11,"INFO_SAFT_ID":20,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":10},{"ID":11,"INFO_CODE":"KYGLA015","INFO_NAME":"现金、支票、重款袋、有价证券、贵密件未按规定及时入柜加锁、加密保管。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":10,"REMARK":null,"INFO_QUESTION_SUB_ID":null,"INFO_SAFT_ID":null,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":11},{"ID":12,"INFO_CODE":"KYGLA016","INFO_NAME":"列车给旅客供水使用的保温桶、大送水壶未加锁管理。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":12,"REMARK":null,"INFO_QUESTION_SUB_ID":null,"INFO_SAFT_ID":null,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":12},{"ID":13,"INFO_CODE":"KYGLA017","INFO_NAME":"客调命令误传、漏传；客运停限办错登、漏登。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":1,"REMARK":null,"INFO_QUESTION_SUB_ID":10,"INFO_SAFT_ID":17,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":13},{"ID":14,"INFO_CODE":"KYGLA019","INFO_NAME":"运行中行李车、发电车、邮政车与载客车厢连接的端门，列车通用钥匙无法打开。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":6,"REMARK":null,"INFO_QUESTION_SUB_ID":null,"INFO_SAFT_ID":null,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":14},{"ID":15,"INFO_CODE":"KYGLA020","INFO_NAME":"未严格落实旅客列车库内甩挂车分钩作业及临时转线时的安全措施。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":2,"REMARK":null,"INFO_QUESTION_SUB_ID":14,"INFO_SAFT_ID":18,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":15},{"ID":16,"INFO_CODE":"KYGLA021","INFO_NAME":"劳动安全防护措施未认真落实。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":2,"REMARK":null,"INFO_QUESTION_SUB_ID":14,"INFO_SAFT_ID":18,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":16},{"ID":17,"INFO_CODE":"KYGLA022","INFO_NAME":"擅自改变专运方案或专运车辆在库内停留期间无关人员在车内逗留。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":1,"REMARK":null,"INFO_QUESTION_SUB_ID":null,"INFO_SAFT_ID":null,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":17},{"ID":18,"INFO_CODE":"KYGLA023","INFO_NAME":"未按规定与保洁、商业、广告、安检、高铁快件等结合部单位签安全协议。","INFO_LEVE_ID":3,"INFO_SORT_ID":1,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":14,"REMARK":null,"INFO_QUESTION_SUB_ID":null,"INFO_SAFT_ID":null,"INFO_SORT_NAME":"安全管理","INFO_LEVEL_NAME":"A类","RN":18},{"ID":19,"INFO_CODE":"KYGLA028","INFO_NAME":"餐车盛油容器在燃煤灶台上放置。运行中使用燃煤炉灶油炸食品和过油时，油量超过容器容积三分之一。灶台旁油罐储存的油量超过容器的二分之一。","INFO_LEVE_ID":3,"INFO_SORT_ID":2,"INFO_BIGSORT_ID":7,"INFO_QUESTION_ID":3,"REMARK":null,"INFO_QUESTION_SUB_ID":9,"INFO_SAFT_ID":14,"INFO_SORT_NAME":"现场作业","INFO_LEVEL_NAME":"A类","RN":19},{"ID":20,"INFO_CODE":"KYZYA001","INFO_NAME":"列车未停稳，提前打开车门。","INFO_LEVE_ID":3,"INFO_SORT_ID":2,"INFO_BIGSORT_ID":5,"INFO_QUESTION_ID":6,"REMARK":null,"INFO_QUESTION_SUB_ID":5,"INFO_SAFT_ID":25,"INFO_SORT_NAME":"现场作业","INFO_LEVEL_NAME":"A类","RN":20}]
     */

    private String state;
    private String message;
    private int total;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ID : 1
         * INFO_CODE : KYGLA001
         * INFO_NAME : 值岗、添乘干部对值岗、添乘过程中发生的问题处置不及时、不当。
         * INFO_LEVE_ID : 3
         * INFO_SORT_ID : 1
         * INFO_BIGSORT_ID : 5
         * INFO_QUESTION_ID : 1
         * REMARK : null
         * INFO_QUESTION_SUB_ID : 1
         * INFO_SAFT_ID : 1
         * INFO_SORT_NAME : 安全管理
         * INFO_LEVEL_NAME : A类
         * RN : 1
         */

        private int ID;
        private String INFO_CODE;
        private String INFO_NAME;
        private int INFO_LEVE_ID;
        private int INFO_SORT_ID;
        private int INFO_BIGSORT_ID;
        private int INFO_QUESTION_ID;
        private Object REMARK;
        private int INFO_QUESTION_SUB_ID;
        private int INFO_SAFT_ID;
        private String INFO_SORT_NAME;
        private String INFO_LEVEL_NAME;
        private int RN;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getINFO_CODE() {
            return INFO_CODE;
        }

        public void setINFO_CODE(String INFO_CODE) {
            this.INFO_CODE = INFO_CODE;
        }

        public String getINFO_NAME() {
            return INFO_NAME;
        }

        public void setINFO_NAME(String INFO_NAME) {
            this.INFO_NAME = INFO_NAME;
        }

        public int getINFO_LEVE_ID() {
            return INFO_LEVE_ID;
        }

        public void setINFO_LEVE_ID(int INFO_LEVE_ID) {
            this.INFO_LEVE_ID = INFO_LEVE_ID;
        }

        public int getINFO_SORT_ID() {
            return INFO_SORT_ID;
        }

        public void setINFO_SORT_ID(int INFO_SORT_ID) {
            this.INFO_SORT_ID = INFO_SORT_ID;
        }

        public int getINFO_BIGSORT_ID() {
            return INFO_BIGSORT_ID;
        }

        public void setINFO_BIGSORT_ID(int INFO_BIGSORT_ID) {
            this.INFO_BIGSORT_ID = INFO_BIGSORT_ID;
        }

        public int getINFO_QUESTION_ID() {
            return INFO_QUESTION_ID;
        }

        public void setINFO_QUESTION_ID(int INFO_QUESTION_ID) {
            this.INFO_QUESTION_ID = INFO_QUESTION_ID;
        }

        public Object getREMARK() {
            return REMARK;
        }

        public void setREMARK(Object REMARK) {
            this.REMARK = REMARK;
        }

        public int getINFO_QUESTION_SUB_ID() {
            return INFO_QUESTION_SUB_ID;
        }

        public void setINFO_QUESTION_SUB_ID(int INFO_QUESTION_SUB_ID) {
            this.INFO_QUESTION_SUB_ID = INFO_QUESTION_SUB_ID;
        }

        public int getINFO_SAFT_ID() {
            return INFO_SAFT_ID;
        }

        public void setINFO_SAFT_ID(int INFO_SAFT_ID) {
            this.INFO_SAFT_ID = INFO_SAFT_ID;
        }

        public String getINFO_SORT_NAME() {
            return INFO_SORT_NAME;
        }

        public void setINFO_SORT_NAME(String INFO_SORT_NAME) {
            this.INFO_SORT_NAME = INFO_SORT_NAME;
        }

        public String getINFO_LEVEL_NAME() {
            return INFO_LEVEL_NAME;
        }

        public void setINFO_LEVEL_NAME(String INFO_LEVEL_NAME) {
            this.INFO_LEVEL_NAME = INFO_LEVEL_NAME;
        }

        public int getRN() {
            return RN;
        }

        public void setRN(int RN) {
            this.RN = RN;
        }
    }
}
