package raymond.musicguru;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import raymond.musicguru.di.components.AppComponent;
import raymond.musicguru.util.EventBus;

/**
 * Created by yanruiliu on 6/10/16.
 */
public class BaseActivity extends AppCompatActivity{

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    protected AppComponent getAppComponent(){
        return ((MusicApplication)getApplication()).getComponent();
    }

    public EventBus getEventBus() {
        return ((MusicApplication)getApplication()).getEventBus();
    }
}
