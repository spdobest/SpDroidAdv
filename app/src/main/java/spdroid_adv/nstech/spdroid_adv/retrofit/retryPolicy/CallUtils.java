package spdroid_adv.nstech.spdroid_adv.retrofit.retryPolicy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallUtils {

    public static <T> void enqueueWithRetry(Call<T> call, final Callback<T> callback) {
        /*call.enqueue(new CallbackWithRetry<T>(call) {
            @Override
            public void onResponse(Response<T> response) {
                callback.onResponse(response);
            }

            @Override
            public void onFailure(Throwable t) {
                super.onFailure(t);
                callback.onFailure(t);
            }
        });*/
    }

}