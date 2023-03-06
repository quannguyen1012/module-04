package com.cg.entity;

import com.cg.entity.Role;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "users_uk",
                columnNames = {"email", "phone"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
//    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Role> roles = new HashSet<Role>();

    @NotBlank
    @Column(name = "fullname", length = 200, nullable = false)
    private String fullname;

    @NotBlank
    @Column(name = "username", length = 200, nullable = false)
    private String username;

    @NotBlank
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @NotBlank
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank
    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @NotBlank
    @Column(name = "phone", length = 12, nullable = false)
    private String phone;

    @NotBlank
    @Column(name = "avatar",
            columnDefinition = "text", nullable = true)
    private String avatar;

    @Column(name = "activated", nullable = true)
    private Boolean activated;

    @Column(name = "remember_token", length = 255, nullable = true)
    private String rememberToken;

    public User() {
    }

    public User(Integer id, @NotBlank String fullname, @NotBlank String username, @NotBlank String password,
                @NotBlank String email, @NotBlank String address, @NotBlank String phone, @NotBlank String avatar,
                @NotBlank Boolean activated, @NotBlank String rememberToken) {
        super();
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.activated = activated;
        this.rememberToken = rememberToken;
    }

    public User(@NotBlank String fullname, @NotBlank String username, @NotBlank String password,
                @NotBlank String email, @NotBlank String address, @NotBlank String phone, @NotBlank String avatar,
                @NotBlank Boolean activated, @NotBlank String rememberToken) {
        super();
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.activated = activated;
        this.rememberToken = rememberToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

}
