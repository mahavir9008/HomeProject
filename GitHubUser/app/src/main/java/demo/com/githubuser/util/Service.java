package demo.com.githubuser.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import demo.com.githubuser.api.NetworkService;
import demo.com.githubuser.model.GitHubUser;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class Service {
    private final NetworkService networkService;
    private Disposable disposable;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    /**
     * @param getForumListCallback - update the data to the presenter
     * @return - all forum data
     */
    public Disposable getforumDataList(final GetForumListCallback getForumListCallback) {

        Observable.concatArrayEager(getDatafromtheOffline().debounce(400, TimeUnit.MILLISECONDS), getDatafromtheNetwork()).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<GitHubUser>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<GitHubUser> gitHubUsers) {
                getForumListCallback.onSuccess(gitHubUsers);
            }

            @Override
            public void onError(Throwable e) {
                getForumListCallback.onError(new NetworkError(e));
            }

            @Override
            public void onComplete() {

            }
        });

        return disposable;
    }


    private Observable<List<GitHubUser>> getDatafromtheNetwork() {
        return networkService.getUserList()
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation()).doOnNext(new Consumer<List<GitHubUser>>() {
                    @Override
                    public void accept(List<GitHubUser> gitHubUsers) throws Exception {
                        // Add in the DB
                    }
                });

    }

    private Observable<List<GitHubUser>> getDatafromtheOffline() {
        return networkService.getUserList().filter(it -> it.size() > 0)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

    }


    /**
     * listener which update the data to presenter
     */
    public interface GetForumListCallback {
        void onSuccess(List<GitHubUser> combineData);

        void onError(NetworkError networkError);

    }
}