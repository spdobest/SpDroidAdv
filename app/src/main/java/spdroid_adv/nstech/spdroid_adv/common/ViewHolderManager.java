package spdroid_adv.nstech.spdroid_adv.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spdroid_adv.nstech.spdroid_adv.R;
import spdroid_adv.nstech.spdroid_adv.baseAdapter.CommonRecyclerAdapter;
import spdroid_adv.nstech.spdroid_adv.viewHOlders.UserViewHolder;

/**
 * Created by webwerks on 26/4/17.
 */

public class ViewHolderManager {

    Context context;
    Object object;
    int rowType;

   /* public ViewHolderManager(Context context, Object object, int rowType) {
        this.context = context;
        this.object = object;
        this.rowType = rowType;
    }*/

    public static ParentViewHolder getViewView(int viewType, ViewGroup parent){

        ParentViewHolder parentViewHolder = null;

        switch (viewType){
            case CommonRecyclerAdapter.ROW_NEWS :
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.itemview_user, parent, false);

                parentViewHolder =  new UserViewHolder(itemView);
                break;
            case CommonRecyclerAdapter.ROW_OTHER:

                break;
            case CommonRecyclerAdapter.ROW_USER :

                break;
        }
        return parentViewHolder;
    }
}
