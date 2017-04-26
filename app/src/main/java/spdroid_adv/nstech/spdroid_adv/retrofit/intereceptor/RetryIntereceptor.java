package spdroid_adv.nstech.spdroid_adv.retrofit.intereceptor;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by webwerks on 26/4/17.
 */

public class RetryIntereceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain)
            throws IOException {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(/*CONNECT_TIMEOUT_MILLIS*/12331, TimeUnit.MILLISECONDS);
        client.setReadTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                // try the request
                Response response = chain.proceed(request);

                int tryCount = 0;
                while (!response.isSuccessful() && tryCount < 3) {

                    Log.d("intercept", "Request is not successful - " + tryCount);

                    tryCount++;

                    // retry the request
                    response = chain.proceed(request);
                }

                // otherwise just pass the original response on
                return response;
            }
        });
    }
}
