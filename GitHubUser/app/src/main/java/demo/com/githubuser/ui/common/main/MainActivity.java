package demo.com.githubuser.ui.common.main;

import android.os.Bundle;

import demo.com.githubuser.R;
import demo.com.githubuser.ui.common.BaseActivity;
import demo.com.githubuser.ui.common.main.fragment.github_user_detail_fragment.view.UserDetailFragment;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.ActivityListener;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.GitHubUserFragment;

public class MainActivity extends BaseActivity implements ActivityListener {


    private GitHubUserFragment gitHubUserFragment;
    private UserDetailFragment userDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gitHubUserFragment = new GitHubUserFragment();
        addFragment(R.id.container, gitHubUserFragment);
    }

    @Override
    public void onCreateFragment() {
        userDetailFragment = new UserDetailFragment();
        addFragment(R.id.container, userDetailFragment);
    }
}
