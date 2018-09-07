import javax.persistence.Entity;
import java.util.List;

@Entity
public class AsociatiaDeProprietari {
    private static volatile AsociatiaDeProprietari asociatiaDeProprietari;
    private List<Apartament> apartamentList;
    private final String IBAN;


    private AsociatiaDeProprietari(List<Apartament> apartamentList, String IBAN) {
        this.apartamentList = apartamentList;
        this.IBAN = IBAN;
    }
    public static AsociatiaDeProprietari getAsociatiaDeProprietari(List<Apartament> apartamentList, String IBAN){
        if (asociatiaDeProprietari == null){
            synchronized (AsociatiaDeProprietari.class){
                if (asociatiaDeProprietari == null){
                    asociatiaDeProprietari = new AsociatiaDeProprietari(apartamentList, IBAN);
                }
            }
        }
        return asociatiaDeProprietari;
    }

    public Apartament registerLocatar(Apartament ap, Locatar loc){
        ap.addLoc(loc);
        return ap;
    }

    public Apartament unregisterLocatar(Apartament ap, Locatar loc){
        ap.removeLoc(loc);
        return ap;
    }
}
