package androidmvp.vinzdez.com.androidmvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResult;
import androidmvp.vinzdez.com.androidmvp.services.SearchServiceApiImpl;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchService;
import androidmvp.vinzdez.com.androidmvp.view.SearchCriteriaView;

/**
 * Created by Vicente on 4/16/2016.
 */
public class ListPresenter implements ListContract.Presenter {


    private final SearchCriteriaView searchCriteriaView;
    private Context context;
    private SearchView searchView;
    private SearchService searchService;

    public ListPresenter(@NonNull SearchCriteriaView searchViewImpl, @NonNull Context context) {
        this.context = context;
        this.searchCriteriaView = searchViewImpl;
        this.searchService = new SearchService(new SearchServiceApiImpl());
        searchCriteriaView.setPresenter(this);
    }

    @Override
    public void start() {
        loadLastSearches();
    }

    @Override
    public void openTaskDetail() {

    }

    //TODO : Query From DB
    @Override
    public void loadLastSearches() {

    }

    @Override
    public void find(String query) {
        if (searchView != null && searchView.isShown()) {
            List<SearchResult> searchResults = searchService.find(query);
            searchView.setQuery("", false);
        }
    }

    public void setSearchView(SearchView searchView) {
        this.searchView = searchView;
    }
}
