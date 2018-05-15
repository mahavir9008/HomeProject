package demo.com.githubuser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.com.githubuser.R;
import demo.com.githubuser.model.GitHubUser;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<GitHubUser> data = new ArrayList<>();
    private Context context;


    public RecycleAdapter(Context context, OnItemClickListener listener) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {


        GitHubUser gitHubUser = data.get(position);
        holder.click(gitHubUser, listener);
        holder.tvForumTitle.setText(gitHubUser.getLogin());

        Glide.with(context)
                .load(gitHubUser.getAvatarUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);
        // holder.imageView.setText(forumData.getBody());
        // holder.tvCreatedData.setText(gitHubUser.ge);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(Object Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.username)
        TextView tvForumTitle;
        @BindView(R.id.avator_image)
        ImageView imageView;
        @BindView(R.id.created_date)
        TextView tvCreatedData;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void click(Object data, OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onClick(data));
        }
    }

    public void addData(List<GitHubUser> combineData) {
        this.data = combineData;
        notifyDataSetChanged();
    }
}