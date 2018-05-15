package demo.com.githubuser.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.com.githubuser.R;
import demo.com.githubuser.model.GitHubUser;

public class GitHubViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.username)
    TextView tvForumTitle;
    @BindView(R.id.avator_image)
    ImageView imageView;
    @BindView(R.id.created_date)
    TextView tvCreatedData;

    public GitHubViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(GitHubUser gitHubUser) {
        tvForumTitle.setText(gitHubUser.getLogin());
        Glide.with(itemView.getContext())
                .load(gitHubUser.getAvatarUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }

    public void clear() {
        itemView.invalidate();
        tvForumTitle.invalidate();
        imageView.invalidate();
    }
}
