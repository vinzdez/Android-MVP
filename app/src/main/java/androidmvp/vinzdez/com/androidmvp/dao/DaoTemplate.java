package androidmvp.vinzdez.com.androidmvp.dao;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.List;

/**
 * Contains all standard DAO methods.
 *
 * DO'S
 * 1. Should be extended by all DAO even not all methods will be used.
 * 2. Promote method here if it is used in the code for more than 5 times
 * 3. All DAO method is responsible
 *
 */
public interface DaoTemplate<T, ID> {
  /**
   * @param id, primary key
   * @throws SQLException
   */
  @NonNull
  T get(@NonNull ID id) throws SQLException, DataNotFoundException;

  /**
   * @param id, primary key
   * @throws SQLException
   */
  @Nullable
  T find(@NonNull ID id) throws SQLException;

  /**
   * Search for all available search suggestion.
   *
   * @return an empty list when no results is found
   */
  @NonNull
  List<T> findAll() throws SQLException;

  /**
   * Handles both update and create
   *
   * @param src, the object to save
   * @throws SQLException
   */
  void save(@NonNull T src) throws SQLException;

  /**
   * Handles both update and create
   *
   * @throws SQLException
   */
  void save(@NonNull List<T> src) throws SQLException;

  /**
   * Handles create only. Should only be used if we are absolutely sure that src is not yet created
   *
   * @throws SQLException
   */
  void create(@NonNull T src) throws SQLException;

  /**
   * @param src, the model to delete
   * @return the number of deleted records
   * @throws SQLException
   */
  int delete(@NonNull T src) throws SQLException;
}
