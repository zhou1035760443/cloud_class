package top.top7.pojo;

import lombok.Data;

import javax.persistence.*;


/**
 * Created by Administrator on 2019/12/2.
 */

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "user_tel")
    private String userTel;

    private Integer status;

    @Column(name = "user_email")
    private String userEmail;

    private String salt;
}