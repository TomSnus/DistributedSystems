package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jon on 11.05.2017.
 */
public interface IMessageSender extends Remote {
    void openChatConnection(String username, String registryHost, String bindingName) throws RemoteException;
    void sendChatMessage(String message) throws RemoteException;
    void closeChatConnection()throws RemoteException;
}
