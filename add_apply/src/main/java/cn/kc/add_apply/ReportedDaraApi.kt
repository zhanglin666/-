package cn.kc.add_apply

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.*

/**
 * 作者： Abel .
 * 日期：2019/9/17
 * 说明：
 */

interface ReportedDaraApi {

    //获取部门信息
    @GET("GetDept")
    fun getDept(): Observable<JsonObject>

    //获取班组信息
    @POST("GetTeamByDepID")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getTeamByDepID(
        @Field("deptID") deptID: String
    ): Observable<JsonObject>

    //根据社保号获取用户信息
    @POST("GetEmployeeById")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getEmployeeById(
        @Field("id") id: String
    ): Observable<JsonObject>

    //获取检查类别
    @GET("getCheckSort")
    fun getCheckSort(): Observable<JsonObject>

    //获取车次信息
    @POST("GetTrainAll")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getTrainAll(
        @Field("dept") dept: String, @Field("team") group: String
    ): Observable<JsonObject>

    //获取列车区间站信息
    @POST("    GetStation")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getStation(
        @Field("trainID") trainID: String
    ): Observable<JsonObject>

    //获取责任人
    @POST("GetEmployeeBydept")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getEmployee(
        @Field("dept") dept: String, @Field("team") team: String, @Field("type") type: String
    ): Observable<JsonObject>

    //获取添乘类别
    @GET("getTimSort")
    fun getTimSort(): Observable<JsonObject>

    //获取信息点
    @POST("getPageInfoCode")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getPageInfoCode(
        @Field("currPage") currPage: String, @Field("pageSize") pageSize: String,
        @Field("infoName") infoName: String
    ): Observable<JsonObject>

}