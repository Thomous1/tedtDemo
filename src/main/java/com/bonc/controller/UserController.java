package com.bonc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
import java.util.LinkedHashMap;
import org.springframework.ui.Model;

/**
 * Created by 王小浪 on 2018/8/21.
 */
@Controller
public class UserController {
    @RequestMapping("/login")
    public  String login(){
        return "login";
    }

    @RequestMapping(value="ajaxLogin",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitLogin(String username, String password,Model model) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");

        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }
        return resultMap;
    }

}
