package androidmvp.vinzdez.com.androidmvp.services;

import android.support.annotation.NonNull;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResult;
import androidmvp.vinzdez.com.androidmvp.network.API;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchServiceApi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 */

public class SearchServiceApiImpl implements SearchServiceApi {

    @Override
    public void find(@NonNull final Callback<List<SearchResult>> callback, String find) {
        Call<List<SearchResult>> callSearchResult = API.getInstance().getApiSearch().find(find);
        callSearchResult.enqueue(new retrofit2.Callback<List<SearchResult>>() {
            @Override
            public void onResponse(Call<List<SearchResult>> call, Response<List<SearchResult>> response) {
                //TODO : DB saving
                callback.onLoad(response.body());
            }

            @Override
            public void onFailure(Call<List<SearchResult>> call, Throwable t) {
                // TODO Implement generic alert dialog.
            }
        });
    }
}
