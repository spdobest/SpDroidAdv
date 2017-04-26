package spdroid_adv.nstech.spdroid_adv.baseAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import spdroid_adv.nstech.spdroid_adv.common.ParentViewHolder;
import spdroid_adv.nstech.spdroid_adv.common.ViewHolderManager;
import spdroid_adv.nstech.spdroid_adv.mvvmWithoutDataBinding.model.User;
import spdroid_adv.nstech.spdroid_adv.viewHOlders.UserViewHolder;

/**
 * Created by webwerks on 26/4/17.
 */

public class CommonRecyclerAdapter extends RecyclerView.Adapter<ParentViewHolder> {

    Context context;
    List<User> listData;

    public static final int ROW_USER = 1;
    public static final int ROW_NEWS = 2;
    public static final int ROW_OTHER = 3;

    public CommonRecyclerAdapter(Context context, List<User> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public ParentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolderManager.getViewView(viewType,parent);
    }

    @Override
    public void onBindViewHolder(ParentViewHolder holder, int position) {
        if(holder instanceof UserViewHolder){
            User  user  = (User) listData.get(position);
            ((UserViewHolder)holder).setData(user);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object object =listData.get(position);
        int rowtype=0;
        if(object instanceof User){
            rowtype = ROW_USER;
        }
        return rowtype;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
