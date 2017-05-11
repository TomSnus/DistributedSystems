package Client;

import java.rmi.RemoteException;

/**
 * Created by Jon on 11.05.2017.
 */
public class Client {
    public static void main(String[] args) {
        ClientEndpoint ce = new ClientEndpoint();
        try {
            ce.openChatConnection("tom","localhost", "chatapplication");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
