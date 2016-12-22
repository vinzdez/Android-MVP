package androidmvp.vinzdez.com.androidmvp.dao.realm;

import android.content.Context;
import android.util.Log;

import androidmvp.vinzdez.com.androidmvp.SearchApp;
import androidmvp.vinzdez.com.androidmvp.dao.DatabaseManager;
import androidmvp.vinzdez.com.androidmvp.dao.SearchResultDao;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public class RealmDaoFactory implements DaoFactory {

    private static final String DATABASE_NAME = "search.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = RealmDaoFactory.class.getSimpleName();

    private static RealmDaoFactory INSTANCE;
    private DatabaseManager databaseManager;
    private SearchResultDao searchResultDao;

    private RealmDaoFactory(Context context) {
        this.databaseManager = new DatabaseManager(DATABASE_NAME, DATABASE_VERSION, context);
    }

    public static DaoFactory getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new RealmDaoFactory(SearchApp.getContext().getApplicationContext());
            } catch (Exception e) {
                String message = "Error initializing database: " + e.toString();
                Log.e(TAG, message);
            }
        }
        return INSTANCE;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    @Override
    public SearchResultDao searchResultDao() {
        if (searchResultDao == null) {
            this.searchResultDao = new SearchResultRealmDao(getDatabaseManager().getRealmInstance());

        }
        return searchResultDao;
    }
}
