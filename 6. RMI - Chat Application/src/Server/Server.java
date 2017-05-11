package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jon on 11.05.2017.
 */
public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            ICHatMessageHub instance = new ChatServer();
            ICHatMessageHub stub = (ICHatMessageHub) UnicastRemoteObject.exportObject(instance, 0);
            registry.bind("chatapplication", stub);
            System.out.println("Chatserver running...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
