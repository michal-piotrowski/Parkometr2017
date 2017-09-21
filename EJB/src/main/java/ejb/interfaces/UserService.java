package ejb.interfaces;

import javax.ejb.Local;
import javax.ejb.SessionContext;

/**
 * Created by Michał Piotrowski on 2017-09-17.
 */
@Local
public interface UserService {

    /**
     * Create session for user, that will span the whole application.
     * Other sessions loggin with the same credentials should redirect to the already opened session or display, that the user has already logged in from elsewhere.
     */
    String logUserIn();

    void logUserOut();

    public SessionContext getSessionContext();
}
