package com.rfrongfei.onehammer.base.util;

import okhttp3.*;
import okhttp3.Request.Builder;

import java.io.IOException;
import java.util.Map;

public class HttpHelper {

    private static OkHttpClient okHttpClient;

    static {
        okHttpClient = new OkHttpClient();
    }
    public static String get(String url, Map<String,String> parmas){
        final HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        parmas.forEach(urlBuilder::addQueryParameter);
        final Request.Builder reqBuilder = new Request.Builder().get();
        reqBuilder.url(urlBuilder.build());
        final Request request = reqBuilder.build();
        final Call call = okHttpClient.newCall(request);
        try {
            final Response response = call.execute();
            if (response.code() == 200) {
                return response.body().string();
            }
        } catch (IOException ignored) {
        }
        return null;
    }

}