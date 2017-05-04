package Client;

import Server.Bericht;
import Server.CallbackIF;
import Server.FrueerkennungIF;
import Server.Roentgenbild;
import com.sun.jndi.ldap.Ber;

import java.rmi.RemoteException;
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
            FrueerkennungIF feServer = (FrueerkennungIF) r.lookup("bericht");
            CallbackIF callbackHandler = new CallbackImpl();
            CallbackIF callbackStub = (CallbackIF) UnicastRemoteObject.exportObject(callbackHandler, 0);
            feServer.analysieren(new Roentgenbild(new Date(), "Test Person", new byte[10]), callbackStub);
          //  System.out.println(bericht.getBericht());
        }catch (Exception e) {
            e.printStackTrace();
        }


    }


}
