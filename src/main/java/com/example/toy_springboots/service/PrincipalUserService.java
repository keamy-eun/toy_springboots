package com.example.toy_springboots.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.toy_springboots.configurations.PrincipalUser;
import com.example.toy_springboots.dao.SharedDao;
import org.springframework.stereotype.Service;

@Service
public class PrincipalUserService implements UserDetailsService {

    @Autowired
    SharedDao sharedDao;

    @Override
    // url /login 일때 spring scrutiry가 호출
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // query select with ID  - pw 말고 id만 unique하다고 생각하고 체크함
        String sqlMapId = "Memberwithauthority.selectByUID";  
        Object usernameObj = username;
        Map<String, String> resultMap = (Map<String, String>) sharedDao.getOne(sqlMapId, usernameObj);

        // session 등록
        PrincipalUser principalUser = new PrincipalUser(resultMap);

        return principalUser;
    }
    
}

