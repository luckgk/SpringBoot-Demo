package com.youhua.production.dao;

import com.youhua.production.bean.Mac;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mac
 * private String mac;
 *
 * private String operator;
 *
 * private String province;
 */

@Mapper
public interface MacMapper {

    @Select("select * from mac where id=#{id}")
    public Mac getMac(Integer id);

    @Select("select * from mac")
    public List<Mac> getMacs();

    @Delete("delete from mac where id=#{id}")
    public int deleteMacById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id") //主键
    @Insert("insert into mac(mac,operator,province) values(#{mac},#{operator},#{province})")
    public int insertMac(Mac mac);

    @Update("update mac set mac=#{mac},operator=#{operator},province=#{province} where id=#{id}")
    public int updateMac(Mac mac);

}
