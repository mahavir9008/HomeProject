package demo.com.githubuser.ui.common.main.fragment.github_user_detail_fragment.view;


import android.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import demo.com.githubuser.inject.scope.PerFragment;
import demo.com.githubuser.ui.common.view.BaseFragmentModule;

@Module(includes = {
        BaseFragmentModule.class,
})
public abstract class UserDetailFragmentModule {

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     *
     * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(UserDetailFragment userDetailFragment);


}
