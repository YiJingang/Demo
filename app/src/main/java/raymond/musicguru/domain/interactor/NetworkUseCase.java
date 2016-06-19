package raymond.musicguru.domain.interactor;

import android.provider.SyncStateContract;

import raymond.musicguru.data.http.HttpApi;
import raymond.musicguru.domain.executor.PostExecutionThread;
import raymond.musicguru.domain.executor.ThreadExecutor;
import raymond.musicguru.domain.interactor.UseCase;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by yanruiliu on 6/10/16.
 */
public abstract class NetworkUseCase extends UseCase {

    public HttpApi httpApi;

    public NetworkUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, HttpApi httpApi) {
        super(threadExecutor, postExecutionThread);
        this.httpApi = httpApi;
    }

//    public NetworkUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Observable<HttpApi> httpApiObservable) {
//        super(threadExecutor, postExecutionThread);
//        httpApiObservable.subscribeOn(Schedulers.from(threadExecutor))
//                .observeOn(postExecutionThread.getScheduler())
//                .subscribe(new Subscriber<HttpApi>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(HttpApi httpApi) {
//                        NetworkUseCase.this.httpApi = httpApi;
//                    }
//                });
//    }
}
