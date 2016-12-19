package androidmvp.vinzdez.com.androidmvp.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.presenter.ListContract;
import androidmvp.vinzdez.com.androidmvp.view.SearchCriteriaView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Vicente on 4/16/2016.
 */
public class ListFragment extends Fragment implements SearchCriteriaView {

    private Context context;

    private View listFragVIew;
    private ListAdapter listAdapter;
    private ListContract.Presenter listPresenter;

    @BindView(R.id.id_recycler_view)
    RecyclerView recyclerView;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (listFragVIew == null) {
            this.context = getActivity();
            this.listFragVIew = inflater.inflate(R.layout.fragment_list, container, false);
            ButterKnife.bind(this, listFragVIew);
            this.listAdapter = new ListAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(listAdapter);
        }

        return listFragVIew;
    }

    @Override
    public void onStart() {
        super.onStart();
        listPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(@NonNull ListContract.Presenter presenter) {
        listPresenter = checkNotNull(presenter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listPresenter.find(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


}
