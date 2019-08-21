package com.fyh.xuanke.service;

import com.fyh.xuanke.VO.UserVO;
import com.fyh.xuanke.model.User;

public interface UserService {

    public User regist(User user);

//    public boolean findUserByUsernameAndPassword(String username,String papubssword)
    public UserVO getUser(String username);

    public void saveUserToRedisByToken(UserVO dbuser, String token);

    public Object getUserFromRedisByToken(String token);
}
