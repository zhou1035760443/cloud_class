package top.top7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.top7.pojo.*;
import top.top7.service.IndexService;

import java.util.List;

/**
 * Created by Administrator on 2019/12/4.
 */
@RestController()
@RequestMapping("/index")
public class indexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/indexfindAll")
    public List<Home1> indexfindAll(){
        return indexService.findIndexClass();
    }
    @RequestMapping("/indexfindSort")
    public List<Class_sort1> indexfindSort(){
        return indexService.findIndexSort();
    }
        @RequestMapping("/searchMess/{searchname}")
    public List<Classes> searchMess(@PathVariable("searchname")String searchname){
            String name="%"+searchname+"%";
        System.out.println(indexService.searchMess(name));
        return indexService.searchMess(name);
    }
    @RequestMapping("/selectLunbo")
    public List<LunBo> selectLunbo(){
        return indexService.indexLunbo();
    }
    @RequestMapping("/selectClasses2")
    public List<Classes2> selectClasses2(){
        return indexService.selectClasses2();
    }
}
