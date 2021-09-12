package com.axxqa.dataconstructor.interceptor;

import okhttp3.*;

import java.io.IOException;

import static com.axxqa.dataconstructor.http.UserHttpClient.SESSIONID;
import static com.axxqa.dataconstructor.http.UserHttpClient.TOKEN;


public class AppendHeaderInterceptor implements Interceptor{


    @Override
    public  Response intercept(Interceptor.Chain chain) throws IOException {
        Request request=chain.request();
        Request newRequest;
        HttpUrl url=request.url();
        System.out.println("url:"+url);

        //统一追加header,判断不同域名
        // 其他域名均不需要传入header
        if (url.toString().contains("adminzx.aixuexi.com/user/auth/") ){
            Headers.Builder builder=request.headers().newBuilder();
            Headers newHeader=builder
                    .add("lol-code","LOL_EDITOR")
                    .add("Acceppt", "application/json, text/plain, */*")
                    .build();
            newRequest=request.newBuilder()
                    .headers(newHeader)
                    .build();
            return chain.proceed(newRequest);
        }else if(url.toString().contains("webeditor.aixuexi.com") ){
            Headers.Builder builder=request.headers().newBuilder();
            Headers newHeader = builder
                    .add("authorization", TOKEN)
                    .add("lol",SESSIONID)
                    .add("lol-code","LOL_EDITOR")
                    .add("Acceppt", "application/json, text/plain, */*")
                    .build();
            newRequest=request.newBuilder()
                    .headers(newHeader)
                    .build();
            return chain.proceed(newRequest);
        }
        else {
            newRequest=request.newBuilder()
                    .build();
            return chain.proceed(newRequest);
        }
    }
}
