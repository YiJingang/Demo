package raymond.musicguru.ui.event;

/**
 * Created by yanruiliu on 6/19/16.
 */
public class QueryEvent {
    final String mKeyWord;
    public QueryEvent(String keyWord) {
        mKeyWord = keyWord;
    }
    public String getKeyWord(){
        return mKeyWord;
    }
}
