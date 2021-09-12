package com.axxqa.dataconstructor.http;

import com.axxqa.dataconstructor.resp.AuditGameResp;
import com.axxqa.dataconstructor.resp.CommonResp;
import com.axxqa.dataconstructor.resp.CreateGameResp;
import com.axxqa.dataconstructor.resp.UpdateGameResp;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
public interface EditorServiceApi {

    /**
     * 创建项目-互动题接口
     * @return
     */
    @POST("lol/editor/game/create")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<CommonResp<CreateGameResp>> Create_Game(@Body RequestBody body);

    /**
     * 更新互动题接口
     * @return
     */
    @POST("lol/editor/topicGame/update")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<CommonResp<UpdateGameResp>> Update_Game(@Body RequestBody body);

    /**
     * 提交审核互动题接口
     * @return
     */
    @POST("lol/editor/game/audit")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<CommonResp<AuditGameResp>> Audit_Game(@Body RequestBody body);




    /**
     * 互动题内容审核接口
     * @return
     */
    @POST("lol/editor/content/audit")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<CommonResp> Audit_Content(@Body RequestBody body);

    /**
     * 互动题设计审核接口
     * @return
     */
    @POST("lol/editor/design/audit")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<CommonResp> Design_Content(@Body RequestBody body);
}
