package demo.com.githubuser.ui.common.main.fragment.github_user_fragment;

import android.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import demo.com.githubuser.inject.scope.PerFragment;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.presenter.GitHubUserPresenterModule;
import demo.com.githubuser.ui.common.view.BaseFragmentModule;

/**
 * Provides main fragment dependencies.
 */
@Module(includes = {BaseFragmentModule.class, GitHubUserPresenterModule.class})
public abstract class GitHubUserFragmentModule {

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param gitHubUserFragment the main fragment
     * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(GitHubUserFragment gitHubUserFragment);


    @Binds
    @PerFragment
    abstract GitHubUserFragmentListener gitHubUserFragmentListener(GitHubUserFragment gitHubUserFragment);


}