package top.top7.dao;

import org.apache.ibatis.annotations.Mapper;
import top.top7.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2019/12/2.
 */
@Mapper
public interface UserDao {
    public List<User> findAll();
}
