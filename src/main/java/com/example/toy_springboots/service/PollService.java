package com.example.toy_springboots.service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toy_springboots.dao.PollDao;
import com.example.toy_springboots.utils.Paginations;

@Service
public class PollService {
    
    @Autowired
    PollDao pollDao;

    @Autowired
    AttachFileService attachFileService;

    public Object getList(Object dataMap){
        String statement = "Poll.selectFromUSERDATA";
        Object result = pollDao.getList(statement, dataMap);
        return result;
    }

    public Object getOne(Object dataMap){
        String statement = "Poll.selectByUSER_UID";
        Object result = pollDao.getOne(statement, dataMap);
        return result;
    }

    public Object insert(Object dataMap){
        String sqlId = "Poll.insertUSERDATA";
        Object result = pollDao.insert(sqlId, dataMap);
        return result;
    }

    public Object update(Object dataMap){
        String sqlId = "Poll.updateByUSER_UID";
        Object result = pollDao.update(sqlId, dataMap);
        return result;
    }
    public Object delete(Object dataMap){
        String sqlId = "Poll.deleteByUSER_UID";
        Object result = pollDao.delete(sqlId, dataMap);
        return result;
    }

    public Object fixedGetList(Object dataMap){
        String sqlId = "Poll.fixedSelectFromUSERDATA";
        Object result = pollDao.getList(sqlId, dataMap);
        return result;
    }

    public Object deleteAndList(Object dataMap){
        Object result = this.delete(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object insertAndList(Object dataMap){
        Object result = this.insert(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object insertWithFileAndGetList(Object dataMap){
        Object result = attachFileService.insertMulti(dataMap);
        result = this.insert(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object updateAndList(Object dataMap){
        Object result = this.update(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object getTotal(Object dataMap){
        String sqlMapId = "Poll.selectTotal";
        Object result = pollDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object listAndPagination(Object dataMap){
        Map<String, Object> result = new HashMap<String, Object>();
        int totalCount = (int) this.getTotal(dataMap);
        int currentPage = (int) ((Map<String, Object>) dataMap).get("currentPage");
        Paginations paginations = new Paginations(totalCount, currentPage);
        result.put("paginations", paginations);
        ((Map<String, Object>) dataMap).put("pageBegin", paginations.getPageBegin());
        result.put("resultList", this.getList(dataMap));
        return result;
    }

    public Object fixedListAndPagination(Object dataMap){
        Map<String, Object> result = new HashMap<String, Object>();
        int totalCount = (int) this.getTotal(dataMap);
        Paginations paginations = new Paginations(totalCount, 1);
        result.put("paginations", paginations);
        ((Map<String, Object>) dataMap).put("pageBegin", paginations.getPageBegin());
        result.put("resultList", this.fixedGetList(dataMap));

        return result;
    }

    public Object insertTestUsers(Object dataMap){
        String sqlId = "Poll.insertTestUsers";
        Object result = pollDao.insert(sqlId, dataMap);
        return result;
    }

    public Object insertTestUsersAndList(Object dataMap){
        Object result = this.insertTestUsers(dataMap);
        result = this.getList(dataMap);
        return result;
    }
}
