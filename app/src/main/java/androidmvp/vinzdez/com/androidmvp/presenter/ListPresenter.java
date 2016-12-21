package androidmvp.vinzdez.com.androidmvp.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.text.MessageFormat;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.model.SearchResult;
import androidmvp.vinzdez.com.androidmvp.services.SearchServiceApiImpl;
import androidmvp.vinzdez.com.androidmvp.services.SearchServiceImpl;
import androidmvp.vinzdez.com.androidmvp.services.api.SearchService;
import androidmvp.vinzdez.com.androidmvp.view.SearchResultView;

/**
 * Created by Vicente on 4/16/2016.
 */
public class ListPresenter implements ListContract.Presenter {

    private final SearchResultView searchResultView;
    private Context context;
    private SearchView searchView;
    private SearchServiceImpl searchServiceImpl;

    public ListPresenter(@NonNull SearchResultView searchViewImpl, @NonNull Context context) {
        this.context = context;
        this.searchResultView = searchViewImpl;
        this.searchServiceImpl = new SearchServiceImpl(new SearchServiceApiImpl());
        searchResultView.setPresenter(this);
    }

    @Override
    public void start() {

    }


    public void setSearchView(SearchView searchView) {
        this.searchView = searchView;
    }

    @Override
    public void find(String query) {
        searchView.clearFocus();
        searchView.setIconifiedByDefault(true);
        searchResultView.toggleProgressBar(View.VISIBLE);
        if (searchView != null && searchView.isShown()) {
            searchServiceImpl.find(new SearchService.SearchResultCallback() {
                @Override
                public void onResultLoaded(List<SearchResult> searchResultList) {
                    searchResultView.toggleProgressBar(View.GONE);
                    searchResultView.loadSearchResult(searchResultList);
                }
            }, query);
            searchView.setQuery("", false);
        }
    }

    @Override
    public void actionBarTransition(@NonNull ActionBar actionBar, @NonNull Drawable initial, @NonNull Drawable outcome) {
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{initial, outcome});
        actionBar.setBackgroundDrawable(transitionDrawable);
        transitionDrawable.startTransition(1000);

    }
}
