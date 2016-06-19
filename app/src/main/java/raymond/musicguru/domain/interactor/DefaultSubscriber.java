package raymond.musicguru.domain.interactor;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.widget.Toast;

/**
 * Created by yanruiliu on 3/9/16.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {

    Context mContext;

    public DefaultSubscriber(Context context) {
        super();
        mContext = context;
    }

    @Override public void onCompleted() {
        // no-op by default.
    }

    @Override public void onError(Throwable e) {
        // no-op by default.
        e.printStackTrace();
    }

    @Override public void onNext(T t) {
        // no-op by default.
    }
}
