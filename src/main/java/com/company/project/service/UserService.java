package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.User;


/**
 * Created by CodeGenerator on 2017/12/18.
 */
public interface UserService extends Service<User> {
    User getOne(int id);
//    List<User> getAll();
}
