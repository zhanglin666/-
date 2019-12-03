package cn.kc.integrated_service

import cn.kc.integrated_service.bean.CommandClassifyBean
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * 作者： Abel .
 * 日期：2019/9/18
 * 说明：
 */
interface CommandApi {

    //获取命令分类
    @GET("CommandClassify")
    fun getCommand(): Observable<CommandClassifyBean>

    //获取分发的调度命令
    @POST("CommandPost")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getCommandPost(
        @Field("CommState") CommState: String, @Field("CommType") CommType: String,
        @Field("CommContext") CommContext: String, @Field("UId") UId: String
    ): Observable<JsonObject>//NoReceiveBean

    //接受命令
    @POST("CommandReceive")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getCommandReceive(
        @Field("CommIssueId") CommIssueId: String, @Field("State") State: String,
        @Field("UId") UId: String, @Field("RESOLVE_ID") RESOLVE_ID: String
    ): Observable<JsonObject>
}