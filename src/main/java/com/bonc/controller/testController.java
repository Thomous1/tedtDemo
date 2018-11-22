package com.bonc.controller;


import com.bonc.domain.TalkingData;
import com.bonc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


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
  @Autowired
  private UserService userService;

  @RequestMapping("/goSupport")
  public  String goSupport(Model model){
      PageHelper.startPage(1,9);
      List<TalkingData> list = userService.findAllTalking();
      PageInfo<TalkingData> pageInfo = new PageInfo<>(list);
      System.out.println(pageInfo);
      model.addAttribute("pageInfo",pageInfo);
      model.addAttribute("talkingData",list);
      return "talkdata";
  }
    @RequestMapping("/goSupport/{type}")
    public  String goSupport2(Model model, @PathVariable(value ="type") String type){
        PageHelper.startPage(1,9);
        List<TalkingData> list = userService.findAllTalking2(type);

        PageInfo<TalkingData> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("talkingData",list);
        return "talkdata";
    }
    @RequestMapping("/goSupport3/{pro}")
    public  String goSupport3(Model model, @PathVariable(value ="pro") String pro){
        PageHelper.startPage(1,9);
        List<TalkingData> list = userService.findAllTalking3(pro);

        PageInfo<TalkingData> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("talkingData",list);
        return "talkdata";
    }
}
