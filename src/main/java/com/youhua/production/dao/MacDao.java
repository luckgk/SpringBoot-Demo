package com.youhua.production.dao;

import com.youhua.production.bean.Mac;
import com.youhua.production.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MacDao {

    private static Map<Integer, Mac> macs = null;
    private static Integer initId = 1001;

    static{
        macs = new HashMap<Integer, Mac>();

        macs.put(1001, new Mac(1001, "34:e7:dd:dd:aa:11", "中国移动", "GD"));
        macs.put(1002, new Mac(1002, "34:e7:dd:dd:aa:10", "中国移动", "GD"));
        macs.put(1003, new Mac(1003, "34:e7:dd:dd:aa:12", "中国移动", "GD"));
        macs.put(1004, new Mac(1004, "34:e7:dd:dd:aa:13", "中国移动", "GD"));
        macs.put(1005, new Mac(1005, "34:e7:dd:dd:aa:14", "中国移动", "GD"));
    }


    public void save(Mac mac){
        if(mac.getId() == null){
            mac.setId(initId++);
        }
        macs.put(mac.getId(), mac);
    }

    //查询所有员工
    public Collection<Mac> getAll(){
        return macs.values();
    }

    public Mac get(Integer id){
        return macs.get(id);
    }

    public void delete(Integer id){
        macs.remove(id);
    }

}
