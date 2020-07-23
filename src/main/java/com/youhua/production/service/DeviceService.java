package com.youhua.production.service;

import com.github.pagehelper.PageInfo;
import com.youhua.production.bean.Devices;

public interface DeviceService {
    PageInfo<Devices> getDeviceList(int pageNo, int pageSize);
}
