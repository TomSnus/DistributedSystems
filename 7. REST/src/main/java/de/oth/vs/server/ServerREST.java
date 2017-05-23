package de.oth.vs.server;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import javax.swing.JOptionPane;
import javax.ws.rs.ext.RuntimeDelegate;

import de.oth.vs.entity.Address;
import de.oth.vs.entity.Student;
import de.oth.vs.rest.StudentResource;
import org.glassfish.jersey.server.ResourceConfig;

public class ServerREST {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException {

        //Fill the Student-List with Data
        for(int i = 0; i < 250; i++){
            StudentResource.database.add(new Student(i, randomString(5), rnd.nextInt(300), new Address(randomString(10), randomString(7))));
        }
        
        ResourceConfig config = new ResourceConfig();
        config.register(StudentResource.class);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(config, HttpHandler.class);
        server.createContext("/webresources", handler);
        server.start();

        JOptionPane.showMessageDialog(null, "Server stoppen...");
        server.stop(0);
    }



    public static String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}
