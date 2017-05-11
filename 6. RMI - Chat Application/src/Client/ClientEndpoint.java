package Client;

import Server.ICHatMessageHub;
import Server.IChatListener;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Created by Jon on 11.05.2017.
 */
public class ClientEndpoint implements IChatListener, IMessageSender {
    private ICHatMessageHub hub;
    private String username;
    private IChatListener thisStub;
    private Scanner sc = new Scanner(System.in);


    /** Displays Message in console
     * @param fromUser
     * @param message
     * @throws RemoteException
     */
    @Override
    public void onMessage(String fromUser, String message) throws RemoteException {
        System.out.println(fromUser + ": " + message);
    }

    /** Returns the Username
     * @return Username
     * @throws RemoteException
     */
    @Override
    public String getUsername() throws RemoteException {
        return username;
    }

    /** Connects the Client to the Server
     * @param username
     * @param registryHost
     * @param bindingName
     * @throws RemoteException
     */
    @Override
    public void openChatConnection(String username, String registryHost, String bindingName) throws RemoteException {
       // this.username = username;
        this.username = sc.nextLine();
        try {
            Registry registry = LocateRegistry.getRegistry(registryHost);
            thisStub = (IChatListener) UnicastRemoteObject.exportObject(this, 0);
            hub = (ICHatMessageHub) registry.lookup(bindingName);
            hub.addChatListener(thisStub);
            chat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /** Sends message to the Server
     * @param message
     * @throws RemoteException
     */
    @Override
    public void sendChatMessage(String message) throws RemoteException {
        hub.publish(username, message);
    }

    /** closes the connection
     * @throws RemoteException
     */
    @Override
    public void closeChatConnection() throws RemoteException {
        hub.removeChatListener(thisStub);
    }


    /**
     * Method to test the Application
     */
    private void chat() {
        String message;
        try {
            while(!(message = sc.nextLine().toLowerCase()).equals("exit")) {
                    hub.publish(username, message);
            }
            hub.removeChatListener(thisStub);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
