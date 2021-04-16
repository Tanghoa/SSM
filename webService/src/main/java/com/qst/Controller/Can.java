package com.qst.Controller;

import com.qst.Dao.AuthMapper;
import com.qst.bean.Auth;
import com.qst.bean.AuthExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Can {


    @RequestMapping("/dd")
    public void tse(){
        System.out.println("asd");
    }

    @Autowired
    private AuthMapper authMapper;

    @RequestMapping("/ds")
    public void tess(){
        AuthExample example = new AuthExample();
        AuthExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("zs");

        List<Auth> auths = authMapper.selectByExample(example);
        System.out.println(auths.get(0));

    }
    @Test
    public void vvv(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123123");
        System.out.println(encode);
        boolean b = encoder.matches("123", "$2a$10$CXnEX5uQJSA.RsvC1Ov.EeO0Cc1ZBANnK7MHdULLCY0LnFjR.heU6");
        System.out.println(b);
    }




//    @RequestMapping("/eee")
//    public void tests(){
//        String name = "zs";
//        AuthExample example = new AuthExample();
//        AuthExample.Criteria criteria = example.createCriteria();
//        criteria.andNameEqualTo(name);
//
//        Auth key = authMapper.selectByPrimaryKey(1);
//
////        Auth auth = auths.get(0);
//
//        System.out.println(key);
//    }

}
