package cn.kc.trainman_apply.dispatchingcommand.bean

/**
 * 作者： Abel .
 * 日期：2019/8/2
 * 说明：
 */
class CommandBean {

    /**
     * state : 1
     * data : [{"COMMAND_TYPE_ID":"14","COMMAND_TYPE_NAME":"套跑","COMMAND_NOTE":null},{"COMMAND_TYPE_ID":"2","COMMAND_TYPE_NAME":"甩挂","COMMAND_NOTE":"无"},{"COMMAND_TYPE_ID":"3","COMMAND_TYPE_NAME":"抄送","COMMAND_NOTE":null}]
     */

    var state: Int = 0
    var data: List<DataBean>? = null

    class DataBean {
        /**
         * COMMAND_TYPE_ID : 14
         * COMMAND_TYPE_NAME : 套跑
         * COMMAND_NOTE : null
         */

        var commanD_TYPE_ID: String? = null
        var commanD_TYPE_NAME: String? = null
        var commanD_NOTE: Any? = null
    }
}
