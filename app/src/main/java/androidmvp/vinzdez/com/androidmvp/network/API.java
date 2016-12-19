package androidmvp.vinzdez.com.androidmvp.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidmvp.vinzdez.com.androidmvp.SearchApp;
import androidmvp.vinzdez.com.androidmvp.services.api.APISearch;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vicente Angcaway on 19/12/2016.
 */

public class API {

    public static final String SERVER_URL = "http://www.googlesearchcrawler.vinceangcaway.xyz/";

    private static API instance;
    private APISearch apiSearch;

    private API() {
        OkHttpClient client = new OkHttpClient();
        // client.interceptors().add(new LoggingInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        this.apiSearch = retrofit.create(APISearch.class);
    }

    public static synchronized API getInstance() {
        if (instance == null) {
            instance = new API();
        }
        return instance;
    }

    public APISearch getApiSearch() {
        return apiSearch;
    }

    public static boolean isConnected() {
        ConnectivityManager conMgr = (ConnectivityManager) SearchApp.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null || !i.isConnected() || !i.isAvailable()) {
            return false;
        }
        return true;
    }
}
