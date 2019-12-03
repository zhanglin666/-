package cn.kc.mine_apply

import cn.kc.mine_apply.bean.AddressListBean
import cn.kc.mine_apply.bean.AddressListSearchBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 作者： Abel .
 * 日期：2019/9/16
 * 说明：
 */
interface AddressApi {

    //通讯录搜索
    @POST("GetAddressBook")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getAddressBook(@Field("likeName") likeName: String, @Field("UID") uid: String): Observable<AddressListSearchBean>

    //通讯录列表
    @POST("GetAddressBook")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getAddressList(@Field("likeName") likeName: String, @Field("UID") uid: String): Observable<AddressListBean>

}