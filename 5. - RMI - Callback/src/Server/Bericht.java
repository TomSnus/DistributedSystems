package Server;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jon on 04.05.2017.
 */
public class Bericht implements Serializable{
    private Date datum;
    private String diagnose;
    private String weiteresVorgehen;


    public Bericht(Date datum, String diagnose, String weiteresVorgehen) {
        this.datum = datum;
        this.diagnose = diagnose;
        this.weiteresVorgehen = weiteresVorgehen;
    }

    public String getBericht(){
        StringBuilder sb = new StringBuilder();
        sb.append("Bericht vom: ");
        sb.append(datum);
        sb.append("\n");
        sb.append("Diagnose" + diagnose + " weiteres Vorgehen: " + weiteresVorgehen);
        return sb.toString();
    }
}
