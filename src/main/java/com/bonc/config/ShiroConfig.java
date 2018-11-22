package com.bonc.config;

import com.bonc.utils.MyShiroRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 王小浪 on 2018/8/21.
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //单独一个ShiroFilterFactoryBean 配置会报错，必须配置SecurityManager。
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/findAll");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //配置拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/", "anon");
        //不需要拦截的静态文件请求
        filterChainDefinitionMap.put("/bootstrap/**", "anon");
        filterChainDefinitionMap.put("/bootstrap-table/**", "anon");
        filterChainDefinitionMap.put("/images/**/**", "anon");
        filterChainDefinitionMap.put("/jquery/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/layer/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        filterChainDefinitionMap.put("/getData", "anon");


        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }
    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager(MyShiroRealm myShiroRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        return  securityManager;
    }
    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:config/ehcache.xml");
        return em;
    }

    @Bean(name = "myShiroRealm")
    public MyShiroRealm myShiroRealm(EhCacheManager cacheManager) {
        MyShiroRealm realm = new MyShiroRealm();
        realm.setCacheManager(cacheManager);
        return realm;
    }
}
