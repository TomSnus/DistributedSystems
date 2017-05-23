package de.oth.vs.rest;

import de.oth.vs.entity.Address;
import de.oth.vs.entity.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 23.05.2017.
 */
@Path("studentaffairs")
public class StudentResource {
    List<Student> database = new ArrayList<Student>();

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
    public Student getStudentById(@PathParam("id") int id) {
        return new Student(id, "test", 123, new Address("test", "regensburg"));
    }

    @DELETE
    @Path("student/{id}")
    public void deleteStudentById(@PathParam("id") int id) {

    }


}
