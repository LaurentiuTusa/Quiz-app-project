package com.model;

import com.exceptions.EmptyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private Integer id;
    private String testName;
    private Integer userID;

    public static void create(String name, Integer userID) throws SQLException {

        String sqlCreateUser = "INSERT INTO oop_project.test (test_name, user_id) VALUES (?, ?)";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,userID);
            preparedStatement.executeUpdate();
   
        }
    }

    public void update(String name) throws SQLException{

        String sqlCreateUser = "UPDATE oop_project.test t SET t.test_name = ? WHERE t.id = ?";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,this.id);
            preparedStatement.executeUpdate();
   
        }
        this.testName =name;
    }

    public static void delete(Integer id) throws SQLException{

        String sqlCreateUser = "DELETE FROM oop_project.test  WHERE id = ?";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setInt(1,id);;
            preparedStatement.executeUpdate();
   
        }
    }

    public void set(String testName) throws SQLException, EmptyException {
        String sqlSelectUser = "SELECT * FROM test WHERE test.test_name like '" + testName + "'";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement ps = conn.prepareStatement(sqlSelectUser);
             ResultSet rs = ps.executeQuery()) {
            int found=0;
            while (rs.next()) {
                found=1;
                this.id = rs.getInt("Id");
                this.testName = rs.getString("test_name");
                this.userID=rs.getInt("user_id");


                // do something with the extracted data...
            }
            if(found==0)
                throw new EmptyException();
        }
    }

    public Test() {
    }

    public static List<Test> getList(){
        List<Test> testList = new ArrayList<Test>();
        String sqlSelectUser = "SELECT * FROM test";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement ps = conn.prepareStatement(sqlSelectUser);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Test addedTest= new Test();
                addedTest.setId(rs.getInt("Id"));
                addedTest.setTestName(rs.getString("test_name"));
                addedTest.setUserID(rs.getInt("user_id"));
                testList.add(addedTest);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return testList;
    }

    public static List<Test> getListFromUser(Integer userID){
        List<Test> testList = new ArrayList<Test>();
        String sqlSelectUser = "SELECT * FROM test where user_id =" + userID;
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement ps = conn.prepareStatement(sqlSelectUser);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Test addedTest= new Test();
                addedTest.setId(rs.getInt("Id"));
                addedTest.setTestName(rs.getString("test_name"));
                addedTest.setUserID(rs.getInt("user_id"));
                testList.add(addedTest);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return testList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
