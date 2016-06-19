package raymond.musicguru.domain.executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by yanruiliu on 3/9/16.
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {}

    @Override public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
