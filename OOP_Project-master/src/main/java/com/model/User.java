package com.model;

import com.exceptions.EmptyException;

import java.sql.*;

public class User {
    private Integer id;
    private String username;
    private String name;
    private String encryptedPassword;


    public static User create(String username, String name, String encryptedPassword) throws SQLException{

        String sqlCreateUser = "INSERT INTO oop_project.user (Name, Username, Password) VALUES (?, ?, ?)";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,encryptedPassword);
            preparedStatement.executeUpdate();
           
        }
        try {
            User returnUser= new User();
            returnUser.set(username);
            return returnUser;
        } catch (EmptyException ignored) {
        }
        return new User();
    }

    public static void delete(Integer id) throws SQLException{

        String sqlCreateUser = "DELETE FROM oop_project.user WHERE id = ?";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setInt(1,id);;
            preparedStatement.executeUpdate();
           
        }
    }


    public void update(String username, String name, String encryptedPassword) throws SQLException, EmptyException {

        String sqlCreateUser = "UPDATE oop_project.user t SET t.Name = ?, t.Username = ?, t.Password = ? WHERE t.id = ?";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,encryptedPassword);
            preparedStatement.setInt(4,this.id);
            preparedStatement.executeUpdate();
           
        }
        this.username=username;
        this.name=name;
        this.encryptedPassword=encryptedPassword;
    }

    public void set(String findUsername) throws SQLException, EmptyException {
        String sqlSelectUser = "SELECT * FROM user WHERE Username like '" + findUsername + "'";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement ps = conn.prepareStatement(sqlSelectUser);
             ResultSet rs = ps.executeQuery()) {
            int found=0;
            while (rs.next()) {
                found=1;
                this.id = rs.getInt("Id");
                this.name = rs.getString("Name");
                this.username = rs.getString("Username");
                this.encryptedPassword=rs.getString("Password");


               
                // do something with the extracted data...
            }
            if(found==0)
                throw new EmptyException();
        }
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
