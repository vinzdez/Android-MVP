package androidmvp.vinzdez.com.androidmvp.view;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;
import androidmvp.vinzdez.com.androidmvp.presenter.ListContract;

/**
 * Created by Vicente Angcaway on 16/12/2016.
 */

public interface SearchResultView extends ListContract.BaseView<ListContract.Presenter>, android.support.v7.widget.SearchView.OnQueryTextListener {

    void loadSearchResult(List<SearchResultResponse> searchResultResponseList);

    void toggleProgressBar(int visibility);

}
