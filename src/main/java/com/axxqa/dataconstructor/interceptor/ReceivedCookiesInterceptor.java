package com.axxqa.dataconstructor.interceptor;


import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;


/**
 * @author tianhuiying on 2020/8/2.
 * @version 1.0
 */
public class ReceivedCookiesInterceptor implements Interceptor{
    public static String COOKIE;

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            //解析Cookie
            for (String header : originalResponse.headers("Set-Cookie")) {
                if(header.contains("JSESSIONID")){
                    COOKIE= header.substring(header.indexOf("JSESSIONID"), header.indexOf(";"));

                }
            }
        }

        return originalResponse;
    }
}

