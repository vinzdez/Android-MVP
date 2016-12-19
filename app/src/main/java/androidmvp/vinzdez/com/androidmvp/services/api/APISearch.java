package androidmvp.vinzdez.com.androidmvp.services.api;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 *
 * @source http://www.googlesearchcrawler.vinceangcaway.xyz/
 */

public interface APISearch {

    @GET("search?search=Movie")
    Call<List<SearchResult>> find(@Query("search") String search);
    
}
