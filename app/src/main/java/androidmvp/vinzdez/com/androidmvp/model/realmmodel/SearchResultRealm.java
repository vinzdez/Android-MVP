package androidmvp.vinzdez.com.androidmvp.model.realmmodel;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public class SearchResultRealm extends RealmObject {

    //A default public constructor with no argument must be declared if a custom constructor is declared.
    public SearchResultRealm() {
    }

    @PrimaryKey
    private long id;

    @SerializedName("name")
    public String name;
    @SerializedName("source")
    public String source;
    @SerializedName("description")
    public String description;
}
