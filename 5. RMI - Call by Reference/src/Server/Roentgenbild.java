package Server;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by Jon on 04.05.2017.
 */
public class Roentgenbild implements RoentgenbildIF{
    private Date aufnahmeVom;
    private transient String patientName;
    private byte[] rawData;

    public Roentgenbild(Date aufnahmeVom, String patientName, byte[] rawData) {
        this.aufnahmeVom = aufnahmeVom;
        this.patientName = patientName;
        this.rawData = rawData;
    }


    public void setAufnahmeVom(Date aufnahmeVom) {
        this.aufnahmeVom = aufnahmeVom;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

    @Override
    public String toString() {
        return aufnahmeVom + " " + patientName;
    }

    @Override
    public Date getDate() throws RemoteException {
        return aufnahmeVom;
    }
}
