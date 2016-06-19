package raymond.musicguru.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import raymond.musicguru.BaseActivity;
import raymond.musicguru.di.HasComponent;
import raymond.musicguru.util.EventBus;
import rx.Subscription;

/**
 * Created by yanruiliu on 6/10/16.
 */
public abstract class BaseFragment extends Fragment {

    Subscription eventSubscription;
    EventBus mEventBus;

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    protected EventBus getEventBus() {
        return mEventBus;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventBus = ((BaseActivity)getActivity()).getEventBus();
    }

    @Override
    public void onResume() {
        super.onResume();
        eventSubscription = ((BaseActivity)getActivity()).getEventBus().getEvents().subscribe(this::onEventReceived);
    }

    @Override
    public void onPause() {
        eventSubscription.unsubscribe();
        super.onPause();
    }

    protected abstract void onEventReceived(Object o);
}
