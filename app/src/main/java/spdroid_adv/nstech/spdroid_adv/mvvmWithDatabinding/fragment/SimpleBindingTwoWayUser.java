package spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding.fragment;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import spdroid_adv.nstech.spdroid_adv.BR;

public class SimpleBindingTwoWayUser extends BaseObservable {
   private String name;

   @Bindable
   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
       notifyPropertyChanged(BR.name);
   }
}