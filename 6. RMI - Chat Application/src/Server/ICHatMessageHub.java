package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jon on 11.05.2017.
 */
public interface ICHatMessageHub extends Remote{
    void addChatListener(IChatListener listener)throws RemoteException;
    void removeChatListener(IChatListener listener) throws RemoteException;
    void publish(String fromUser, String message) throws RemoteException;
}
