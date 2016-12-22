package androidmvp.vinzdez.com.androidmvp.dao.realm;

import android.content.Context;
import android.util.Log;

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

    private RealmDaoFactory() {
        this.databaseManager = new DatabaseManager(DATABASE_NAME, DATABASE_VERSION);
    }

    public static void initializeDatabase(Context context) throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new RealmDaoFactory();
        }
    }

    public static DaoFactory getInstance(Context context) {
        if (INSTANCE == null) {
            try {
                initializeDatabase(context);
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
