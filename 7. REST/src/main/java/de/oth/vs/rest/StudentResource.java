package de.oth.vs.rest;

import de.oth.vs.DB.DbHelper;
import de.oth.vs.entity.Address;
import de.oth.vs.entity.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 23.05.2017.
 */
@Path("studentaffairs")
public class StudentResource {

    /** List with example Data **/
    public static final List<Student> STUDENT_LIST = new ArrayList<Student>();
    private DbHelper dbHelper = new DbHelper();

    /**
     *
     * example list operations
     *
     */

    /**
     * Add Student Object to example list
     * @param student
     */
    @POST
    @Path("student")
    @Consumes({MediaType.APPLICATION_JSON,	MediaType.APPLICATION_XML})
    public void addStudent(Student student){
        if(!STUDENT_LIST.contains(student)) {
            STUDENT_LIST.add(student);
        }
        System.out.println(student + "\n" + "added");
    }

    /**
     * Get Student from example list by ID
     * @param id
     * @return Student Object
     */
    @GET
    @Path("student/{id}")
    public Student getStudentSbById(@PathParam("id") int id) {
        return  STUDENT_LIST.stream().filter(i -> i.getId() == id).findFirst().get();
    }


    /**
     * Delete Student from example list by ID
     * @param id
     */
    @DELETE
    @Path("student/{id}")
    public void deleteStudentById(@PathParam("id") int id) {
        STUDENT_LIST.remove(STUDENT_LIST.stream().filter(i -> i.getId() == id).findFirst().get());
    }


    /**
     *
     * DB Operations
     *
     */


    /**
     * Select Student from Database by ID
     * @param id
     * @return Student Object
     */
    @GET
    @Path("studentdb/{id}")
    public Student getStudentById(@PathParam("id") int id) {
        Student returnStudent = null;

        try {

            Statement stmt = dbHelper.connection.createStatement();
            String query = "SELECT matrikelNr, vorname, nachname, ects, strasse, ort FROM Student WHERE matrikelNr = " + id;
            ResultSet r = stmt.executeQuery(query);
            r.first();
            returnStudent
                    = new Student(id,
                    r.getString("vorname") + " " + r.getString("nachname"),
                    r.getInt("ects"),
                    new Address(r.getString("strasse"), r.getString("ort")));
            dbHelper.connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return  returnStudent;
    }
}
