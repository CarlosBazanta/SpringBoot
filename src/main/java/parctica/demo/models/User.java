package parctica.demo.models; //importa las librerias

import javax.persistence.*;
import java.util.Collection;

//Se indica que es una entidad
@Entity
//Se indica el nombre de la tabla y que la fila email no puede repetirse
@Table (name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Le indico que el id sea autoincrementable y que no sea nulo
    @Column (unique = true, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column (name = "userName", unique = true)
    private String userName;

    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"
            )
    )
    private Collection<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public User(String name, String userName, String email, String password, Collection<Role> roles) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(long id, String name, String userName, String email, String password, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User() {
    }
}
