package com.axxqa.dataconstructor.http;

import com.axxqa.dataconstructor.common.RetrofitManager;
import com.axxqa.dataconstructor.resp.CommonResp;
import com.axxqa.dataconstructor.resp.LoginResp;
import com.axxqa.dataconstructor.utils.RSAUtil;
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
public class UserHttpClient extends RetrofitManager {
    private static String baseUrl="https://adminzx.aixuexi.com";
    public static String PUBLICKEY;
    public static String SESSIONID;
    public static String TOKEN;



    private UserServiceApi userServiceApi=HttpRetrofitManager(baseUrl)
            .create(UserServiceApi.class);
    public UserHttpClient(){

    }

    /**
     * 调用获取publickey接口
     * @return
     * @throws IOException
     */
    public Response<CommonResp> getPublicKey() throws IOException {
        Call<CommonResp> auth_key=userServiceApi.Auth_Key();
        Response<CommonResp> response=auth_key.execute();
        return response;
    }

    public Response<CommonResp<LoginResp>> login(String username, String password) throws IOException {
        JSONObject params=new JSONObject();
        params.put("username", RSAUtil.encryptedDataOnJava(username, PUBLICKEY));
        params.put("password",RSAUtil.encryptedDataOnJava(password,PUBLICKEY));
        params.put("type","oa");
        params.put("rememberMe",false);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);
        Call<CommonResp<LoginResp>> auth_login=userServiceApi.Auth_Login(body);
        Response<CommonResp<LoginResp>> response=auth_login.execute();
        return  response;
    }
}
