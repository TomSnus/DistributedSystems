package server.entity;


import java.rmi.RemoteException;
import java.util.Date;
import server.AufnahmewunschIF;
import static server.entity.Codec.MPEG4;

public class Aufnahmewunsch implements AufnahmewunschIF {
    private Date start = new Date(), ende = new Date();
    private Codec codec = MPEG4;

    // Construktor, equals, hashCode
    
    
    @Override
    public Date getStart() throws RemoteException {
        System.out.println("Aufnahmewunsch: getStart aufgerufen");
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Override
    public Date getEnde() throws RemoteException {
        System.out.println("Aufnahmewunsch: getEnde aufgerufen");
        return ende;
    }

    public void setEnde(Date ende) {
        this.ende = ende;
    }

    @Override
    public Codec getCodec()  throws RemoteException {
        System.out.println("Aufnahmewunsch: getCodec aufgerufen");
        return codec;
    }

    public void setCodec(Codec codec) {
        this.codec = codec;
    }

    public String ausgabe() {
        System.out.println("Aufnahmewunsch: ausgabe() aufgerufen");
        return "Aufnahmewunsch{" + "start=" + start + ", ende=" + ende + ", codec=" + codec + '}';
    }
    
    
}
