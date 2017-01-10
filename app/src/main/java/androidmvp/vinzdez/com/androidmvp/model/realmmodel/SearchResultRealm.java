package androidmvp.vinzdez.com.androidmvp.model.realmmodel;

import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public class SearchResultRealm extends RealmObject {

    //A default public constructor with no argument must be declared if a custom constructor is declared.
    public SearchResultRealm() {

    }


    public SearchResultRealm(String name, String source, String description) {
        this.name = name;
        this.source = source;
        this.description = description;
    }

    public String name;
    public String source;
    public String description;

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
