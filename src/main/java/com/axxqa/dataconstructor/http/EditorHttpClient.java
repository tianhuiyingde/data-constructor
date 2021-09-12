package com.axxqa.dataconstructor.http;

import com.axxqa.dataconstructor.common.RetrofitManager;
import com.axxqa.dataconstructor.req.AuditContentReq;
import com.axxqa.dataconstructor.req.UpdateGameReq;
import com.axxqa.dataconstructor.req.game.CreateReq;
import com.axxqa.dataconstructor.req.game.PublishReq;
import com.axxqa.dataconstructor.resp.AuditGameResp;
import com.axxqa.dataconstructor.resp.CommonResp;
import com.axxqa.dataconstructor.resp.CreateGameResp;
import com.axxqa.dataconstructor.resp.UpdateGameResp;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
public class EditorHttpClient extends RetrofitManager {
    public static String baseUrl="https://webeditor.aixuexi.com";
    public static int gameId;
    public static String gameName;
    public static String editorUri;
    public static String gameUri;
    public static int templateId;

    private EditorServiceApi editorServiceApi=HttpRetrofitManager(baseUrl)
            .create(EditorServiceApi.class);
    public EditorHttpClient(){

    }


    public Response<CommonResp<CreateGameResp>> createGame(CreateReq req) throws IOException {
        JSONObject params=new JSONObject();
        params.put("id",0);
        params.put("isTemplate",0);
        params.put("name",req.getName());
        params.put("parentId",0);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);
        Call<CommonResp<CreateGameResp>> createGame=editorServiceApi.Create_Game(body);
        Response<CommonResp<CreateGameResp>> response=createGame.execute();
        return  response;
    }

    public Response<CommonResp<CreateGameResp>> createGameByTemplate(CreateReq req) throws IOException {
        JSONObject params=new JSONObject();
        params.put("templateId",req.getTemplateId());
        params.put("name",req.getName());
        params.put("parentId",0);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);
        Call<CommonResp<CreateGameResp>> createGame=editorServiceApi.Create_Game(body);
        Response<CommonResp<CreateGameResp>> response=createGame.execute();
        return  response;
    }

    public Response<CommonResp<UpdateGameResp>> updateGame(PublishReq req) throws IOException {
        JSONObject params=new JSONObject();
        params.put("id",gameId);
        params.put("name",gameName);
        params.put("schoolSection",req.getSchoolsection());
        params.put("subject",req.getSubject());
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);
        Call<CommonResp<UpdateGameResp>> updateGame=editorServiceApi.Update_Game(body);
        Response<CommonResp<UpdateGameResp>> response=updateGame.execute();
        return  response;
    }

    public Response<CommonResp<AuditGameResp>> auditGame(String id) throws IOException {
        JSONObject params=new JSONObject();
        params.put("id",id);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);
        Call<CommonResp<AuditGameResp>> auditGame=editorServiceApi.Audit_Game(body);
        Response<CommonResp<AuditGameResp>> response=auditGame.execute();
        return  response;
    }

    public Response<CommonResp> auditContent() throws IOException {
        JSONObject params=new JSONObject();
        params.put("auditResult",1);
        params.put("auditStatus","1");
        params.put("description","");
        params.put("id",gameId);
        params.put("path",gameName);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);
        Call<CommonResp> auditContent=editorServiceApi.Audit_Content(body);
        Response<CommonResp> response=auditContent.execute();
        return  response;
    }

    public Response<CommonResp> auditDesign() throws IOException {
        JSONObject params=new JSONObject();
        params.put("auditResult",1);
        params.put("auditStatus","2");
        params.put("description","");
        params.put("id",gameId);
        params.put("path",gameName);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);
        Call<CommonResp> auditDesign=editorServiceApi.Design_Content(body);
        Response<CommonResp> response=auditDesign.execute();
        return  response;
    }
}
