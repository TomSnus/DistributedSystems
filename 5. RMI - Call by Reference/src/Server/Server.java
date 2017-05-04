package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jon on 04.05.2017.
 */
public class Server {

    public static void main(String[] args) {
        try {
            FrueerkennungIF fe = new FrueerkennungImpl();
            FrueerkennungIF stub = (FrueerkennungIF) UnicastRemoteObject.exportObject(fe, 0);

            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("bericht", stub);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
