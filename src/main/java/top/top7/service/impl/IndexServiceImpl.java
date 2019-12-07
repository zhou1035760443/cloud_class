package top.top7.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.top7.dao.IndexDao;
import top.top7.pojo.*;
import top.top7.repository.ClassesRepository;
import top.top7.service.IndexService;
import top.top7.utils.Msg;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019/12/4.
 */
@Service
public class IndexServiceImpl implements IndexService{
    @Autowired
    private IndexDao indexDao;

    @Autowired
    private ClassesRepository classesRepository;

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

    @Override
    public Msg findAllClasses(Integer size, Integer page) {
        if (page<0){
            page=0;
        }else {
            page= page-1;
        }
        Pageable pages = PageRequest.of(page,size);
        Page<Classes> all = classesRepository.findAll(pages);

        List<Classes> content = all.getContent();

        Msg msg=new Msg();
        msg.setList(content);
        msg.setPage(all.getTotalPages());
        msg.setTotal(all.getTotalElements());
        return msg;
    }

    @Override
    public void deleteClasses(Integer id) {
        classesRepository.deleteById(id);
    }

    @Override
    public Classes getClassById(Integer id) {
        Optional<Classes> byId = classesRepository.findById(id);
        Classes classes=null;
        if(byId.isPresent()){
            classes = byId.get();
        }
        return classes;
    }
}
