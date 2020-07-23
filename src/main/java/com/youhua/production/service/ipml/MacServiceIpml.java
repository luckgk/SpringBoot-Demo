package com.youhua.production.service.ipml;

import com.youhua.production.bean.Mac;
import com.youhua.production.dao.MacMapper;
import com.youhua.production.service.MacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MacServiceIpml implements MacService {

    @Autowired
    private MacMapper macMapper;

    @Override
    public Mac getMac(Integer id) {
        return macMapper.getMac(id);
    }

    @Override
    public List<Mac> getMacs() {
        return macMapper.getMacs();
    }

    @Override
    public int deleteMacById(Integer id) {
        return macMapper.deleteMacById(id);
    }

    @Override
    public int insertMac(Mac mac) {
        return macMapper.insertMac(mac);
    }

    @Override
    public int updateMac(Mac mac) {
        return macMapper.updateMac(mac);
    }
}
