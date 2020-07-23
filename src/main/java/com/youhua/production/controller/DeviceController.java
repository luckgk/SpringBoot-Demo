package com.youhua.production.controller;

import com.github.pagehelper.PageInfo;
import com.youhua.production.bean.Devices;
import com.youhua.production.bean.SystemUser;
import com.youhua.production.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @RequestMapping("/device_pagelist")
    public String toApplicationList(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="50")int pageSize, Model model){
        PageInfo<Devices> page = deviceService.getDeviceList(pageNo,pageSize);
        System.out.println("get system user:"+page.getList().size());
        model.addAttribute("pageInfo", page);
        return "device/pagelist";
    }

}
