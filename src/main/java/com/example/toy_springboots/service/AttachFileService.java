package com.example.toy_springboots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toy_springboots.dao.AttachFileDao;

@Service
public class AttachFileService {

    @Autowired
    AttachFileDao attachFileDao;
    
    public Object insertMulti(Object dataMap){
        String sqlId = "AttachFile.insertMulti";
        Object result = attachFileDao.insert(sqlId, dataMap);
        return result;
    }
}
