package demo.com.githubuser.ui.common.main.fragment.github_user_fragment.presenter;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import demo.com.githubuser.BuildConfig;
import demo.com.githubuser.api.NetworkService;
import demo.com.githubuser.util.Service;
import demo.com.githubuser.util.URL;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class NetModule {
    @Provides
    static CompositeDisposable getCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    static Retrofit provideCall() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();

                    // Customize the request
                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .removeHeader("Pragma")
                            .header("Cache-Control", String.format("max-age=%d", BuildConfig.CACHETIME))
                            .build();
                    okhttp3.Response response = chain.proceed(request);
                    response.cacheResponse();
                    // Customize or return the response
                    return response;
                })

                .build();


        return new Retrofit.Builder()
                .baseUrl(URL.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build();
    }

    @Provides
    @SuppressWarnings("unused")
    public static NetworkService providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @SuppressWarnings("unused")
    public static Service providesService(
            NetworkService networkService) {
        return new Service(networkService);
    }


}
