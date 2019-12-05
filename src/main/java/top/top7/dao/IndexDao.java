package top.top7.dao;

import org.apache.ibatis.annotations.Mapper;
import top.top7.pojo.*;

import java.util.List;

/**
 * Created by Administrator on 2019/12/4.
 */
@Mapper
public interface IndexDao {
    public List<Home1> findIndexClass();
    public List<Class_sort1> findIndexSort();
    List<Classes> searchMess(String name);
    List<LunBo> indexLunbo();
    List<Classes2> selectClasses2();
}
