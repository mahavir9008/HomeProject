package demo.com.githubuser.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.recyclerview.extensions.DiffCallback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "githubUser")
public class GitHubUser {

    public GitHubUser(){

    }

    public int getPrimary() {
        return primary;
    }

    public void setPrimary(int primary) {
        this.primary = primary;
    }

    @PrimaryKey(autoGenerate = true)
    private int primary;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    @Ignore
    private String gravatarId;
    @SerializedName("url")
    @Expose
    @Ignore
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @Ignore
    @SerializedName("followers_url")
    @Expose
    private String followersUrl;
    @Ignore
    @SerializedName("following_url")
    @Expose
    private String followingUrl;
    @Ignore
    @SerializedName("gists_url")
    @Expose
    private String gistsUrl;
    @SerializedName("starred_url")
    @Expose
    private String starredUrl;
    @Ignore
    @SerializedName("subscriptions_url")
    @Expose
    private String subscriptionsUrl;
    @Ignore
    @SerializedName("organizations_url")
    @Expose
    private String organizationsUrl;
    @Ignore
    @SerializedName("repos_url")
    @Expose
    private String reposUrl;
    @Ignore
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @Ignore
    @SerializedName("received_events_url")
    @Expose
    private String receivedEventsUrl;
    @Ignore
    @SerializedName("type")
    @Expose
    private String type;
    @Ignore
    @SerializedName("site_admin")
    private Boolean siteAdmin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public static final DiffCallback<GitHubUser> DIFF_CALLBACK = new DiffCallback<GitHubUser>() {
        @Override
        public boolean areItemsTheSame(@NonNull GitHubUser oldPokemon, @NonNull GitHubUser newPokemon) {
            return oldPokemon.primary == newPokemon.primary;
        }

        @Override
        public boolean areContentsTheSame(@NonNull GitHubUser oldPokemon, @NonNull GitHubUser newPokemon) {
            return oldPokemon.login.equals(newPokemon.login);
        }
    };
}