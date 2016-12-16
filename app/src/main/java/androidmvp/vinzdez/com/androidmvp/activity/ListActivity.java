package androidmvp.vinzdez.com.androidmvp.activity;

import android.os.Bundle;

import androidmvp.vinzdez.com.androidmvp.presenter.ListPresenter;
import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.util.ActivityUtils;

public class ListActivity extends BaseActivity {

    private ListPresenter listPresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
    }

    private void initFragment() {
        ListFragment listFragment =
                (ListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (listFragment == null) {
            listFragment = ListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), listFragment, R.id.contentFrame);
        }

        listPresenter = new ListPresenter(listFragment);
    }


}
