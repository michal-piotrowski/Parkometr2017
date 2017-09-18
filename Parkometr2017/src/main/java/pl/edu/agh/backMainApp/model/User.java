package pl.edu.agh.backMainApp.model;

import ejb.interfaces.UserService;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by Michał Piotrowski on 2017-09-09.
 */
@Named
@ApplicationScoped
public class User {

    @Inject
    private UserService userService;

//    private FacesContext facesContext;
//    @Resource
    private SessionContext sessionContext;

    private String userRole;
    private String userName;

    public User() {
//        try {
//            InitialContext ic = new InitialContext();
//            NamingEnumeration<NameClassPair> list = ic.list("");
//            while (list.hasMore()) {
//                System.out.println(list.next().getName());
//            }
//            sessionContext = (SessionContext) ic.lookup("java:comp/env/sessionContext");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        facesContext = FacesContext.getCurrentInstance();
//        userName= facesContext.getCurrentInstance().getExternalContext().getRemoteUser();

//        userRole = facesContext.getCurrentInstance().getExternalContext().getUserPrincipal().
//        System.out.println("userPrincipal.getName(): " + userPrincipal.getName());
//        userName = userPrincipal.getName();
    }
    public void addMockUser() {
        System.out.println("Adding mock user to database");
    }

    public void logUserOut() {
//        System.out.println("Logging out: " + sessionContext.getCallerPrincipal().getName());
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        userName = userService.logUserOut();
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

}
