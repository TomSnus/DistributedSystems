package Server;

/**
 * Created by Jon on 04.05.2017.
 */
public class FrueerkennungImpl implements FrueerkennungIF {
    @Override
    public Bericht analysieren(Roentgenbild r) {
        System.out.println("analysiere");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Bericht(r.getAufnahmeVom(), "nix", "weiteres vorgehen");
    }
}
