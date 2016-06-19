package raymond.musicguru.ui.view;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import raymond.musicguru.BaseActivity;
import raymond.musicguru.R;
import raymond.musicguru.di.HasComponent;
import raymond.musicguru.di.components.QueryComponent;
import raymond.musicguru.di.modules.QueryModule;
import raymond.musicguru.ui.event.QueryEvent;
import raymond.musicguru.ui.view.query.QueryFragment;

public class QueryActivity extends BaseActivity implements HasComponent<QueryComponent>{
    private static final String TAG = QueryActivity.class.getSimpleName();
    private QueryComponent mQueryComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mQueryComponent = getAppComponent().NewQueryComponent(new QueryModule());

        addFragment(R.id.fragment_container, new QueryFragment());
    }

    @Override
    public QueryComponent getComponent() {
        return mQueryComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_query, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                QueryActivity.this.getEventBus().setEvent(new QueryEvent(query));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
}
