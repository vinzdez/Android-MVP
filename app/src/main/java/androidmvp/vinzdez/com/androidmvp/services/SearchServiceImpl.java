package androidmvp.vinzdez.com.androidmvp.services;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResult;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchService;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchServiceApi;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 */

public class SearchServiceImpl implements SearchService {

    private SearchServiceApi searchServiceApi;
    private List<SearchResult> searchResults;

    public SearchServiceImpl(@NonNull SearchServiceApi searchServiceApi) {
        this.searchServiceApi = searchServiceApi;
        this.searchResults = new ArrayList<>();
    }


    @Override
    public void find(@NonNull final SearchResultCallback callback, String search) {
        searchServiceApi.find(new SearchServiceApi.Callback<List<SearchResult>>() {
            @Override
            public void onLoad(List<SearchResult> resultList) {
                callback.onResultLoaded(resultList);
            }
        }, search);
    }
}
