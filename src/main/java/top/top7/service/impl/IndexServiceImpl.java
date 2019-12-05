package top.top7.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.top7.dao.IndexDao;
import top.top7.pojo.*;
import top.top7.service.IndexService;

import java.util.List;

/**
 * Created by Administrator on 2019/12/4.
 */
@Service
public class IndexServiceImpl implements IndexService{
    @Autowired
    private IndexDao indexDao;

    @Override
    public List<Home1> findIndexClass() {
        return indexDao.findIndexClass();
    }

    @Override
    public List<Class_sort1> findIndexSort() {
        return indexDao.findIndexSort();
    }

    @Override
    public List<LunBo> indexLunbo() {
        return indexDao.indexLunbo();
    }

    @Override
    public List<Classes> searchMess(String name) {
        return indexDao.searchMess(name);
    }

    @Override
    public List<Classes2> selectClasses2() {
        return indexDao.selectClasses2();
    }
}
