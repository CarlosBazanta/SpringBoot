package parctica.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)

    private Collection<RoleEntity> roleEntity;

    public Collection<RoleEntity> getRole() {
        return roleEntity;
    }

    public void setRole(Collection<RoleEntity> roleEntity) {
        this.roleEntity = roleEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity(){

    }

    public UserEntity(String name, String username, String email, String password,Collection<RoleEntity> roleEntity){
        this.email=email;
        this.username=username;
        this.name=name;
        this.password=password;
        this.roleEntity = roleEntity;
    }

    public UserEntity(String name, String username, String email, String password ,Long id,Collection<RoleEntity> roleEntity){
        this.email=email;
        this.username=username;
        this.name=name;
        this.id=id;
        this.password=password;
        this.roleEntity = roleEntity;
    }

}
