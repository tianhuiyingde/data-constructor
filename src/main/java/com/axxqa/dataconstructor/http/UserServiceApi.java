package com.axxqa.dataconstructor.http;

import com.axxqa.dataconstructor.resp.CommonResp;
import com.axxqa.dataconstructor.resp.LoginResp;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
public interface UserServiceApi {

    /**
     * 登录获取pubkey接口
     * @return
     */
    @POST("user/auth/key")
    Call<CommonResp> Auth_Key();

    /**
     * 登录接口
     * @param body
     * @return
     */
    @POST("user/auth/login")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<CommonResp<LoginResp>> Auth_Login(@Body RequestBody body);
}
