package demo.com.githubuser.api;

import java.util.List;

import demo.com.githubuser.model.GitHubUser;
import demo.com.githubuser.util.URL;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * define api for network call
 */
public interface NetworkService {

    @GET(URL.APPEND_USER)
     Observable<List<GitHubUser>> getUserList();


}