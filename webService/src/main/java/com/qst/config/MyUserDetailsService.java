package com.qst.config;

import com.qst.Dao.AuthMapper;
import com.qst.bean.Auth;
import com.qst.bean.AuthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthMapper authMapper;




    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        System.out.println("--------------------");
        System.out.println(name);
        AuthExample example = new AuthExample();
        AuthExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(name);

        List<Auth> list = authMapper.selectByExample(example);

        Auth auth = list.get(0);
        String pass = auth.getPassword();
        System.out.println("use:"+name+"pass:"+pass);

        // 2.给 Admin 设置角色权限信息
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new User(name,pass,authorities);
    }
}
