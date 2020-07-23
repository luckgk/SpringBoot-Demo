package com.youhua.production.service;

import com.github.pagehelper.PageInfo;
import com.youhua.production.bean.SystemUser;

import java.util.List;
import java.util.Map;

public interface SystemUserService {
    SystemUser get(int id);

    List<SystemUser> list(Map<String, Object> map);

    List<SystemUser> findAll();

    PageInfo<SystemUser> getPageList(int pageNo, int pageSize);

    int count(Map<String, Object> map);

    int save(SystemUser operation);

    int update(SystemUser operation);

    int remove(int id);

    int batchRemove(int[] ids);

    boolean exit(Map<String, Object> params);

}
