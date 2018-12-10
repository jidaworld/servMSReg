package Businesslayer.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class UserEntity {


    @Column(unique = true, nullable = false)
    private String UserName;

    @Column(nullable = false)
    private String Password;

    @Id
    @Column(unique = true, nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String LastName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

}