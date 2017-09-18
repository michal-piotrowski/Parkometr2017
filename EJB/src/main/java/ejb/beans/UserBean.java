package ejb.beans;

import ejb.interfaces.UserService;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.security.Principal;

/**
 * Created by Michał Piotrowski on 2017-09-17.
 */
@Stateful
@Startup
public class UserBean implements UserService {

    @Resource
    SessionContext sessionContext;

    private String userRole;
    private String userName;

    @Override
    public String logUserIn() {
        Principal userPrincipal = sessionContext.getCallerPrincipal();
        return userPrincipal.getName();
    }

    @Override
    public String logUserOut() {
        Principal userPrincipal = sessionContext.getCallerPrincipal();
        return userPrincipal.getName();
    }
}
