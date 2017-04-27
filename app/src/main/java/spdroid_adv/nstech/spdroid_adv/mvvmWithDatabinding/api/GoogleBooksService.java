package spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding.model.SearchResults;


/**
 * Created by Mustafa Ali on 11/03/15.
 */
public interface GoogleBooksService {
    @GET("/books/v1/volumes")
    Call<SearchResults> search(@Query("q") String query);
}
