package spdroid_adv.nstech.spdroid_adv.viewHOlders;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;

import spdroid_adv.nstech.spdroid_adv.R;
import spdroid_adv.nstech.spdroid_adv.common.ParentViewHolder;
import spdroid_adv.nstech.spdroid_adv.mvvm.model.User;

/**
 * Created by webwerks on 26/4/17.
 */

public class UserViewHolder extends ParentViewHolder {

    LinearLayout llRootChild;
    AppCompatTextView tvUserName;
    AppCompatTextView tvUserMObile;
    AppCompatTextView tvUserEmail;
    AppCompatTextView tvUserAddress;

    public UserViewHolder(View itemView) {
        super(itemView);
        llRootChild = (LinearLayout) itemView.findViewById(R.id.llRootChild);
        tvUserName = (AppCompatTextView) itemView.findViewById(R.id.tvUserName);
        tvUserMObile = (AppCompatTextView) itemView.findViewById(R.id.tvUserMObile);
        tvUserEmail  = (AppCompatTextView) itemView.findViewById(R.id.tvUserEmail);
        tvUserAddress = (AppCompatTextView) itemView.findViewById(R.id.tvUserAddress);
    }

    public void setData(User data){
        tvUserName.setText(data.getName());
        tvUserMObile.setText(data.getMobileNo());
        tvUserEmail.setText(data.getEmail());
        tvUserAddress.setText(data.getAddress());
    }

}
