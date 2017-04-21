package client;

import Protocol.ProtocolContract.ProtocolEntry;

import java.io.*;
import java.net.Socket;
public class ClientEndpoint extends Thread implements IMessageSender {

    // Vorschlag fuer Attribute, bitte erweitern oder aendern:
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private IMessageGui messageGui;

    public ClientEndpoint() {

    }

    @Override
    public void run() {
        while (true) {
            try {
                String prefix = reader.readLine();
                switch (prefix) {
                    case ProtocolEntry.SHOW:messageGui.showNewMessage(reader.readLine(), reader.readLine()); break;
                    case ProtocolEntry.ADMIN: messageGui.showAdminMessage(reader.readLine()); break;
                    default: break;
                }



            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


    @Override
    public void openChatConnection(String username, String host, int port, IMessageGui messageGui) {
        this.messageGui = messageGui;

        try {
            Socket s = new Socket(host, port);
            System.out.println("Trying to connect as " + username + " to " + host + ":" + port);
            InputStream in = s.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            OutputStream out = s.getOutputStream();
            writer = new PrintWriter(out);

            writer.println(ProtocolEntry.OPEN);
            writer.println(username);
            writer.flush();
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendChatMessage(String message) {
        writer.println(ProtocolEntry.PUBLISH);
        writer.println(message);
        writer.flush();
    }

    @Override
    public void closeChatConnection() {
        writer.println(ProtocolEntry.EXIT);
        writer.flush();
    }
}
