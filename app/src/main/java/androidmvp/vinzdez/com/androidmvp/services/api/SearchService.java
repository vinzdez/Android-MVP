package androidmvp.vinzdez.com.androidmvp.services.api;

import android.support.annotation.NonNull;

import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;

/**
 * Created by Vicente Angcaway on 20/12/2016.
 */

public interface SearchService{

    interface SearchResultCallback{
        void onResultLoaded(List<SearchResultResponse> searchResultResponseList);
    }

    void find(@NonNull SearchResultCallback callback , String search);

}
