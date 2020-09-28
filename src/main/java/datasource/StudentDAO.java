package datasource;

import dto.MicStudent;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Michel Koolwaaij on 07-10-16.
 */
public class StudentDAO {
    private Logger logger = Logger.getLogger(getClass().getName());
    String URL;
    String USER;
    String PASS;

    Connection connection;
    PreparedStatement ps;
    Properties properties;

    public StudentDAO(){
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(properties.getProperty("connectionString"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void prepareStatementOneStudent(){
        try {
            ps = connection.prepareStatement("SELECT * FROM STUDENT WHERE NR=?");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void prepareStatementAllStudents(){
        try {
            ps = connection.prepareStatement("SELECT * from student");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getVoornaam(int id) throws SQLException {
        return getResults(id).getString("voornaam");

    }

    public String getAchternaam(int id) throws SQLException {
        return getResults(id).getString("achternaam");

    }

    public String getEmail(int id) throws SQLException {
        return getResults(id).getString("mail");

    }

    public MicStudent getStudent(int id) throws SQLException {
        MicStudent s= new MicStudent();
        this.prepareStatementOneStudent();
        s.setNummer(id);
        s.setNaam(getVoornaam(id)+" "+getAchternaam(id));
        s.setEmailadres(getEmail(id));

        return s;
    }


    private ResultSet getResults(int id){
        ResultSet rs = null;
        try {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.first();
        } catch (SQLException e){
            System.out.println("Fout hierzo");
            e.printStackTrace();

        }
        return rs;
    }

    public List<MicStudent> findAll() {
        List<MicStudent> studenten = new ArrayList<>();
        try {
            prepareStatementAllStudents();
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MicStudent student = new MicStudent(resultSet.getString("voornaam")
                        ,resultSet.getInt("nr")
                        ,resultSet.getString("mail")
                        ,resultSet.getString("telefoon"));
                studenten.add(student);
            }
            ps.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + properties.getProperty("connectionString"), e);
        }
        return studenten;
    }

    //public void
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
