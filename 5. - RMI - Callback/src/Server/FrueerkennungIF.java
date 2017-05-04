package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jon on 04.05.2017.
 */
public interface FrueerkennungIF extends Remote {
    public Bericht analysieren(Roentgenbild r, CallbackIF referenz) throws RemoteException;
}
