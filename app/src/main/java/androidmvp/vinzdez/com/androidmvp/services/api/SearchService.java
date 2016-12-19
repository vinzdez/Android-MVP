package androidmvp.vinzdez.com.androidmvp.services.api;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResult;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 */

public class SearchService {

    private SearchServiceApi searchServiceApi;
    private List<SearchResult> searchResults;

    public SearchService(@NonNull SearchServiceApi searchServiceApi) {
        this.searchServiceApi = searchServiceApi;
        this.searchResults = new ArrayList<>();
    }

    public List<SearchResult> find(String search) {

        //DB

        //API
        searchServiceApi.find(new SearchServiceApi.Callback<List<SearchResult>>() {
            @Override
            public void onLoad(List<SearchResult> resultList) {
                searchResults.addAll(resultList);
            }
        }, search);
        return searchResults;
    }

}
