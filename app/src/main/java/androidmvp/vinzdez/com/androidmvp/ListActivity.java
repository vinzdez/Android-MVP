package androidmvp.vinzdez.com.androidmvp;

import android.os.Bundle;

import androidmvp.vinzdez.com.androidmvp.util.ActivityUtils;
import butterknife.ButterKnife;

public class ListActivity extends BaseActivity {

    private ListPresenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_list);
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
