package demo.com.githubuser.inject.component;

import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.com.githubuser.App;
import demo.com.githubuser.persistence.dao.TableGithubUserDao;
import demo.com.githubuser.persistence.database.AppDatabase;

@Module
public abstract class DataBaseModule {

    @Provides
    @Singleton
    public static AppDatabase provideDatabase(App app) {
        return Room.databaseBuilder(app, AppDatabase.class, "AppDatabase.db").fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    public static TableGithubUserDao provideDatabaseDao(AppDatabase appDatabase) {
        return appDatabase.tableGithubUserDao();
    }
}
