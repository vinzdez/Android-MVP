package androidmvp.vinzdez.com.androidmvp.model;

import com.google.gson.annotations.SerializedName;

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
}
