package com.youhua.production.dao;

import com.youhua.production.bean.SystemUser;
import java.util.List;
import java.util.Map;

/**
 * 用户Dao层
 */
public interface SystemUserDao {

    SystemUser get(int id);

    List<SystemUser> list(Map<String,Object> map);

    List<SystemUser> findAll();

    List<SystemUser> listOperation(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(SystemUser operation);

    int update(SystemUser operation);

    int remove(int id);

    int batchRemove(int[] ids);
}