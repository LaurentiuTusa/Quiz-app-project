package com.model;

import com.exceptions.EmptyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Question{
    private Integer id;
    private String  questionText;
    private String  variant1;
    private String  variant2;
    private String  variant3;
    private String  variant4;
    private Integer answer;
    private Integer testID;

    public static void create(String questionText, String variant1, String variant2, String variant3, String variant4, Integer answer, Integer testID) throws SQLException {

        String sqlCreateUser = "INSERT INTO oop_project.questions (question_text, Variant1, Variant2, Variant3, Variant4, Answer, test_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setString(1,questionText);
            preparedStatement.setString(2,variant1);
            preparedStatement.setString(3,variant2);
            preparedStatement.setString(4,variant3);
            preparedStatement.setString(5,variant4);
            preparedStatement.setInt(6,answer);
            preparedStatement.setInt(7,testID);
            preparedStatement.executeUpdate();
            
        }
    }


    public void update(String questionText, String variant1, String variant2, String variant3, String variant4, Integer answer, Integer testID) throws SQLException{

        String sqlCreateUser = "UPDATE oop_project.questions t SET t.question_text = ?, t.Variant1 = ?, t.Variant2 = ?, t.Variant3 = ?, t.Variant4 = ?, t.Answer = ?, t.test_id = ? WHERE t.id = ?";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {

            preparedStatement.setString(1,questionText);
            preparedStatement.setString(2,variant1);
            preparedStatement.setString(3,variant2);
            preparedStatement.setString(4,variant3);
            preparedStatement.setString(5,variant4);
            preparedStatement.setInt(6,answer);
            preparedStatement.setInt(7,testID);
            preparedStatement.setInt(8,this.id);
            preparedStatement.executeUpdate();
            
        }
        this.questionText=questionText;
        this.variant1=variant1;
        this.variant2=variant2;
        this.variant3=variant3;
        this.variant4=variant4;
        this.answer=answer;
        this.testID=testID;
    }

    public static void delete(Integer id) throws SQLException{

        String sqlCreateUser = "DELETE FROM oop_project.questions  WHERE id = ?";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement preparedStatement= conn.prepareStatement(sqlCreateUser)) {
            preparedStatement.setInt(1,id);;
            preparedStatement.executeUpdate();
            
        }
    }

    public void set(Integer id) throws SQLException, EmptyException {
        String sqlSelectUser = "SELECT * FROM questions WHERE id like '" + id + "'";
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement ps = conn.prepareStatement(sqlSelectUser);
             ResultSet rs = ps.executeQuery()) {
            int found=0;
            while (rs.next()) {
                found=1;
                this.id = rs.getInt("Id");
                this.questionText = rs.getString("question_text");
                this.variant1=rs.getString("variant1");
                this.variant2=rs.getString("variant2");
                this.variant3=rs.getString("variant3");
                this.variant4=rs.getString("variant4");
                this.answer=rs.getInt("answer");
                this.testID=rs.getInt("test_id");


               
                // do something with the extracted data...
            }
            if(found==0)
                throw new EmptyException();
        }
    }

    public static List<Question> getAllFromTest(Integer testID){
        List<Question> questionList = new ArrayList<Question>();
        String sqlSelectUser = "SELECT * FROM questions where test_id = "+testID;
        String connectionUrl = "jdbc:mysql://localhost:3306/OOP_Project?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "minecraft");
             PreparedStatement ps = conn.prepareStatement(sqlSelectUser);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Question addedQuestion = new Question();
                addedQuestion.setId(rs.getInt("Id"));
                addedQuestion.setQuestionText(rs.getString("question_text"));
                addedQuestion.setVariant1(rs.getString("variant1"));
                addedQuestion.setVariant2(rs.getString("variant2"));
                addedQuestion.setVariant3(rs.getString("variant3"));
                addedQuestion.setVariant4(rs.getString("variant4"));
                addedQuestion.setAnswer(rs.getInt("answer"));
                addedQuestion.setTestID(rs.getInt("test_id"));

                questionList.add(addedQuestion);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return questionList;
    }


    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getVariant1() {
        return variant1;
    }

    public void setVariant1(String variant1) {
        this.variant1 = variant1;
    }

    public String getVariant2() {
        return variant2;
    }

    public void setVariant2(String variant2) {
        this.variant2 = variant2;
    }

    public String getVariant3() {
        return variant3;
    }

    public void setVariant3(String variant3) {
        this.variant3 = variant3;
    }

    public String getVariant4() {
        return variant4;
    }

    public void setVariant4(String variant4) {
        this.variant4 = variant4;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }
}
