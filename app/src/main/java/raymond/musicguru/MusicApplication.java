package raymond.musicguru;

import android.app.Application;

import javax.inject.Inject;

import raymond.musicguru.di.HasComponent;
import raymond.musicguru.di.components.AppComponent;
import raymond.musicguru.di.components.DaggerAppComponent;
import raymond.musicguru.di.modules.AppModule;
import raymond.musicguru.di.modules.NetworkModule;
import raymond.musicguru.util.EventBus;

/**
 * Created by yanruiliu on 6/9/16.
 */
public class MusicApplication extends Application implements HasComponent<AppComponent>{
    private static final String ROOT_URL = "http://apis.baidu.com/geekery/music/";
    private AppComponent mAppComponent;

    @Inject
    EventBus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpDependencies();
    }

    @Override
    public AppComponent getComponent() {
        return mAppComponent;
    }

    public EventBus getEventBus() {
        return bus;
    }

    public void setUpDependencies() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(ROOT_URL))
                .build();
        mAppComponent.inject(this);
    }
}
