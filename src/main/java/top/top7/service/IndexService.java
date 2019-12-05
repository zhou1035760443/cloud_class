package top.top7.service;

import top.top7.pojo.*;

import java.util.List;

/**
 * Created by Administrator on 2019/12/4.
 */
public interface IndexService {
    public List<Home1> findIndexClass();
    public List<Class_sort1> findIndexSort();
    List<LunBo> indexLunbo();
    List<Classes> searchMess(String name);
    List<Classes2> selectClasses2();
}
