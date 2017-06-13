package de.oth.vs.rest;

import de.oth.vs.DB.DbHelper;
import de.oth.vs.entity.Student;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stt44293 on 13.06.2017.
 */
@Path("examaffairs")
public class ExamResource {
    public static final List<Student> database = new ArrayList<Student>();
    private DbHelper dbHelper = new DbHelper();
}
