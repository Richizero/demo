package com.example.demo.app.users.models;

import javax.persistence.*;
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_name", columnDefinition = "varchar(40)", nullable = false, unique = true)
    private String userName;
    @Column(name = "email", columnDefinition = "varchar(40)", nullable = false, unique = true)
    private String eMail;
    @Column(name = "phone", columnDefinition = "varchar(20)")
    private String phone;

    public User()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
