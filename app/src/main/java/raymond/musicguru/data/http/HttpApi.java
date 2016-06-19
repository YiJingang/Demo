package raymond.musicguru.data.http;

import raymond.musicguru.data.http.response.QueryMusicResponse;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanruiliu on 6/9/16.
 */
public interface HttpApi {
    @Headers("apikey: your_key")
    @GET("query")
    Observable<QueryMusicResponse> queryMusic(@Query("s") String s, @Query("s") String size, @Query("s") String page);
}
