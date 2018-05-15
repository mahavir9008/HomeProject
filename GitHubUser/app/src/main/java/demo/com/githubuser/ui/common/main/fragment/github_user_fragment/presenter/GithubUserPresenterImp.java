package demo.com.githubuser.ui.common.main.fragment.github_user_fragment.presenter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import demo.com.githubuser.inject.scope.PerFragment;
import demo.com.githubuser.model.GitHubUser;
import demo.com.githubuser.persistence.database.AppDatabase;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.GitHubUserFragmentListener;
import demo.com.githubuser.ui.common.presenter.BasePresenter;
import demo.com.githubuser.util.NetworkError;
import demo.com.githubuser.util.Service;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@PerFragment
public final class GithubUserPresenterImp extends BasePresenter<GitHubUserFragmentListener> implements GitHubUserPresenterView {

    @Inject
    public Service service;
    @Inject
    public CompositeDisposable compositeDisposable;
    @Inject
    GitHubUserFragmentListener gitHubUserFragmentListener;
    @Inject
    AppDatabase appDatabase;


    @Inject
    GithubUserPresenterImp(GitHubUserFragmentListener gitHubUserFragmentListener) {
        super(gitHubUserFragmentListener);
    }

    @Override
    public void onStart(@Nullable Bundle savedInstanceState) {
        super.onStart(savedInstanceState);
        service.getforumDataList(new Service.GetForumListCallback() {
            @Override
            public void onSuccess(List<GitHubUser> combineData) {
                addtoDB(combineData);
                Log.v("Data came", "onsucess Gituserpresnet");
              //  appDatabase.tableGithubUserDao().insert(combineData);
                //Log.v("datais ..........", "" + appDatabase.tableGithubUserDao().pokemonsCount());
                // gitHubUserFragmentListener.onGetData(combineData);
            }

            @Override
            public void onError(NetworkError networkError) {
                Log.v("Data came", "onerror Gituserpresnet");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("on god", "on  resume from GithubUserPresenterImp");
    }

    @Override
    public void onDataCame() {
    }

    private void addtoDB(List<GitHubUser> combineData) {
        Completable.fromAction(() -> appDatabase.tableGithubUserDao().insert(combineData))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.v("on god", "data successfull");
                        gitHubUserFragmentListener.onGetData();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("on god", "data error");
                    }
                });
    }
}
