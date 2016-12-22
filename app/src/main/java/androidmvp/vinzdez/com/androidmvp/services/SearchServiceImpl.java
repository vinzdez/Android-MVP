package androidmvp.vinzdez.com.androidmvp.services;

import android.support.annotation.NonNull;
import android.util.Log;

import java.sql.SQLException;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.dao.SearchResultDao;
import androidmvp.vinzdez.com.androidmvp.model.Search;
import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchService;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchServiceApi;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 */

public class SearchServiceImpl extends SearchAppService implements SearchService {

    private static String TAG = SearchServiceApiImpl.class.getName();

    private SearchServiceApi searchServiceApi;

    public SearchServiceImpl(@NonNull SearchServiceApi searchServiceApi) {
        this.searchServiceApi = searchServiceApi;
    }


    @Override
    public void find(@NonNull final SearchResultCallback callback, final String key) {

        final SearchResultDao searchResultDao = getDaoFactory().searchResultDao();
        try {
            final Search search = searchResultDao.findSearchResultByKey(key);
            if (search == null) {
                //NETWORK
                searchServiceApi.find(new SearchServiceApi.Callback<List<SearchResultResponse>>() {
                    @Override
                    public void onLoad(List<SearchResultResponse> resultList) {
                        try {
                            callback.onResultLoaded(resultList);
                            searchResultDao.save(resultList, key);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, key);
            } else {
                //DB
                callback.onResultLoaded(search.getSearchResultResponseList());
            }
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
