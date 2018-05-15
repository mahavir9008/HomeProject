package demo.com.githubuser.ui.common.main.fragment.github_user_detail_fragment.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.com.githubuser.R;
import demo.com.githubuser.ui.common.view.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends BaseFragment {


    @BindView(R.id.hellochekc)
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        textView.setText("hello Hi");
    }

}
