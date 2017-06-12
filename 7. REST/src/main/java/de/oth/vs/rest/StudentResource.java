package de.oth.vs.rest;

import com.mysql.cj.api.mysqla.result.Resultset;
import de.oth.vs.entity.Address;
import de.oth.vs.entity.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 23.05.2017.
 */
@Path("studentaffairs")
public class StudentResource {
    public static final List<Student> database = new ArrayList<Student>();

    @POST
    @Path("student")
    @Consumes({MediaType.APPLICATION_JSON,	MediaType.APPLICATION_XML})
    public void addStudent(Student student){
        if(!database.contains(student)) {
            database.add(student);
        }
        System.out.println(student + "\n" + "added");
    }

    @GET
    @Path("student/{id}")
    public Student getStudentSbById(@PathParam("id") int id) {
        return  database.stream().filter(i -> i.getId() == id).findFirst().get();
    }

    @GET
    @Path("studentdb/{id}")
    public Student getStudentById(@PathParam("id") int id) {
        Student returnStudent = null;
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");
            Statement stmt = c.createStatement();
            String query = "SELECT matrikelNr, vorname, nachname, ects, strasse, ort FROM Student WHERE matrikelNr = "+id;
            ResultSet r = stmt.executeQuery(query);
            r.first();
            returnStudent
                    = new Student(id,
                    r.getString("vorname")+" "+r.getString("nachname"),
                    r.getInt("ects"),
                    new Address(r.getString("strasse"), r.getString("ort")));
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  returnStudent;
    }

    @DELETE
    @Path("student/{id}")
    public void deleteStudentById(@PathParam("id") int id) {
        database.remove(database.stream().filter(i -> i.getId() == id).findFirst().get());
    }


}
