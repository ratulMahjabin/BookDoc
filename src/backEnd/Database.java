package backEnd;

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
}



