package com.youhua.production.service.ipml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youhua.production.bean.SystemUser;
import com.youhua.production.dao.SystemUserDao;
import com.youhua.production.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SystemUserServiceIpml implements SystemUserService {

    @Autowired
    private SystemUserDao systemUserDao;


    @Override
    public SystemUser get(int id) {
        return systemUserDao.get(id);
    }

    @Override
    public List<SystemUser> list(Map<String, Object> map) {
        return systemUserDao.list(map);
    }

    @Override
    public List<SystemUser> findAll() {
        return systemUserDao.findAll();
    }

    @Override
    public PageInfo<SystemUser> getPageList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<SystemUser> list = systemUserDao.findAll();
        //用PageInfo对结果进行包装
        PageInfo<SystemUser> page = new PageInfo<SystemUser>(list);
        return page;
    }

    @Override
    public int count(Map<String, Object> map) {
        return systemUserDao.count(map);
    }

    @Override
    public int save(SystemUser operation) {
        return systemUserDao.save(operation);
    }

    @Override
    public int update(SystemUser operation) {
        return systemUserDao.update(operation);
    }

    @Override
    public int remove(int id) {
        return systemUserDao.remove(id);
    }

    @Override
    public int batchRemove(int[] ids) {
        return systemUserDao.batchRemove(ids);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        return false;
    }
}
