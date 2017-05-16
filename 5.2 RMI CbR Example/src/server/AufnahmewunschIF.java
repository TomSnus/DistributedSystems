package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import server.entity.Codec;

public interface AufnahmewunschIF extends Remote {
    // ???
    public Date getStart() throws RemoteException;
    public Date getEnde() throws RemoteException;
    public Codec getCodec() throws RemoteException;
    public String ausgabe() throws RemoteException;
}
