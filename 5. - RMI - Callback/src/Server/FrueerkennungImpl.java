package Server;

import java.rmi.RemoteException;

/**
 * Created by Jon on 04.05.2017.
 */
public class FrueerkennungImpl implements FrueerkennungIF {


    @Override
    public void analysieren(Roentgenbild r, CallbackIF referenz) throws RemoteException {
        System.out.println("analysiere");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new BestaetigungsHandler(r, referenz)).start();




    }
}
