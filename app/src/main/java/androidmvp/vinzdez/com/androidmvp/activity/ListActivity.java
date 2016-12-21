package androidmvp.vinzdez.com.androidmvp.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.presenter.ListPresenter;
import androidmvp.vinzdez.com.androidmvp.util.ActivityUtils;

public class ListActivity extends BaseActivity {

    private ListPresenter listPresenter;
    private SearchView searchView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_search_result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        final MenuItem searchMenuItem = menu.findItem(R.id.menu_search);
        if (searchView == null) {
            // Associate searchable configuration with the SearchResultView
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);


            this.searchView = (SearchView) searchMenuItem.getActionView();
            ListFragment listFragment = getListFregment();

            if (listFragment != null) {
                searchView.setOnQueryTextListener(listFragment);
            }

            searchView.setSubmitButtonEnabled(true);
            listPresenter.setSearchView(searchView);

            setActionExpandListener(searchMenuItem);
        }
        return true;
    }

    private void setActionExpandListener(MenuItem searchMenuItem) {
        MenuItemCompat.setOnActionExpandListener(searchMenuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                if (getSupportActionBar() != null) {
                    listPresenter.actionBarTransition(getSupportActionBar(), getDrawable(R.color.primary_background), getDrawable(R.color.background));
                }
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Set styles for collapsed state here
                if (getSupportActionBar() != null) {
                    listPresenter.actionBarTransition(getSupportActionBar(), getDrawable(R.color.background), getDrawable(R.color.primary_background));
                }
                return true;
            }
        });
    }

    private void initFragment() {
        ListFragment listFragment = getListFregment();

        if (listFragment == null) {
            listFragment = ListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), listFragment, R.id.contentFrame);
        }

        this.listPresenter = new ListPresenter(listFragment, this);
    }

    @Nullable
    private ListFragment getListFregment() {
        return (ListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
    }

}
