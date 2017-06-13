package de.oth.vs.rest;

import de.oth.vs.DB.DbHelper;
import de.oth.vs.entity.Exam;
import de.oth.vs.entity.Student;
import de.oth.vs.entity.TestPerformance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stt44293 on 13.06.2017.
 */
@Path("examaffairs")
public class ExamResource {
    public static final List<Student> database = new ArrayList<Student>();
    private DbHelper dbHelper = new DbHelper();


    @POST
    @Path("exam")
    @Consumes({MediaType.APPLICATION_JSON,	MediaType.APPLICATION_XML})
    public void addExam(TestPerformance tp){
        Statement stmt = null;
        Exam exam = null;
        Student student = null;
        try {
            stmt = dbHelper.connection.createStatement();
            String examQuery = "SELECT pruefungId, bezeichnung, ects FROM Pruefung WHERE pruefungId = '" + tp.getExamId()+"'";
            String studentQuery = "SELECT ects FROM Student WHERE matrikelNr = "+tp.getMatrikelNr();
            ResultSet r = stmt.executeQuery(examQuery);
            r.first();
            exam = new Exam(r.getString("pruefungId"), r.getString("bezeichnung"), r.getInt("ects"));
            ResultSet rs = stmt.executeQuery(examQuery);
            rs.first();
            int ects = rs.getInt("ects");

            String updateQuery = "UPDATE Student SET ects ="+(exam.getEcts()+ects);
            stmt.execute(updateQuery);

            String insertQuery = "INSERT INTO Pruefungsleistung (pruefungId, matrikelNr, versuch, note) VALUES('" +tp.getExamId() + "' , "+tp.getMatrikelNr()+" , " + tp.getTries()+ " , " + tp.getGrade()+ ")";
            stmt.execute(insertQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @GET
    @Path("exam/{id}")
    public TestPerformance getStudentSbById(@PathParam("id") int id) {
        Statement stmt = null;
        TestPerformance tp = null;
        try {
            stmt = dbHelper.connection.createStatement();
            String query = "SELECT id, pruefungId, matrikelNr, versuch, note FROM Pruefungsleistung WHERE id = " + id;
            ResultSet r = null;
            r = stmt.executeQuery(query);
            r.first();
            tp = new TestPerformance(r.getString("pruefungId"), r.getInt("matrikelNr"), r.getInt("versuch"), r.getDouble("note"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tp;

    }
}
