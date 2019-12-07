package top.top7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.top7.pojo.User;

/**
 * Created by 25849 on 2019/11/27.
 */
public interface UserRespository extends JpaRepository<User,Integer> {
}
