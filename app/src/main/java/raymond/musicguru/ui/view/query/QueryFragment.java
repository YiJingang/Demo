package raymond.musicguru.ui.view.query;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import raymond.musicguru.R;
import raymond.musicguru.data.http.response.QueryMusicResponse;
import raymond.musicguru.di.components.QueryComponent;
import raymond.musicguru.ui.BaseFragment;
import raymond.musicguru.ui.event.QueryEvent;
import raymond.musicguru.ui.presenter.QueryPresenter;
import raymond.musicguru.ui.view.QueryView;

/**
 * A placeholder fragment containing a simple view.
 */
public class QueryFragment extends BaseFragment implements QueryView {

    private static final String TAG = QueryFragment.class.getSimpleName();

    @Inject QueryPresenter mQueryPresenter;
    @Inject Context mContext;
    @BindView(R.id.query_music_result_list) RecyclerView mMusicList;
    private Unbinder unbinder;
    private QueryResultListAdapter mAdapter;

    public QueryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(QueryComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        unbinder = ButterKnife.bind(this, view);
        mQueryPresenter.setView(this);
        mAdapter = new QueryResultListAdapter();
        mMusicList.setLayoutManager(new LinearLayoutManager(mContext));
        mMusicList.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(null != mQueryPresenter){
            mQueryPresenter.resume();
        }
    }

    @Override
    public void onPause() {
        if(null != mQueryPresenter){
            mQueryPresenter.pause();
        }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if(null != mQueryPresenter){
            mQueryPresenter.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void DoAfterQuerySucceed(List<QueryMusicResponse.QueryMusicData.QueryItem> data) {
        mAdapter.resetData(data);
    }

    @Override
    public void DoAfterQueryFailed() {

    }

    @Override
    public void ShowWaiting() {

    }

    @Override
    public void HideWaiting() {

    }

    @Override
    protected void onEventReceived(Object o) {
        if(null != o && o instanceof QueryEvent){
            if(null != mQueryPresenter){
                mQueryPresenter.queryMusic(((QueryEvent)o).getKeyWord());
            }
        }
    }
}
