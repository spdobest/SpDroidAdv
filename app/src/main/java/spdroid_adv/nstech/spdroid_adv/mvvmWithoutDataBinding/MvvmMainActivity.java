package spdroid_adv.nstech.spdroid_adv.mvvmWithoutDataBinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import spdroid_adv.nstech.spdroid_adv.R;

/**
 * Created by webwerks on 26/4/17.
 */

public class MvvmMainActivity extends AppCompatActivity {

    RecyclerView recyclerViewUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        recyclerViewUser = (RecyclerView) findViewById(R.id.recyclerViewUser);

        ViewModel viewModel = new ViewModel(MvvmMainActivity.this);
        viewModel.setUserListData(recyclerViewUser);

    }
}
