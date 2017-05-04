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
    public Bericht sendBericht(Date aufnahmeVom, String nix, String s) throws RemoteException {
        System.out.println("Daten erhalten");
        Bericht b = new Bericht(aufnahmeVom, nix, s);
        System.out.println("Bericht senden...");
        return b;
    }
}
