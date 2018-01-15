package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by CodeGenerator on 2017/12/18.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate StringRedisTemplate;

    public User getOne(int id){
        String key = "User_size";
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            return operations.get(key);
        }else{
            User u = userMapper.selectByPrimaryKey(id);
            return u;
        }




    }

    public int getSize(){
        List<User> list =userMapper.getAll();
        int size = list.size();


        String key = "test_size";
        ValueOperations<String, String> operations2 = StringRedisTemplate.opsForValue();
        StringRedisTemplate.delete(key);
        ValueOperations<String, Integer> operations = redisTemplate.opsForValue();
        operations.set(key, 100, 10, TimeUnit.MINUTES);
        redisTemplate.delete("User_size");

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            return operations.get(key);
        }else{
            return size;
        }


    }

    public List<User> getJoinData(){
        return userMapper.queryForList();
    }

}
