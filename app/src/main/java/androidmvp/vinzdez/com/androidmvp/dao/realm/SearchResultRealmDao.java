package androidmvp.vinzdez.com.androidmvp.dao.realm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.dao.DataNotFoundException;
import androidmvp.vinzdez.com.androidmvp.dao.SearchResultDao;
import androidmvp.vinzdez.com.androidmvp.model.Search;
import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;
import androidmvp.vinzdez.com.androidmvp.model.realmmodel.SearchResult;
import androidmvp.vinzdez.com.androidmvp.model.realmmodel.SearchResultRealm;
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
    public Search findSearchResultByKey(@NonNull String key) throws SQLException {
        SearchResult searchResultRealm = realm.where(SearchResult.class).equalTo("key", key).findFirst();
        Search search = null;
        if (searchResultRealm != null) {
            search = new Search();
            search.obtainFromResult(searchResultRealm.getSearchResultResponseList(), searchResultRealm.getKey());
        }
        return search;
    }

    @Override
    public void save(@NonNull List<SearchResultResponse> searchResultResponseList, @NonNull final String key) throws SQLException {
        final List<SearchResultRealm> searchResultRealms = new ArrayList<>();
        for (SearchResultResponse searchResultResponse : searchResultResponseList) {
            searchResultRealms.add(searchResultResponse.toRealm());
        }

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                List<SearchResultRealm> copySearchResults = realm.copyToRealmOrUpdate(searchResultRealms);
                SearchResult searchResult = new SearchResult();
                searchResult.getSearchResultResponseList().addAll(copySearchResults);
                searchResult.setKey(key);
                realm.copyToRealmOrUpdate(searchResult);
            }
        });
    }


    @Override
    public void save(@NonNull List<SearchResultResponse> searchResultResponseList) throws SQLException {
        throw new UnsupportedOperationException(String.valueOf(R.string.error_unsupported_exception));
    }

    @Override
    public void create(@NonNull SearchResultResponse src) throws SQLException {
        throw new UnsupportedOperationException(String.valueOf(R.string.error_unsupported_exception));
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
