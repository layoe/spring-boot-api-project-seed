package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.User;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/18.
 */
public interface UserService extends Service<User> {
    User getOne(int id);
    int getSize();
    List<User> getJoinData();
}
