package com.youhua.production.service.ipml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youhua.production.bean.Devices;
import com.youhua.production.bean.SystemUser;
import com.youhua.production.dao.DeviceDao;
import com.youhua.production.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取设备的数据
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public PageInfo<Devices> getDeviceList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Devices> list = deviceDao.findAll();
        PageInfo<Devices> page = new PageInfo<Devices>(list);
        return page;
    }
}
