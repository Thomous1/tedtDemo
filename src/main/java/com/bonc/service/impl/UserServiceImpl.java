
package com.bonc.service.impl;
import com.bonc.dao.UserDao;
import com.bonc.domain.TalkingData;
import com.bonc.domain.User;
import com.bonc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 王小浪 on 2018/6/4.
 */



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String nickname) {
        return userDao.getUserByUserName(nickname);
    }

    @Override
    public void updateById(User user) {
      userDao.updateById( user);
    }

    @Override
    public List<TalkingData> findAllTalking() {
        return userDao.findAllTalking();
    }

    @Override
    public List<TalkingData> findAllTalking2(String type) {
        return userDao.findAllTalking2(type);
    }

    @Override
    public List<TalkingData> findAllTalking3(String pro) {
        return userDao.findAllTalking3(pro);
    }
}


