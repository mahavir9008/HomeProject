package demo.com.githubuser.adapter;

import android.arch.paging.PagedListAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.com.githubuser.R;
import demo.com.githubuser.model.GitHubUser;
import demo.com.githubuser.viewholder.GitHubViewHolder;

public class PageListAdapter extends PagedListAdapter<GitHubUser, GitHubViewHolder> {

    public PageListAdapter() {
        super(GitHubUser.DIFF_CALLBACK);
    }

    @Override
    public GitHubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new GitHubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GitHubViewHolder holder, int position) {

        GitHubUser gitHubUser = getItem(position);
        if (gitHubUser != null) {
            holder.bind(gitHubUser);
        } else {
            holder.clear();
        }

    }

//    public void click(Object data, RecycleAdapter.OnItemClickListener listener) {
//        itemView.setOnClickListener(v -> listener.onClick(data));
//    }
}
