package demo.com.githubuser.ui.common.main.fragment.github_user_fragment.presenter;


import dagger.Binds;
import dagger.Module;
import demo.com.githubuser.inject.scope.PerFragment;

@Module(includes = NetModule.class)
public abstract class GitHubUserPresenterModule {

    @Binds
    @PerFragment
    abstract GitHubUserPresenterView gitHubUserPresenterView(GithubUserPresenterImp githubUserPresenterImp);
}
