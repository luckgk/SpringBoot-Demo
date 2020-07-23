package com.youhua.production.controller;

import com.youhua.production.bean.Mac;
import com.youhua.production.service.MacService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class MacController {

    @Autowired
    MacService macService;


    //查询所有Mac返回列表页面
    @GetMapping("/getallmacs")
    public String  mac_list(Model model) {
        final List<Mac> macs = macService.getMacs();
        //放在请求域中
        model.addAttribute("macs",macs);
        return "mac/list";
    }

    //来到员工添加页面
    @GetMapping("/add_mac")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        return "mac/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/mac")
    public String addEmp(Mac mac) {
        //来到员工列表页面

        System.out.println("保存的员工信息："+mac);
        //保存员工
        macService.insertMac(mac);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/getallmacs";
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/mac/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Mac mac = macService.getMac(id);
        model.addAttribute("mac",mac);
        return "mac/add";
    }


    //Mac修改；需要提交员工id；
    @PutMapping("/mac")
    public String updateMac(Mac mac) {
        System.out.println("修改的mac数据："+mac);
        macService.updateMac(mac);
        return "redirect:/getallmacs";
    }

    @DeleteMapping("/mac/{id}")
    public String deleteMac(@PathVariable("id") Integer id) {
        macService.deleteMacById(id);
        System.out.println("delete mac id:"+id);
        return "redirect:/getallmacs";
    }


}
