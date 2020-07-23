package com.youhua.production.dao;

import com.youhua.production.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static Map<Integer, User> employees = null;
    private static Integer initId = 1001;

    static{
        employees = new HashMap<Integer, User>();

        employees.put(1001, new User(1001, "E-AA", "aa@163.com", 1));
        employees.put(1002, new User(1002, "E-BB", "bb@163.com", 1));
        employees.put(1003, new User(1003, "E-CC", "cc@163.com", 0));
        employees.put(1004, new User(1004, "E-DD", "dd@163.com", 0));
        employees.put(1005, new User(1005, "E-EE", "ee@163.com", 1));
    }


    public void save(User employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    //查询所有员工
    public Collection<User> getAll(){
        return employees.values();
    }

    public User get(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
