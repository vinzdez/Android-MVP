package androidmvp.vinzdez.com.androidmvp.services.api;

import android.support.annotation.NonNull;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResult;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 * API
 */

public interface SearchServiceApi {

    interface Callback<T> {
        void onLoad(T callback);
    }

    void find(@NonNull Callback<List<SearchResult>> callback, String find);
}
