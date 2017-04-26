package spdroid_adv.nstech.spdroid_adv.mvvm;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import spdroid_adv.nstech.spdroid_adv.baseAdapter.CommonRecyclerAdapter;
import spdroid_adv.nstech.spdroid_adv.mvvm.model.User;

/**
 * Created by webwerks on 26/4/17.
 */

public class ViewModel extends Observable {
    Context mContext;
    LinearLayoutManager linearLayoutManager;
    List<User> listUser;

    public ViewModel(Context mContext) {
        this.mContext = mContext;
    }

    public void setUserListData(final RecyclerView recyclerView){

        listUser = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));


        new Handler().post(new Runnable() {
            @Override
            public void run() {
              for(int i = 0;i<20;i++){
                  listUser.add(new User("Name","90823048902384","abc@gmail.com","Street No 6, Mumbai "));

              }
                CommonRecyclerAdapter commonRecyclerAdapter =  new CommonRecyclerAdapter(mContext,listUser);
                recyclerView.setAdapter(commonRecyclerAdapter);
                commonRecyclerAdapter.notifyDataSetChanged();
            }
        });

    }

}
