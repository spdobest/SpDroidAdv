package spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spdroid_adv.nstech.spdroid_adv.R;
import spdroid_adv.nstech.spdroid_adv.databinding.FragmentBindingBinding;

/**
 * Created by webwerks on 27/4/17.
 */

public class BindingFragment extends Fragment {

    SimpleBindingTwoWayUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentBindingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_binding, container, false);

        user = new SimpleBindingTwoWayUser();
        user.setName(getString(R.string.app_name));
        binding.setUser(user);

        return binding.getRoot();
    }
}
