package Client;

import Server.Bericht;
import Server.FrueerkennungIF;
import Server.Roentgenbild;
import Server.RoentgenbildIF;
import com.sun.jndi.ldap.Ber;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * Created by Jon on 04.05.2017.
 */
public class Client {

    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 1099);
            FrueerkennungIF serverStub = (FrueerkennungIF) r.lookup("bericht");
           // Bericht bericht = feServer.analysieren(new Roentgenbild();
            RoentgenbildIF bild = new Roentgenbild(new Date(), "Test Person", new byte[10]);
            RoentgenbildIF roentgenbildStub = (RoentgenbildIF) UnicastRemoteObject.exportObject(bild, 0);
            Bericht b = serverStub.analysieren(roentgenbildStub);
            System.out.println(b.getBericht());
            System.out.println(bild);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
