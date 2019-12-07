package top.top7.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.top7.Response.UserResponse;
import top.top7.dao.UserDao;
import top.top7.pojo.User;

import top.top7.repository.UserRespository;
import top.top7.service.UserService;

import java.util.List;
import java.util.Optional;


/**
 * Created by Administrator on 2019/12/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRespository userRespository;


    @Override
    public String deleteById(User user) {
        try{
            userRespository.deleteById(user.getId());
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "fail";
    }


    @Override
    public User saveAndFlush(User user) {
        return userRespository.saveAndFlush(user);
    }

    @Override
    public User findById(Integer id) {
        Optional<User> byId = userRespository.findById(id);
        User user=null;
        if (byId.isPresent()){
            user=byId.get();
        }
        return user;
    }

    @Override
    public UserResponse findAll(Integer size, Integer page) {
        if (page<0){
            page=0;
        }else {
            page=page-1;
        }

        Pageable pages= PageRequest.of(page,size);
        Page<User> all = userRespository.findAll(pages);
        List<User> content = all.getContent();
        UserResponse ur=new UserResponse();
        ur.setList(content);
        ur.setTotal(all.getTotalElements());
        ur.setPage(all.getTotalPages());

        return ur;
    }




/*=========================================================================*/


    @Override
    public Integer register(User user) {
        return userDao.register(user);
    }

    @Override
    public User findUserByNameOrTel(String userTel) {
        return userDao.findUserByNameOrTel(userTel);
    }
}
