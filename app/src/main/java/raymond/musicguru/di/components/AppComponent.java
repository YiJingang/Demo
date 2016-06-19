package raymond.musicguru.di.components;

import javax.inject.Singleton;

import dagger.Component;
import raymond.musicguru.MusicApplication;
import raymond.musicguru.di.modules.AppModule;
import raymond.musicguru.di.modules.NetworkModule;
import raymond.musicguru.di.modules.QueryModule;
import raymond.musicguru.ui.view.QueryActivity;

/**
 * Created by yanruiliu on 6/10/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MusicApplication musicApplication);
    void inject(QueryActivity queryActivity);
    QueryComponent NewQueryComponent(QueryModule module);
}
