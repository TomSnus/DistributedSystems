package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by Jon on 04.05.2017.
 */
public interface CallbackIF extends Remote{
    public void sendBericht(Bericht b) throws RemoteException;


}
