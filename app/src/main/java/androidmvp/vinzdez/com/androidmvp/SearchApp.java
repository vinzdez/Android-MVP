package androidmvp.vinzdez.com.androidmvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 */

public class SearchApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }

    public static Context getContext() {
        return context;
    }
}
