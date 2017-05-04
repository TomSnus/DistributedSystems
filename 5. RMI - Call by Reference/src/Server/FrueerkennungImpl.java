package Server;

import java.rmi.RemoteException;

/**
 * Created by Jon on 04.05.2017.
 */
public class FrueerkennungImpl implements FrueerkennungIF {
    @Override
    public Bericht analysieren(RoentgenbildIF r) throws RemoteException {
        System.out.println("analysiere");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Bericht(r.getDate(), "nix", "weiteres vorgehen");
    }
}
