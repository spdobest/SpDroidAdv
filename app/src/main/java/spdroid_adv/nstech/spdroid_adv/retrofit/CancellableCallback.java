package spdroid_adv.nstech.spdroid_adv.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancellableCallback<T> implements Callback<T> {

    private Callback<T> callback;

    private boolean canceled;

    private CancellableCallback() {}

    public CancellableCallback(Callback<T> callback) {
        this.callback = callback;
        canceled = false;
    }

    public void cancel() {
        canceled = true;
        callback = null;
    }
    @Override
    public void onResponse(Call<T> call, Response<T> response) {

    }
    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

   /* @Override
    public void success(T o, Response response) {
        if (!canceled) {
            callback.success(o, response);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        if (!canceled) {
            callback.failure(error);
        }
    }*/
}