package backEnd;

import javafx.scene.control.TextField;

import java.sql.*;

public class Database {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String url = "jdbc:oracle:thin:@localhost:1521/XE";
    static final String user = "HMSADMIN";
    static final String password = "ADMIN";

    public boolean validateAdminLogin(String emailId, String pass){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String SELECT_QUERY = "SELECT * FROM ADMIN WHERE ADM_USERNAME = ? and ADM_PASSWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1,emailId);
            preparedStatement.setString(2,pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean validateDoctorLogin(String emailId, String pass){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String SELECT_QUERY = "SELECT * FROM DOCTOR WHERE DOC_USERNAME = ? and DOC_PASSWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1,emailId);
            preparedStatement.setString(2,pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean validateReceptionistLogin(String emailId, String pass){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String SELECT_QUERY = "SELECT * FROM RECEPTIONIST WHERE REC_USERNAME = ? and REC_PASSWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1,emailId);
            preparedStatement.setString(2,pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void insertAdminRecord(String userEmail, String pass, String name, String gender, String address, String phoneNum){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String insertQuery = "INSERT INTO ADMIN (ADM_USERNAME, ADM_PASSWORD, ADM_NAME,ADM_GENDER, ADM_ADDRESS,ADM_NUMBER) VALUES (?, ?, ?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phoneNum);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertReceptionistRecord(String userEmail, String pass, String name, String gender, String address, String phoneNum){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String insertQuery = "INSERT INTO RECEPTIONIST (REC_USERNAME, REC_PASSWORD, REC_NAME,REC_GENDER, REC_ADDRESS,REC_NUMBER) VALUES (?, ?, ?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phoneNum);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertDoctorRecord(String userEmail, String pass, String name, String gender, String address,String designation, String phone){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String insertQuery = "INSERT INTO DOCTOR (DOC_USERNAME, DOC_PASSWORD, DOC_NAME,DOC_GENDER, DOC_ADDRESS,DOC_DESIGNATION, DOC_NUMBER) VALUES (?, ?, ?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6,designation);
            preparedStatement.setString(7, phone);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void makeAppointment(String name, String age, String gender, String address, String number,String docCode){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String insertQuery = "INSERT INTO APPOINTMENT (PAT_NAME, PAT_AGE, PAT_GENDER,PAT_ADDRESS, PAT_NUMBER,PAT_DOC_CODE) VALUES (?, ?, ?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, age);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, number);
            preparedStatement.setString(6,docCode);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void getPatientData(String AID, TextField name, TextField age, TextField gender){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String fetchQuery = "SELECT PAT_NAME,PAT_AGE,PAT_GENDER FROM APPOINTMENT WHERE AID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(fetchQuery);
            preparedStatement.setString(1,AID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String patName = resultSet.getString(1);
                String patAge = resultSet.getString(2);
                String patGender = resultSet.getString(3);
                name.setText(patName);
                age.setText(patAge);
                gender.setText(patGender);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void makePrescription(String AID, String date, String advice, String medicine){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);
            String insertQuery = "INSERT INTO PRESCRIPTION (PRESCRIPTION_ADVICE, PRESCRIPTION_DATE,MEDICINE, AID) VALUES (?, ?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,advice);
            preparedStatement.setString(2,date);
            preparedStatement.setString(3,medicine);
            preparedStatement.setString(4,AID);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}



