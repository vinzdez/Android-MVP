package androidmvp.vinzdez.com.androidmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidmvp.vinzdez.com.androidmvp.R;
import androidmvp.vinzdez.com.androidmvp.model.SearchResultResponse;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vicente on 4/16/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private int lastAnimatedPosition = -1;
    private List<SearchResultResponse> searchResultResponses;
    private View itemView;
    private Context context;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        this.itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SearchResultResponse searchResultResponse = getSearchResultResponses().get(position);
        holder.title.setText(searchResultResponse.name);
        holder.description.setText(searchResultResponse.description);
        holder.link.setText(searchResultResponse.source);
        runEnterAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return getSearchResultResponses().size();
    }

    public void clearItems() {
        if (!getSearchResultResponses().isEmpty()) {
            getSearchResultResponses().clear();
            lastAnimatedPosition = -1;
        }
    }

    private void runEnterAnimation(View view, int position) {

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.pop_out);
            animation.setInterpolator(context, android.R.anim.decelerate_interpolator);
            view.startAnimation(animation);
        }
    }

    public List<SearchResultResponse> getSearchResultResponses() {
        if (searchResultResponses == null) {
            this.searchResultResponses = new ArrayList<>();
        }
        return searchResultResponses;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_desc)
        TextView description;
        @BindView(R.id.tv_link)
        TextView link;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
