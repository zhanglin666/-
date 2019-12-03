package cn.kc.trainman_apply

import cn.kc.trainman_apply.login.UserBean
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.*

interface Api {

    //登录
    @GET("UserLogin")
    fun login(@Query("UserId") username: String,
              @Query("Pwd") password: String): Observable<UserBean>

    //获取分发的调度命令
    @POST("CommandPost")
    @FormUrlEncoded   //表示发送form-encoded的数据，每个键值对需要用@Filed来注解键名
    fun getCommandPost(
        @Field("CommState") CommState: String, @Field("CommType") CommType: String,
        @Field("CommContext") CommContext: String, @Field("UId") UId: String
    ): Observable<JsonObject>//NoReceiveBean

}