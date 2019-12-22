package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonMySQL {

    @Id
    private String id;
    private String name;
    private String secondName;
    private String email;
    private String gender;
    private String ip_address;

    public PersonMySQL() {
    }

    public PersonMySQL(String name, String secondName, String email, String gender, String ip_address) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    @Override
    public String toString() {
        return "PersonMySQL{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", ip_address='" + ip_address + '\'' +
                '}';
    }
}
