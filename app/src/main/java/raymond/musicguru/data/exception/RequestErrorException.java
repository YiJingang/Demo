package raymond.musicguru.data.exception;

/**
 * Created by yanruiliu on 6/10/16.
 */
public class RequestErrorException extends IllegalArgumentException{
    public RequestErrorException(String detailMessage) {
        super("Request parameter class type should be " + detailMessage);
    }
}
