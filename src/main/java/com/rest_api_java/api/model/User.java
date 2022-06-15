package com.rest_api_java.api.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_data")
public class User implements Serializable {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "id_locality")
    private int idLocality;

    @Column(name = "id_county")
    private int idCounty;

    @Column(name = "weight")
    private int weight;

    @Column(name = "height")
    private int height;

    @Column(name = "role")
    private String role;

    //----------------------------------------------------------------------
    //Constructor
    //----------------------------------------------------------------------

    public User(Integer id, String name, String email, String password, int idLocality, int idCounty, int weight, int height, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.idLocality = idLocality;
        this.idCounty = idCounty;
        this.weight = weight;
        this.height = height;
        this.role = role;
    }

    //----------------------------------------------------------------------

    public User(String name, String email, String password, int idLocality, int idCounty, int weight, int height, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.idLocality = idLocality;
        this.idCounty = idCounty;
        this.weight = weight;
        this.height = height;
        this.role = role;
    }

    //----------------------------------------------------------------------

    public User() {
    }

    //----------------------------------------------------------------------
    //Getters and Setters
    //----------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    //----------------------------------------------------------------------

    public void setId(Integer id) {
        this.id = id;
    }

    //----------------------------------------------------------------------

    public String getName() {
        return name;
    }

    //----------------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    //----------------------------------------------------------------------

    public String getEmail() {
        return email;
    }

    //----------------------------------------------------------------------

    public void setEmail(String email) {
        this.email = email;
    }

    //----------------------------------------------------------------------

    public int getIdLocality() {
        return idLocality;
    }
    //----------------------------------------------------------------------

    public void setIdLocality(int idLocality) {
        this.idLocality = idLocality;
    }

    //----------------------------------------------------------------------

    public int getIdCounty() {
        return idCounty;
    }

    //----------------------------------------------------------------------

    public void setIdCounty(int idCounty) {
        this.idCounty = idCounty;
    }

    //----------------------------------------------------------------------

    public int getWeight() {
        return weight;
    }

    //----------------------------------------------------------------------

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //----------------------------------------------------------------------

    public int getHeight() {
        return height;
    }

    //----------------------------------------------------------------------

    public void setHeight(int height) {
        this.height = height;
    }

    //----------------------------------------------------------------------

    public String getPassword() {
        return password;
    }

    //----------------------------------------------------------------------

    public void setPassword(String password) {
        this.password = password;
    }

    //----------------------------------------------------------------------

    public String getRole() {
        return role;
    }

    //----------------------------------------------------------------------

    public void setRole(String role) {
        this.role = role;
    }

    //----------------------------------------------------------------------

    public User updateData(User user) {

        this.id = user.id;
        this.name = user.getName();
        this.email = user.getEmail();
        this.idCounty = user.getIdCounty();
        this.idLocality = user.getIdLocality();
        this.height = user.getHeight();
        this.weight = user.getWeight();
        this.role = user.getRole();
        return this;
    }

    //----------------------------------------------------------------------

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", idLocality=" + idLocality +
                ", idCounty=" + idCounty +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

}
