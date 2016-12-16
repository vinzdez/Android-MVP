package androidmvp.vinzdez.com.androidmvp.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidmvp.vinzdez.com.androidmvp.presenter.ListContract;
import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.model.Movie;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Vicente on 4/16/2016.
 */
public class ListFragment extends Fragment implements ListContract.View {

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
            recyclerView.addOnItemTouchListener(new RecylerTouchListener(context, recyclerView, this));
        }

        return listFragVIew;
    }

    @Override
    public void onResume() {
        super.onResume();
        listPresenter.start();
        listAdapter.setMoviesList(listPresenter.loadTasks(true));
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(@NonNull ListContract.Presenter presenter) {
        listPresenter = checkNotNull(presenter);
    }

    @Override
    public void onClick(CardView view, int position) {
        Movie movie = listAdapter.getMoviesList().get(position);
        Toast.makeText(context, movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongClick(CardView view, int position) {

    }

    public static class RecylerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ListContract.View clickListener;

        public RecylerTouchListener(Context context, final RecyclerView recyclerView, final ListContract.View clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick((CardView) child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick((CardView) child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
