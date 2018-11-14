package com.zeljko.instructors.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_ID")
    private int usersID;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    @Column(name = "username")
    private String username;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "users", cascade = { CascadeType.ALL})
    private List<Authorities> authorities;

    public Users() {
    }

    public int getUsersID() {
        return usersID;
    }

    public void setUsersID(int usersID) {
        this.usersID = usersID;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersID=" + usersID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
