package androidmvp.vinzdez.com.androidmvp.model;

import com.google.gson.annotations.SerializedName;

import androidmvp.vinzdez.com.androidmvp.model.realmmodel.SearchResultRealm;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public class SearchResultResponse {

    @SerializedName("name")
    public String name;
    @SerializedName("source")
    public String source;
    @SerializedName("description")
    public String description;

    public SearchResultResponse(String name, String source, String description) {
        this.name = name;
        this.source = source;
        this.description = description;
    }


    public SearchResultRealm toRealm() {
        return new SearchResultRealm(name, source, description);
    }
}
