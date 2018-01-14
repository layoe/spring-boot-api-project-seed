package com.company.project.model;

import javax.persistence.Transient;
import java.util.List;

public class User2 extends User{
    @Transient
    private List<UserStr> listUserStr;

    public List<UserStr> getListUserStr() {
        return listUserStr;
    }


    public void setListUserStr(List<UserStr> listUserStr) {
        this.listUserStr = listUserStr;
    }

}