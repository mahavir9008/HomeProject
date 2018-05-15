package demo.com.githubuser.ui.common.main;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.com.githubuser.inject.scope.PerActivity;
import demo.com.githubuser.inject.scope.PerFragment;
import demo.com.githubuser.ui.common.BaseActivityModule;
import demo.com.githubuser.ui.common.main.fragment.github_user_detail_fragment.view.UserDetailFragment;
import demo.com.githubuser.ui.common.main.fragment.github_user_detail_fragment.view.UserDetailFragmentModule;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.ActivityListener;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.GitHubUserFragment;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.GitHubUserFragmentModule;

/**
 * Provides main activity dependencies.
 */
@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    /**
     * Provides the injector for the {@link GitHubUserFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = GitHubUserFragmentModule.class)
    abstract GitHubUserFragment GitHubUserFragmentInjector();

    /**
     * Provides the injector for the {@link GitHubUserFragmentModule}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     *
     * This is used for example 4, which displays {@link GitHubUserFragmentModule} as a
     * {@link android.app.DialogFragment}.
     */
    @PerFragment
    @ContributesAndroidInjector(modules = UserDetailFragmentModule.class)
    abstract UserDetailFragment userDetailFragmentInjector();


    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link Activity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * @param mainActivity the activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract Activity activity(MainActivity mainActivity);

    @Binds
    @PerActivity
    abstract ActivityListener getActivityListener(MainActivity activityListener);

}