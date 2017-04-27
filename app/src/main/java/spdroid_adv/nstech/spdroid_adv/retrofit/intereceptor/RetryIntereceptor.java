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
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
