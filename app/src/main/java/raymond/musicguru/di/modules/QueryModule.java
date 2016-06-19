package raymond.musicguru.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import raymond.musicguru.data.http.HttpApi;
import raymond.musicguru.di.scopes.QueryScope;
import raymond.musicguru.domain.executor.PostExecutionThread;
import raymond.musicguru.domain.executor.ThreadExecutor;
import raymond.musicguru.domain.interactor.query.QueryMusicTask;
import raymond.musicguru.ui.presenter.QueryPresenter;

/**
 * Created by yanruiliu on 6/10/16.
 */
@Module
public class QueryModule {
    @Provides
    @QueryScope
    QueryMusicTask provideQueryMusicTask(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, HttpApi httpApi){
        return new QueryMusicTask(threadExecutor, postExecutionThread, httpApi);
    }

    @Provides
    @QueryScope
    QueryPresenter provideQueryPresenter(QueryMusicTask queryMusicTask, Context context){
        return new QueryPresenter(queryMusicTask, context);
    }
}
