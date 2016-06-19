package raymond.musicguru.ui.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import raymond.musicguru.data.http.request.QueryRequestParams;
import raymond.musicguru.data.http.response.QueryMusicResponse;
import raymond.musicguru.domain.interactor.DefaultSubscriber;
import raymond.musicguru.domain.interactor.query.QueryMusicTask;
import raymond.musicguru.ui.view.QueryView;

/**
 * Created by yanruiliu on 6/10/16.
 */
public class QueryPresenter implements BasePresenter {

    private QueryMusicTask mQueryMusicTask;
    private QueryView mQueryView;
    private Context mContext;


    public QueryPresenter(@NonNull QueryMusicTask queryMusicTask, @NonNull Context context) {
        this.mQueryMusicTask = queryMusicTask;
        this.mContext = context;
    }

    public void setView(@NonNull QueryView queryView) {
        this.mQueryView = queryView;
    }

    public void queryMusic(final String keyWord) {
        mQueryMusicTask.execute(new ShowQueryResultSubscriber(mContext), new QueryRequestParams(keyWord, null, null));
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mQueryMusicTask.unsubscribe();
        mQueryView = null;
    }

    private final class ShowQueryResultSubscriber extends DefaultSubscriber<QueryMusicResponse> {
        public ShowQueryResultSubscriber(Context context) {
            super(context);
        }

        @Override
        public void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onNext(QueryMusicResponse queryMusicResponse) {
            super.onNext(queryMusicResponse);
            if(mQueryView != null){
                mQueryView.DoAfterQuerySucceed(queryMusicResponse.getData());
            }
        }
    }
}
