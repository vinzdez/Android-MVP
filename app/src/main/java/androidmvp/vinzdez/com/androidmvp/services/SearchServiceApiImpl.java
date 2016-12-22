package androidmvp.vinzdez.com.androidmvp.services;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;
import androidmvp.vinzdez.com.androidmvp.network.API;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchServiceApi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 */

public class SearchServiceApiImpl implements SearchServiceApi {

    private static String TAG = SearchServiceApiImpl.class.getName();

    @Override
    public void find(@NonNull final Callback<List<SearchResultResponse>> callback, String find) {
        Call<List<SearchResultResponse>> callSearchResult = API.getInstance().getApiSearch().find(find);
        callSearchResult.enqueue(new retrofit2.Callback<List<SearchResultResponse>>() {
            @Override
            public void onResponse(Call<List<SearchResultResponse>> call, Response<List<SearchResultResponse>> response) {
                //TODO : DB saving
                callback.onLoad(response.body());
            }

            @Override
            public void onFailure(Call<List<SearchResultResponse>> call, Throwable t) {
                // TODO Implement generic alert dialog.
                Log.e(TAG, "Unable to retrieve");
            }
        });
    }
}
