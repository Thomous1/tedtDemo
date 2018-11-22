package com.bonc.utils;


import com.bonc.dao.UserDao;
import com.bonc.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.bonc.domain.User;

import java.util.Date;

/**
 * Created by 王小浪 on 2018/5/29.
 */
public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
   /*     String username = (String) super.getAvailablePrincipal(principalCollection);
         if (user.getNickname() != null) {
             SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
             Map<String,Object> map=user.getPerList();
             //用户的角色信息
             /*List<String> roles=(List<String>) map.get("roles");
             for (String role : roles) {
                    info.addRole(role);
            }
                     Set<String> roleSet=new HashSet<String>();
                     roleSet.add("100002");
                     info.setRoles(roleSet);
                     //用户的权限信息
                     /*List<String> permissions=(List<String>) map.get("permissions");
             for (String permission : permissions) {
                 info.addStringPermission(permission);
             }
                     Set<String> permissionSet =new HashSet<String>();
                     permissionSet.add("权限添加");
                     info.setStringPermissions(permissionSet);
                     return info;
                 }*/
        return  null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = userService.getUserByUserName(username);
        if (null == user) {
            throw new AccountException("帐号或密码不正确！");
        }else if(user.getStatus()==0){
            throw new DisabledAccountException("帐号已经禁止登录！");
        }else{
            user.setLast_login_time(new Date());
            userService.updateById(user);
        }


        return new SimpleAuthenticationInfo(user,user.getPswd(),getName());
    }
}
