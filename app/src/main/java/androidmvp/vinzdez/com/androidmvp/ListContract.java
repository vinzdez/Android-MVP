package androidmvp.vinzdez.com.androidmvp;

import android.support.v7.widget.CardView;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.Movie;

/**
 * Created by Vicente on 4/16/2016.
 */
public interface ListContract {

    interface BaseView<T> {
        void setPresenter(T presenter);
    }

    interface View extends BaseView<Presenter> {
        void onClick(CardView view, int position);

        void onLongClick(CardView view, int position);
    }

    interface Presenter {
        void start();

        List<Movie> loadTasks(boolean forceLoad);

        void openTaskDetail();
    }
}
