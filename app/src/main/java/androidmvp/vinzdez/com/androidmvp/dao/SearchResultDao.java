package androidmvp.vinzdez.com.androidmvp.dao;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.Search;
import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public interface SearchResultDao extends DaoTemplate<SearchResultResponse, Integer> {


    @Nullable
    Search findSearchResultByKey(@NonNull String key) throws SQLException;

    void save(@NonNull List<SearchResultResponse> searchResultResponseList, @NonNull String key) throws SQLException;

}

