package raymond.musicguru.data.http.request;

/**
 * Created by yanruiliu on 6/10/16.
 */
public class QueryRequestParams {
    String s;
    String size;
    String page;

    public QueryRequestParams(String s, String size, String page) {
        this.s = s;
        this.size = size;
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public String getS() {
        return s;
    }

    public String getSize() {
        return size;
    }
}
