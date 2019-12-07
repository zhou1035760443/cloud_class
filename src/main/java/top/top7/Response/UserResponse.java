package top.top7.Response;

import lombok.Data;
import top.top7.pojo.User;

import java.util.List;

/**
 * Created by 25849 on 2019/12/5.
 */
@Data
public class UserResponse {
    private List<User> list;
    private Integer page;
    private Long total;
}
