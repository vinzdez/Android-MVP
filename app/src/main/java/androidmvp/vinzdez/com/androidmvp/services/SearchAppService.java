package androidmvp.vinzdez.com.androidmvp.services;

import androidmvp.vinzdez.com.androidmvp.dao.realm.DaoFactory;
import androidmvp.vinzdez.com.androidmvp.dao.realm.RealmDaoFactory;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public abstract class SearchAppService {

    public DaoFactory getDaoFactory() {
        return RealmDaoFactory.getInstance();
    }

}
