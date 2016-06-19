package raymond.musicguru.di.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by yanruiliu on 6/11/16.
 */
@Scope
@Retention(RUNTIME)
public @interface QueryScope {
}
