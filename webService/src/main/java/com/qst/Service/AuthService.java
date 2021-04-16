package com.qst.Service;

import com.qst.Dao.AuthMapper;
import com.qst.Until.ResultEntity;
import com.qst.bean.Auth;
import com.qst.bean.AuthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthMapper authMapper;

    public List<Auth> getPass(String name){
        AuthExample example = new AuthExample();
        AuthExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(name);

        List<Auth> list = authMapper.selectByExample(example);

        return list;
    }




    public ResultEntity<Auth> getCheckLogin(String name,String pass){
        return ResultEntity.successWithoutData();
    }

}
