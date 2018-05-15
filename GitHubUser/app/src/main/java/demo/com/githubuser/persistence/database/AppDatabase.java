package demo.com.githubuser.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import demo.com.githubuser.model.GitHubUser;
import demo.com.githubuser.persistence.dao.TableGithubUserDao;

@Database(entities = GitHubUser.class, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TableGithubUserDao tableGithubUserDao();

}
