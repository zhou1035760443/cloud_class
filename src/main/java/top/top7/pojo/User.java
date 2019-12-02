package top.top7.pojo;

import lombok.Data;


/**
 * Created by Administrator on 2019/12/2.
 */

@Data
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String userTel;
    private Integer status;
    private String userEmail;
}
