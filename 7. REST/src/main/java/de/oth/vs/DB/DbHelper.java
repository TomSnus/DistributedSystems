package de.oth.vs.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import de.oth.vs.DB.DbContract;
/**
 * Created by stt44293 on 13.06.2017.
 */
public class DbHelper {
    public Connection connection = null;
    public DbHelper() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+DbContract.DB_Host+"/"+DbContract.DB, DbContract.DB_USERNAME, DbContract.DB_PW);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
