package androidmvp.vinzdez.com.androidmvp.dao.realm;

import androidmvp.vinzdez.com.androidmvp.dao.SearchResultDao;

/**
 * DaoFactory was introduced to minimize the effect when changing database or data access framework
 * <p>
 * DO's
 * 1. Should be implemented by all DaoFactory
 * 2. Returned DAO should be abstract (interface classes)
 * 3. For easier tracking maintain the list in alphabetical order
 * <p>
 * DON'TS
 * 1.
 * <p>
 */
public interface DaoFactory {

    SearchResultDao searchResultDao();

}
