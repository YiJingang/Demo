package raymond.musicguru.ui.view.query;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import raymond.musicguru.R;

/**
 * Created by yanruiliu on 6/12/16.
 */
public class QueryResultListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.music_name) TextView mMusicName;
    @BindView(R.id.music_artist) TextView mMusicArtist;
    public QueryResultListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
