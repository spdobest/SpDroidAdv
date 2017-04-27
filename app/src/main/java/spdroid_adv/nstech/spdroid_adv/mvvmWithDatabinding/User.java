package spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import spdroid_adv.nstech.spdroid_adv.BR;

public class User extends BaseObservable {
 
    private String name;
    private String email;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Bindable
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}