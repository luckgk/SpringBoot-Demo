package com.youhua.production.service;

import com.youhua.production.bean.Mac;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MacService {

    public Mac getMac(Integer id);

    public List<Mac> getMacs();

    public int deleteMacById(Integer id);

    public int insertMac(Mac mac);

    public int updateMac(Mac mac);
}
