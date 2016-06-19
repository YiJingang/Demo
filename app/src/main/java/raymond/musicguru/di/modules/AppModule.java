package raymond.musicguru.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import raymond.musicguru.domain.executor.JobExecutor;
import raymond.musicguru.domain.executor.PostExecutionThread;
import raymond.musicguru.domain.executor.ThreadExecutor;
import raymond.musicguru.domain.executor.UIThread;
import raymond.musicguru.util.EventBus;
import rx.Observable;

/**
 * Created by yanruiliu on 3/8/16.
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application){
        mApplication = application;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences() {
        return mApplication.getSharedPreferences("raymond.musicguru", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    Context providesContext(){
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    EventBus provideEventBus(){
        return new EventBus();
    }
}
