package demo.com.githubuser.persistence.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import demo.com.githubuser.model.GitHubUser;

@Dao
public interface TableGithubUserDao {

    @Query("SELECT * FROM githubUser ORDER BY id ASC")
    LivePagedListProvider<Integer, GitHubUser> githubuser();


    @Query("SELECT COUNT(*) FROM githubUser")
    Integer pokemonsCount();

    @Insert
    void insert(List<GitHubUser> gitHubUsers);


    @Query("DELETE FROM githubUser")
    void deleteAll();

}
