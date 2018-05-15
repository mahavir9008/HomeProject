package demo.com.githubuser.ui.common.main.fragment.github_user_fragment.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import javax.inject.Inject;

import demo.com.githubuser.model.GitHubUser;
import demo.com.githubuser.persistence.database.AppDatabase;

public class MainViewModel extends ViewModel {

    private static final int INITIAL_LOAD_KEY = 0;
    private static final int PAGE_SIZE = 10;
    private static final int PREFETCH_DISTANCE = 5;

    final public LiveData<PagedList<GitHubUser>> gListLiveData;
    @Inject
    AppDatabase appDatabase;

    public MainViewModel() {
        gListLiveData = appDatabase.tableGithubUserDao().githubuser().create(INITIAL_LOAD_KEY, new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setPrefetchDistance(PREFETCH_DISTANCE)
                .setEnablePlaceholders(true)
                .build()
        );
    }
}