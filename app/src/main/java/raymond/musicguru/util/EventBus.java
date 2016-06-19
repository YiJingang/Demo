package raymond.musicguru.util;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yanruiliu on 6/19/16.
 */
public class EventBus {
    private PublishSubject<Object> subject = PublishSubject.create();

    public void setEvent(Object object) {
        subject.onNext(object);
    }

    public Observable<Object> getEvents() {
        return subject;
    }
}
