package com.fyh.xuanke.service.impl;

import com.fyh.xuanke.VO.UserVO;
import com.fyh.xuanke.model.User;
import com.fyh.xuanke.redis.UserRedis;
import com.fyh.xuanke.respository.UserRpository;
import com.fyh.xuanke.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRpository userRpository;

    @Autowired
    public UserRedis userRedis;

    @Override
    public User regist(User user) {
        return userRpository.saveAndFlush(user);
    }

    @Override
    public UserVO getUser(String username) {
        UserVO userVO = new UserVO();
        User user = userRedis.get("username");
        if (user==null) {
           user = userRpository.findByUsername(username);
           if(user!=null){
               userRedis.put(user.getUsername(),user,-1);
           }else {
               return null;
           }
        }
        BeanUtils.copyProperties(user,userVO);

        return userVO;
    }

    @Override
    public void saveUserToRedisByToken(UserVO dbuser, String token) {
        User user = new User();
        BeanUtils.copyProperties(dbuser,user);
        userRedis.put(token,user,3600);
    }

    @Override
    public Object getUserFromRedisByToken(String token) {
        return userRedis.get(token);
    }
//
//    @Override
//    public boolean findUserByUsernameAndPassword(String username, String password) {
//        User user = userRpository.findByUsernameAndPassword(username,password);
//
//    }
}
