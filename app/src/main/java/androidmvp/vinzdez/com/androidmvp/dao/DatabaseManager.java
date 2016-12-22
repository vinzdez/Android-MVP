package androidmvp.vinzdez.com.androidmvp.dao;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public class DatabaseManager {

    private Realm realm;

    private static DatabaseManager REALM_INSTANCE;

    public static DatabaseManager getInstance() {
        return REALM_INSTANCE;
    }

    public Realm getRealmInstance() {
        return realm;
    }

    public DatabaseManager(String dbName, int verion) {
        if (getInstance() == null) {
            this.REALM_INSTANCE = this;
            this.realm = Realm.getDefaultInstance();
            RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().name(dbName).schemaVersion(verion).build();
            realm.setDefaultConfiguration(realmConfiguration);
        }
    }
}
