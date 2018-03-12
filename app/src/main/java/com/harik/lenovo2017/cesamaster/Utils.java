package com.harik.lenovo2017.cesamaster;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lenovo on 2/26/2018.
 */

public class Utils {
int age;
    public static String  devise="€";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
public final String nom="ayoub";
    public static String  post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
