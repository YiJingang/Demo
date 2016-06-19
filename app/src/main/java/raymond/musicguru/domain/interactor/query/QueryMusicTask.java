package raymond.musicguru.domain.interactor.query;

import raymond.musicguru.data.http.HttpApi;
import raymond.musicguru.data.http.request.QueryRequestParams;
import raymond.musicguru.domain.executor.PostExecutionThread;
import raymond.musicguru.domain.executor.ThreadExecutor;
import raymond.musicguru.domain.interactor.NetworkUseCase;
import raymond.musicguru.data.exception.RequestErrorException;
import rx.Observable;

/**
 * Created by yanruiliu on 6/10/16.
 */
public class QueryMusicTask extends NetworkUseCase{

    public QueryMusicTask(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, HttpApi httpApi) {
        super(threadExecutor, postExecutionThread, httpApi);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Observable buildUseCaseObservable(Object request) {
        if(!(request instanceof QueryRequestParams)){
            throw new RequestErrorException(QueryRequestParams.class.getSimpleName());
        }
        QueryRequestParams params = (QueryRequestParams)request;
        return httpApi.queryMusic(params.getS(), params.getSize(), params.getPage());
    }
}
