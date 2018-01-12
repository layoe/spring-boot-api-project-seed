package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/18.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    public User getOne(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int getSize(){
        List<User> list =userMapper.getAll();
        return list.size();
    }

    public List<User> getJoinData(){
        return userMapper.queryForList();
    }

}
