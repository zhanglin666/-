package cn.kc.moduleutils.http

import cn.kc.moduleutils.base.BaseApplication
import com.google.gson.GsonBuilder

class Constant {
    companion object {
        //请求端口地址
//        val mHOST: String
//            get() = BaseApplication.preferences.server_address + "/tools/command_app.asmx/"
        val mHOST: String
            get() = if (BaseApplication.preferences.server_address != null) {
                BaseApplication.preferences.server_address + "/tools/command_app.asmx/"
            } else {
                "http://192.168.100.20:9999/tools/command_app.asmx/"
            }

        val mSERVERADDRESS: String
            get() = if (BaseApplication.preferences.server_address != null) {
                BaseApplication.preferences.server_address.toString()
            } else {
                "http://192.168.100.20:9999"
            }

        val gson = GsonBuilder().serializeNulls().create()

        val mUID: String = BaseApplication.preferences.UID ?: "245400"
//        val mUID: String
//            get() = if (BaseApplication.preferences.UID != null) {
//                BaseApplication.preferences.UID.toString()
//            } else {
//                "245400"
//            }

        val mREALNAME: String
            get() = if (BaseApplication.preferences.real_name != null) {
                BaseApplication.preferences.real_name.toString()
            } else {
                "白月皓"
            }

        val mEMPLOYEECODESBNO = BaseApplication.preferences.employee_code_sbno ?: "245400"
//        val mEMPLOYEECODESBNO: String
//            get() = if (BaseApplication.preferences.employee_code_sbno != null) {
//                BaseApplication.preferences.employee_code_sbno.toString()
//            } else {
//                "245400"
//            }
    }
}