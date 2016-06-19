package raymond.musicguru.data.http.response;

import java.util.List;

/**
 * Created by yanruiliu on 6/9/16.
 */
public class QueryMusicResponse {
    public int code = 0;
    public String status;
    public String msg;
    public QueryMusicData data;

    public List<QueryMusicData.QueryItem> getData(){
        return data.getData();
    }

    public class QueryMusicData {
        public int current_page;
        public String keyword;
        public int total_rows;
        public int total_page;
        public int page_size;
        public List<QueryItem> data;

        public class QueryItem {
            public String filename;
            public String extname;
            public long m4afilesize;
            public long filesize;
            public int bitrate;
            public int isnew;
            public int duration;
            public String album_name;
            public String singername;
            public String hash;
        }

        public List<QueryItem> getData(){
            return data;
        }
    }
}
