package top.top7.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import top.top7.pojo.User;
import top.top7.service.UserService;

/**
 * Created by 25849 on 2019/12/5.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取到用户的登录名
        String username = (String) token.getPrincipal();
        System.out.println("token:" + token);
        //从数据库直接取
        User user1 = userService.findUserByNameOrTel(username);
        System.out.println(user1);
        if (user1 != null) {
//            //当前realm对象的name
//            String realmName = getName();
//            //盐值
//            ByteSource credentialsSalt = ByteSource.Util.bytes(username);

            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user1.getUserTel(),user1.getPassword(),getName());
            return authenticationInfo;
        }
        return null;
    }
}
