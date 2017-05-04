package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jon on 04.05.2017.
 */
public interface CallbackIF extends Remote{
    public void sendBericht() throws RemoteException;
}
