package pl.edu.agh.backMainApp.database;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;

/**
 * Created by Michał Piotrowski on 2017-09-17.
 */
@Entity
@Table(name = "users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") private int id;

    @Column(name="login") private String login;
    @Column(name="password") private String password;
    @Column(name="role") private String role;
    @Column(name="area") private String area;

    public UserDAO(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserDAO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
