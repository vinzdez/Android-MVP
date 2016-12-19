package androidmvp.vinzdez.com.androidmvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.Movie;
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
        loadTasks(false);
    }

    @Deprecated
    @Override
    public List<Movie> loadTasks(boolean forceLoad) {
        return loadTasks();
    }

    @Deprecated
    private List<Movie> loadTasks() {
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        return movieList;
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
