package database;

//import erciyes.database.DatabaseInterface;
import model.User;
import java.sql.*;
import java.util.ArrayList;

public class Database implements DatabaseInterface {
    private static Database db = null;
    private static final String url = "*****";
    private static final String user = "*****";
    private static final String password = "******";
    private PreparedStatement preparedStatement;
    private Connection connection;
    private int userid = 0;
    private boolean flag = false;
    private int taxCount = 0;
    private static ArrayList<User> taxList;
    private static ArrayList<User> userInfo;

    public Database(){
        connection = getConnection();
    }

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }
        return db;
    }
    public Connection getConnection () {
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean logIN(String username, String pass) {
        flag = false;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM user_test WHERE (username,password)= (?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //userid = rs.getInt("id");
                flag = true;
            }

        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public boolean RegisterNewUser(String name, String username, String email, String password, String address) {
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO registration_page(fullname, username, email,password, address) VALUES (?,?,?,md5(?),?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, address);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;

        }
    }

    public ArrayList<User> userProfileInfo(String login) {
        userInfo = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT user.name,user.surname,user.email,user.login from user where user.login = (?)");
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //userInfo.add(new RegisterUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return userInfo;
    }

}