/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import person.Student;

public class SQLDAOStudent implements DAOStudent{
    private String connectionUrl;

    public SQLDAOStudent(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
    

    @Override
    public List<Student> findStudent() {

        // Connection beheert informatie over de connectie met de database.
        Connection con = null;
        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;
        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery("SELECT * FROM Cursist");

            while (rs.next()) {
                String email = rs.getString("Email");
                String name = rs.getString("Name");
                Date birthday = rs.getDate("BirthDate");
                String gender = rs.getString("Gender");
                String address = rs.getString("Address");
                String residence = rs.getString("Residence");
                String country = rs.getString("Country");
                students.add(new Student(email,name,birthday,gender,address,residence,country));
                
            }
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
        return students;
    }
    
}
