package Server;

import java.rmi.RemoteException;

/**
 * Created by Jon on 04.05.2017.
 */
public class FrueerkennungImpl implements FrueerkennungIF {


    @Override
    public Bericht analysieren(Roentgenbild r, CallbackIF referenz) throws RemoteException {
        System.out.println("analysiere");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        referenz.sendBericht();
        return new Bericht(r.getAufnahmeVom(), "nix", "weiteres vorgehen");


    }
}
