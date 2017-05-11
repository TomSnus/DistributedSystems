package Server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jon on 11.05.2017.
 */
public class ChatServer implements ICHatMessageHub {

    private Map<String, IChatListener> listeners = new HashMap<>();

    public ChatServer() {

    }


    /** Adds a ChatListener
     * @param listener
     * @throws RemoteException
     */
    @Override
    public void addChatListener(IChatListener listener) throws RemoteException {
        if(!listeners.containsKey(listener.getUsername())){
            listeners.put(listener.getUsername(), listener);
        }
        System.out.println(listener.getUsername() + " " + "entered the Chat");

    }

    /** Removes a ChatListener
     * @param listener
     * @throws RemoteException
     */
    @Override
    public void removeChatListener(IChatListener listener) throws RemoteException {
        System.out.println(listener.getUsername() + " left the Chat");
        if(listeners.containsKey(listener.getUsername())){
            listeners.remove(listener.getUsername());
        }
    }

    /** Publishes the Message to all connected Clients
     * @param fromUser
     * @param message
     * @throws RemoteException
     */
    @Override
    public void publish(String fromUser, String message) throws RemoteException {
        Iterator it = listeners.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            IChatListener client = null;
            if(pair.getValue() instanceof IChatListener)
                client = ((IChatListener) pair.getValue());
                if(!client.getUsername().equals(fromUser)) //Avoid sending message to forwarder
                    client.onMessage(fromUser, message);
        }
    }
}
