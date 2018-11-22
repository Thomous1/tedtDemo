
package com.bonc.service;


import com.bonc.domain.TalkingData;
import com.bonc.domain.User;

import java.util.List;

/**
 * Created by 王小浪 on 2018/6/4.
 */

public interface UserService {
    User getUserByUserName(String  nickname);
   void updateById(User user);
    List<TalkingData> findAllTalking();
    List<TalkingData> findAllTalking2(String type);
    List<TalkingData> findAllTalking3(String pro);
}

