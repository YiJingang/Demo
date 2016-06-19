package raymond.musicguru.ui.view.query;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import raymond.musicguru.R;
import raymond.musicguru.data.http.response.QueryMusicResponse;

/**
 * Created by yanruiliu on 6/12/16.
 */
public class QueryResultListAdapter extends RecyclerView.Adapter<QueryResultListViewHolder> {

    List<QueryMusicResponse.QueryMusicData.QueryItem> mMusicData = new ArrayList<>();

    @Override
    public QueryResultListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.query_result_list_item, parent, false);
        return new QueryResultListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QueryResultListViewHolder holder, int position) {
        QueryMusicResponse.QueryMusicData.QueryItem item = mMusicData.get(position);
        holder.mMusicName.setText(item.filename);
        holder.mMusicArtist.setText(item.singername);
    }

    @Override
    public int getItemCount() {
        return mMusicData.size();
    }

    public void addData(List<QueryMusicResponse.QueryMusicData.QueryItem> data){
        mMusicData.addAll(new ArrayList<>(data));
        notifyDataSetChanged();
    }

    public void resetData(List<QueryMusicResponse.QueryMusicData.QueryItem> data){
        mMusicData.clear();
        addData(data);
    }
}
