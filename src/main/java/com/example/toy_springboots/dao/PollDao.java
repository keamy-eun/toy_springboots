package com.example.toy_springboots.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PollDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    public Object getList(String statement, Object dataMap) {
        Object resultSet = sqlSessionTemplate.selectList(statement, dataMap);
        return resultSet;
    }

    public Object getOne(String statement, Object dataMap) {
        Object resultSet = sqlSessionTemplate.selectOne(statement, dataMap);
        return resultSet;
    }

    public Object insert(String sqlId, Object dataMap) {
        Object result = sqlSessionTemplate.selectOne(sqlId, dataMap);
        return result;
    }

    public Object update(String sqlId, Object dataMap) {
        Object result = sqlSessionTemplate.selectOne(sqlId, dataMap);
        return result;
    }

    public Object delete(String sqlId, Object dataMap) {
        Object result = sqlSessionTemplate.selectOne(sqlId, dataMap);
        return result;
    }

}
