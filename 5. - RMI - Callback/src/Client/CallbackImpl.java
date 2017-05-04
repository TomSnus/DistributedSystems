package Client;

import Server.CallbackIF;

import java.rmi.RemoteException;

/**
 * Created by Jon on 04.05.2017.
 */
public class CallbackImpl implements CallbackIF {
    @Override
    public void sendBericht() throws RemoteException {
        System.out.println("test");
    }
}
