package androidmvp.vinzdez.com.androidmvp.dao;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;

import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public interface SearchResultDao extends DaoTemplate<SearchResultResponse, Integer> {

    /**
     * @param webFormId
     * @return the Remark with the passed webFormId.
     * webFormId is the primary key for web
     * @throws SQLException
     */
    @Nullable
    SearchResultResponse findSearchResultByKey(@NonNull String webFormId) throws SQLException;

}
