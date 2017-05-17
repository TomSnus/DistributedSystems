package Client;

import Server.CallbackIF;
import Server.Bericht;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by Jon on 04.05.2017.
 */
public class CallbackImpl implements CallbackIF {
    @Override
    public void sendBericht(Bericht bericht) throws RemoteException {
        System.out.println("Bericht erhalten erhalten");
        System.out.println(bericht.getBericht());
    }
}
