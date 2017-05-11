package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jon on 11.05.2017.
 */
public interface IChatListener extends Remote{
    void onMessage(String fromUser, String message)throws RemoteException;
    String getUsername() throws RemoteException;
}
