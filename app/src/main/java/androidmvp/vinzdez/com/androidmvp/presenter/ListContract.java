package androidmvp.vinzdez.com.androidmvp.presenter;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;

/**
 * Created by Vicente on 4/16/2016.
 */
public interface ListContract {

    interface BaseView<T> {
        void setPresenter(T presenter);
    }

    interface Presenter {
        void start();

        void openTaskDetail();

        void loadLastSearches();

        void find(String query);

        void actionBarTransition(ActionBar actionBar, Drawable initial, Drawable outcome);
    }
}
