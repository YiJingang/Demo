package raymond.musicguru.domain.executor;

import rx.Scheduler;

/**
 * Created by yanruiliu on 3/9/16.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
