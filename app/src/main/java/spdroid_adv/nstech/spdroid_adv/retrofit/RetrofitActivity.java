package spdroid_adv.nstech.spdroid_adv.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spdroid_adv.nstech.spdroid_adv.R;
import spdroid_adv.nstech.spdroid_adv.retrofit.model.Movie;
import spdroid_adv.nstech.spdroid_adv.retrofit.model.MoviesResponse;

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = RetrofitActivity.class.getSimpleName();
 
    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "";

    Call<MoviesResponse> call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }
 
        ApiInterface apiService =
                RetrofitApiClient.getClient().create(ApiInterface.class);

        call = apiService.getTopRatedMovies(API_KEY);


        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse>call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
            }
 
            @Override
            public void onFailure(Call<MoviesResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
    private void cancelRequest(){
        if(!call.isCanceled()){
            call.cancel();
        }
    }
}