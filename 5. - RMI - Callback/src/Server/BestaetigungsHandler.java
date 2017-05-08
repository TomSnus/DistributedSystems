package Server;

/**
 * Created by Faßreiter on 08.05.2017.
 */
public class BestaetigungsHandler implements Runnable {

    private CallbackIF referenz;
    private Roentgenbild r;
    public BestaetigungsHandler(Roentgenbild r, CallbackIF referenz) {
        this.referenz = referenz;
        this.r = r;
    }


    @Override
    public void run() {
        try {
            System.out.println("Sende analysierte Daten");
            Bericht bericht = referenz.sendBericht(r.getAufnahmeVom(), "nix", "weiteres vorgehen");
            System.out.println("Bericht erhalten");
            System.out.println(bericht.getBericht());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
