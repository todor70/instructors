package com.zeljko.instructors.entities;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="authorities_ID")
    private int authoritiesID;

    @Column(name="authority")
    private String authority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users users;


    public Authorities() {
    }

    public Authorities(String authority) {
        this.authority = authority;
    }

    public int getAuthoritiesID() {
        return authoritiesID;
    }

    public void setAuthoritiesID(int authoritiesID) {
        this.authoritiesID = authoritiesID;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "authoritiesID=" + authoritiesID +
                ", authority='" + authority + '\'' +
                '}';
    }
}


