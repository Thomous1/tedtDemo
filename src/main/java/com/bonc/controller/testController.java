package com.bonc.controller;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;



/**
 * Created by 王小浪 on 2018/5/30.
 *
 */

@Controller
public class testController {

    @Scheduled(cron = "0 15 12 * * ?")
    public  void main() {
        System.out.println("ceshiyixia ");
    }


  /*  UserService userService;
    @RequestMapping("/add")
    public void  test(){
        User user = new User();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userService.addUser(user);
    }
*/

}
