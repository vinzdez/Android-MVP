package androidmvp.vinzdez.com.androidmvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vicente Angcaway on 16/12/2016.
 */

public class SearchResult {

    @SerializedName("name")
    public String name;
    @SerializedName("source")
    public String source;
    @SerializedName("description")
    public String description;
}
