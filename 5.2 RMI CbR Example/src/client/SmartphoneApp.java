package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import server.AufnahmewunschIF;
import server.TvControllerIF;
import server.entity.Aufnahmewunsch;
import server.entity.Sendung;

public class SmartphoneApp {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        TvControllerIF stub = (TvControllerIF) reg.lookup("smarttvcontroller");
        
        Sendung sendung = stub.getAktuelleSendung();
        System.out.println("App: " + sendung.toString());
        stub.wechsleKanal(17);
        
        Aufnahmewunsch wunsch = new Aufnahmewunsch();
        AufnahmewunschIF wunschStub = (AufnahmewunschIF) UnicastRemoteObject.exportObject(wunsch, 0);
        stub.registriereAufnahmewunsch(wunschStub);
    }
}
