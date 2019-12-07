package top.top7.dao;

import org.apache.ibatis.annotations.Mapper;
import top.top7.pojo.Roler;

import java.util.List;

/**
 * Created by 25849 on 2019/12/6.
 */
@Mapper
public interface RolerDao {

    //	根据用户手机号查询其所拥有的权限
    public List<Roler> findRolerByTel(String userTel);
}
