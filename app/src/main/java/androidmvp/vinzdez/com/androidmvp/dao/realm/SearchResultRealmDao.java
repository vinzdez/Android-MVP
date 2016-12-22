package androidmvp.vinzdez.com.androidmvp.dao.realm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.dao.DataNotFoundException;
import androidmvp.vinzdez.com.androidmvp.dao.SearchResultDao;
import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;
import io.realm.Realm;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public class SearchResultRealmDao implements SearchResultDao {

    private Realm realm;

    public SearchResultRealmDao(Realm realm) {
        this.realm = realm;
    }

    @Nullable
    @Override
    public SearchResultResponse findSearchResultByKey(@NonNull String webFormId) throws SQLException {
        return null;
    }


    @Override
    public void save(@NonNull List<SearchResultResponse> src) throws SQLException {

    }

    @Override
    public void create(@NonNull SearchResultResponse src) throws SQLException {

    }

    @Nullable
    @Override
    public SearchResultResponse find(@NonNull Integer integer) throws SQLException {
        return null;
    }

    @NonNull
    @Override
    public SearchResultResponse get(@NonNull Integer integer) throws SQLException, DataNotFoundException {
        throw new UnsupportedOperationException(String.valueOf(R.string.error_unsupported_exception));
    }

    @NonNull
    @Override
    public List<SearchResultResponse> findAll() throws SQLException {
        throw new UnsupportedOperationException(String.valueOf(R.string.error_unsupported_exception));
    }


    @Override
    public int delete(@NonNull SearchResultResponse src) throws SQLException {
        throw new UnsupportedOperationException(String.valueOf(R.string.error_unsupported_exception));
    }

    @Override
    public void save(@NonNull SearchResultResponse src) throws SQLException {
        throw new UnsupportedOperationException(String.valueOf(R.string.error_unsupported_exception));
    }
}
