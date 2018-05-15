package demo.com.githubuser.ui.common.main.fragment.github_user_fragment;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.com.githubuser.R;
import demo.com.githubuser.adapter.PageListAdapter;
import demo.com.githubuser.adapter.RecycleAdapter;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.presenter.GitHubUserPresenterView;
import demo.com.githubuser.ui.common.main.fragment.github_user_fragment.presenter.MainViewModel;
import demo.com.githubuser.ui.common.view.BaseViewFragment;
import android.support.v4.app.Fragment;

/**
 * Displays a set of buttons for the other activities.
 * <p>
 * <b>NOTE</b>
 * This fragment does not implement a view and host a presenter because there is no logic that
 * is done here. This fragment simply notifies the host Activity of the button click events that
 * occur.
 * <p>
 * With that said, this does not implement and MVPView interface nor does it extend
 * BaseViewFragment.
 * <p>
 * So why not just put the layout of this fragment into the Activity itself? We could do that but
 * we would lose the ability to reuse this fragment along with other fragments in different
 * activities if we wanted to (not that we would).
 * <p>
 * The activity only acts as the host to 1 or more fragments for inter-fragment communication. All
 * views and logic are in fragments.
 */
public final class GitHubUserFragment extends BaseViewFragment<GitHubUserPresenterView> implements GitHubUserFragmentListener,LifecycleOwner {


    @Inject
    ActivityListener activityListener;
    @Inject
    GitHubUserPresenterView gitHubUserPresenterView;
    @BindView(R.id.recycler_view)
    RecyclerView list;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    private RecycleAdapter recycleAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.github_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        init();
    }

    public void init() {
        list.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        list.setLayoutManager(new LinearLayoutManager(getActivity()));

//        recycleAdapter = new RecycleAdapter(getActivity(), new RecycleAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(Object Item) {
//                activityListener.onCreateFragment();
//            }
//        });
     //   list.setAdapter(recycleAdapter);

    }


    @Override
    public void onGetData() {
        progressBar.setVisibility(View.GONE);
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        PageListAdapter pageListAdapter = new PageListAdapter();


//  work on the project
       // mainViewModel.gListLiveData.observe(this,pageListAdapter::setList);
        list.setAdapter(pageListAdapter);
        //recycleAdapter.addData(combineData);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}