package spdroid_adv.nstech.spdroid_adv.mvvm.model;

import java.util.List;

/**
 * Created by webwerks on 26/4/17.
 */

public class User  {

    String name;
    String mobileNo;
    String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;
    List<String> listSize;

    public User(String name, String mobileNo,String email, String address/*, List<String> listSize*/) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.address = address;
//        this.listSize = listSize;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getListSize() {
        return listSize;
    }

    public void setListSize(List<String> listSize) {
        this.listSize = listSize;
    }
}
