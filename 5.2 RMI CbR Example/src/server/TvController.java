package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import server.entity.Aufnahmewunsch;
import server.entity.Sendung;

public class TvController implements TvControllerIF {
    private int aktuellerKanal = 1;
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        TvControllerIF instanz = new TvController();
        TvControllerIF stub    = (TvControllerIF) UnicastRemoteObject.exportObject(instanz, 0);
        
        LocateRegistry.createRegistry(1099);
        
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        reg.bind("smarttvcontroller", stub);
        
        System.out.println("TvController: up and listening...");
    }

    @Override
    public Sendung getAktuelleSendung() throws RemoteException {
        System.out.println("TvController: sende aktuelle Sendung");
        return new Sendung("Tatort", "einer stirbt, zwei ermitteln");
    }

    @Override
    public void registriereAufnahmewunsch(AufnahmewunschIF aufnahmewunsch) throws RemoteException {
        System.out.println("TvController: Aufname von " + aufnahmewunsch.ausgabe());
    }

    @Override
    public void wechsleKanal(int neuerKanal) throws RemoteException {
        System.out.println("TvController: Wechsel von Kanal " + aktuellerKanal + " auf " + neuerKanal);
        this.aktuellerKanal = neuerKanal;
    }
}
