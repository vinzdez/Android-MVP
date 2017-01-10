package androidmvp.vinzdez.com.androidmvp.model;

import java.util.ArrayList;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.model.realmmodel.SearchResultRealm;

/**
 * Created by Vicente Angcaway on 22/12/2016.
 */

public class Search {

    private List<SearchResultResponse> searchResultResponseList;
    private String key;

    public List<SearchResultResponse> getSearchResultResponseList() {
        return searchResultResponseList;
    }

    public void obtainFromResult(List<SearchResultRealm> searchResultRealmList, String key) {
        if (searchResultResponseList == null) {
            searchResultResponseList = new ArrayList<>();
        } else {
            searchResultResponseList.clear();
        }
        for (SearchResultRealm searchRealm : searchResultRealmList) {
            searchResultResponseList.add(new SearchResultResponse(searchRealm.getName(), searchRealm.getSource(), searchRealm.getDescription()));
        }
    }

    public void setKey(String key) {
        this.key = key;
    }
}
