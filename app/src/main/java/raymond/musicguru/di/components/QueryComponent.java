package raymond.musicguru.di.components;

import dagger.Subcomponent;
import raymond.musicguru.di.modules.QueryModule;
import raymond.musicguru.di.scopes.QueryScope;
import raymond.musicguru.ui.view.query.QueryFragment;

/**
 * Created by yanruiliu on 6/11/16.
 */
@QueryScope
@Subcomponent(modules = {QueryModule.class})
public interface QueryComponent {
    void inject(QueryFragment fragment);
}
