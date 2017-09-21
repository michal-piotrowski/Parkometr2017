package pl.edu.agh.backMainApp.model;

import ejb.interfaces.UserService;
import pl.edu.agh.backMainApp.database.UserDAO;

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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.*;
import java.security.Principal;
import java.util.List;

/**
 * Created by Michał Piotrowski on 2017-09-09.
 */
@Named
@ApplicationScoped
public class User {

    @Inject
    private UserService userService;

    private UserDAO userDAO = new UserDAO();

    @PersistenceContext
    private EntityManager em;

    FacesContext facesContext = FacesContext.getCurrentInstance();

    private String userRole;
    private String userName;
    private String ownedArea;

    public User() {
    }

    public void addMockUser() {
        addUser("mockUser", "this password will be hashed in the future", "W");
        System.out.println("Adding mock user to database");
    }

    @Transactional
    public void addUser(String login, String hashedPassword, String role) {
        try {
            UserTransaction userTransaction = userService.getSessionContext().getUserTransaction();
            userTransaction.begin();
//            em.getTransaction().begin();
            em.persist(new UserDAO(login, hashedPassword, role));
//            em.getTransaction().commit();
            userTransaction.commit();
        } catch (IllegalArgumentException | HeuristicRollbackException | RollbackException | HeuristicMixedException | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
        UserDAO ud = em.find(UserDAO.class, 1);
        System.out.println("Adding mock user to database");
    }

    public void logUserOut() {
//        System.out.println("Logging out: " + sessionContext.getCallerPrincipal().getName());
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        req.getSession().invalidate();
        userService.logUserOut();
    }

    public String getUserRole() {
        javax.persistence.Query q =  em.createQuery("SELECT role FROM UserDAO WHERE login = :login");
        q.setParameter("login", getUserName());
        userRole = (String) q.getSingleResult();
        return userRole;
    }

    public String getUserRoleFor(String userName) {
        javax.persistence.Query q =  em.createQuery("SELECT role FROM UserDAO WHERE login = :login");
        q.setParameter("login", userName);
        userRole = (String) q.getSingleResult();
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        Principal p = userService.getSessionContext().getCallerPrincipal();
        return p.getName();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOwnedArea() {
        javax.persistence.Query q =  em.createQuery("SELECT area FROM UserDAO WHERE login = :login");
        q.setParameter("login", getUserName());
        ownedArea = (String) q.getSingleResult();
        return ownedArea;
    }

    public List<String> getAllUserNames() {
        return em.createQuery("SELECT login FROM UserDAO").getResultList();
    }

    public void setOwnedArea(String ownedArea) {
        this.ownedArea = ownedArea;
    }


    public void removeUser(String userName) throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {
        UserTransaction userTransaction = userService.getSessionContext().getUserTransaction();
        try {
            userTransaction.begin();
        } catch (NotSupportedException | SystemException e) {
            e.printStackTrace();
        }
        javax.persistence.Query q =  em.createQuery("DELETE FROM UserDAO WHERE login = :login");
        q.setParameter("login", userName);
        q.executeUpdate();
        userTransaction.commit();

    }
}
