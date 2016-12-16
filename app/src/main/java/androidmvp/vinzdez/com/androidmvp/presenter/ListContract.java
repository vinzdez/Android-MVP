package androidmvp.vinzdez.com.androidmvp.presenter;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.Movie;

/**
 * Created by Vicente on 4/16/2016.
 */
public interface ListContract {

    interface BaseView<T> {
        void setPresenter(T presenter);
    }

    interface Presenter {
        void start();

        List<Movie> loadTasks(boolean forceLoad);

        void openTaskDetail();

        void loadLastSearches();

        void find(String query);
    }
}
