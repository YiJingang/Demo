package raymond.musicguru.ui.view;

import java.util.List;

import raymond.musicguru.data.http.response.QueryMusicResponse;

/**
 * Created by yanruiliu on 6/10/16.
 */
public interface QueryView extends BaseView {
    void DoAfterQuerySucceed(List<QueryMusicResponse.QueryMusicData.QueryItem> data);
    void DoAfterQueryFailed();
}
