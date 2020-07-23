package com.youhua.production.controller;

import com.github.pagehelper.PageInfo;
import com.youhua.production.bean.Mac;
import com.youhua.production.bean.SystemUser;
import com.youhua.production.bean.User;
import com.youhua.production.common.PageUtils;
import com.youhua.production.common.Query;
import com.youhua.production.dao.MacDao;
import com.youhua.production.dao.UserDao;
import com.youhua.production.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    MacDao macDao;

    @Autowired
    SystemUserService systemUserService;


    //查询所有用户返回列表页面
    @GetMapping("/users")
    public String  user_list(Model model){
        Collection<User> employees = userDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

/*    //查询所有Mac返回列表页面
    @GetMapping("/macs")
    public String  mac_list(Model model){
        Collection<Mac> macs = macDao.getAll();
        //放在请求域中
        model.addAttribute("macs",macs);
        return "mac/list";
    }*/


    //查询所有用户返回列表页面
    @GetMapping("/system_users")
    //查询所有Mac返回列表页面
    public String  mac_list(@RequestParam Map<String, Object> params,Model model) {

        // 查询列表数据
//        Query query = new Query(params);
        //List<SystemUser> optionList = systemUserService.list(query);
        List<SystemUser> optionList = systemUserService.findAll();
        int count = systemUserService.count(params);
        System.out.println("get system user:"+optionList.size());
        for(SystemUser systemUser : optionList){
            System.out.println("name : "+systemUser.getLastName());
        }
//        int total = systemUserService.count(query);
//        PageUtils pageUtils = new PageUtils(optionList, total);
        //放在请求域中
        model.addAttribute("systemuers",optionList);
        return "systemuser/list";
    }

    @RequestMapping("/system_user_pagelist")
    public String toApplicationList(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="5")int pageSize, Model model){
        PageInfo<SystemUser> page = systemUserService.getPageList(pageNo,pageSize);
        System.out.println("get system user:"+page.getList().size());
        for(SystemUser systemUser : page.getList()){
            System.out.println("name : "+systemUser.getLastName());
        }
        model.addAttribute("pageInfo", page);
        return "systemuser/pagelist";
    }




    //来到员工添加页面
    @GetMapping("/add_systemuser")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        return "systemuser/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/systemuser")
    public String addEmp(SystemUser mac) {
        //来到员工列表页面
        systemUserService.save(mac);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/system_user_pagelist";
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/systemuser/{id}")
    public String toEditPage(@PathVariable("id") int id, Model model) {
        SystemUser mac = systemUserService.get(id);
        model.addAttribute("systemuser",mac);
        return "systemuser/add";
    }


    //Mac修改；需要提交员工id；
    @PutMapping("/systemuser")
    public String updateMac(SystemUser mac) {
        systemUserService.update(mac);
        return "redirect:/system_user_pagelist";
    }

    @DeleteMapping("/del_systemuser/{id}")
    public String deleteMacs(@PathVariable("id") int id) {
        systemUserService.remove(id);
        System.out.println("delete mac id:"+id);
        return "redirect:/system_user_pagelist";
    }




}
