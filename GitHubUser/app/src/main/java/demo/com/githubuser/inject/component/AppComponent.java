package demo.com.githubuser.inject.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import demo.com.githubuser.App;

/**
 * Injects application dependencies.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}